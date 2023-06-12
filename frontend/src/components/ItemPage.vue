<template>
  <div class="flex flex-row h-screen">
    <div class="w-1/4 px-4 py-8 bg-gray-100 border-r">
      <h2 class="mb-4 text-lg font-semibold">My Items</h2>
      <ul>
        <li
          v-for="(item, index) in items"
          :key="item.id"
          class="cursor-pointer flex items-center justify-between border-b py-2"
        >
          <div class="flex-grow-1" @click="editItem(item.id)">
            <div class="font-semibold">{{ item.title }}</div>
            <div class="text-sm text-gray-600">{{ item.description }}</div>
          </div>
          <div class="flex items-center">
            <button
              class="text-green-500 hover:text-green-700"
              @click.prevent="editItem(item.id)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-6 w-6"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M5 13l4 4L19 7"
                />
              </svg>
            </button>
            <button
              class="text-red-500 hover:text-red-700 ml-2"
              @click.prevent="deleteItem(item.id, index)"
            >
              <svg
                xmlns="http://www.w3.org/2000/svg"
                class="h-6 w-6"
                fill="none"
                viewBox="0 0 24 24"
                stroke="currentColor"
              >
                <path
                  stroke-linecap="round"
                  stroke-linejoin="round"
                  stroke-width="2"
                  d="M6 18L18 6M6 6l12 12"
                />
              </svg>
            </button>
          </div>
        </li>
      </ul>
    </div>
    <div class="w-3/4 px-4 py-8">
      <h2 class="mb-4 text-lg font-semibold">Create New Item</h2>
      <form @submit.prevent="editItemId ? saveItem() : addItem()">
        <div class="mb-4">
          <label class="block mb-2 font-semibold">Title</label>
          <input
            v-model.trim="title"
            type="text"
            class="w-full p-2 border rounded-lg"
          />
        </div>
        <div class="mb-4">
          <label class="block mb-2 font-semibold">Description</label>
          <textarea
            v-model.trim="description"
            class="w-full p-2 border rounded-lg"
          ></textarea>
        </div>
        <div>
          <button
            type="submit"
            class="px-4 py-2 bg-blue-500 text-white rounded-lg hover:bg-blue-600"
          >
            {{ editItemId ? "Save" : "Add" }}
          </button>
        </div>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      title: "",
      description: "",
      items: [],
      editItemId: null,
    };
  },
  methods: {
    async addItem() {
      const response = await fetch("/api/items", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          title: this.title,
          description: this.description,
        }),
      });
      const newItem = await response.json();
      this.items.push(newItem);
      this.title = "";
      this.description = "";
    },
    async editItem(id) {
      this.editItemId = id;
      const item = await this.fetchItem(id);
      this.title = item.title;
      this.description = item.description;
    },
    async saveItem() {
      const itemIndex = this.items.findIndex((i) => i.id === this.editItemId);
      if (itemIndex === -1) {
        return;
      }
      const updatedItem = {
        ...this.items[itemIndex],
        title: this.title,
        description: this.description,
      };
      const response = await fetch(`/api/items/${this.editItemId}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(updatedItem),
      });
      const savedItem = await response.json();
      this.items.splice(itemIndex, 1, savedItem);
      this.title = "";
      this.description = "";
      this.editItemId = null;
    },
    async deleteItem(id, index) {
      if (confirm("Are you sure you want to delete this item?")) {
        await fetch(`/api/items/${id}`, {
          method: "DELETE",
        });
        this.items.splice(index, 1);
        if (this.editItemId === id) {
          this.title = "";
          this.description = "";
          this.editItemId = null;
        }
      }
    },
    async fetchItem(id) {
      const response = await fetch(`/api/items/${id}`);
      return response.json();
    },
    formatDate(date) {
      return new Date(date).toLocaleString();
    },
    async fetchItems() {
      const response = await fetch("/api/items");
      this.items = await response.json();
    },
  },
  mounted() {
    this.fetchItems();
  },
};
</script>

<style scoped></style>
