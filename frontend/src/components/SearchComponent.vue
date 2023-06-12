<template>
  <div class="flex flex-col justify-center h-screen bg-gray-100">
    <form
      class="flex flex-col items-center justify-center"
      style="margin-top: -4rem"
    >
      <div class="relative flex items-center justify-center w-full max-w-3xl">
        <input
          v-model="query"
          type="text"
          class="w-full p-4 bg-white border border-gray-300 rounded-full shadow-sm placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
          placeholder="Search..."
          @input="suggest"
        />
        <button
          type="submit"
          class="absolute right-0 px-6 py-3 bg-blue-500 text-white rounded-full hover:bg-blue-700 focus:outline-none focus:bg-blue-700"
        >
          <svg
            class="w-6 h-6 fill-current"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 24 24"
          >
            <path
              d="M20.71,19.29l-5.42-5.42a7.93,7.93,0,1,0-1.42,1.42l5.42,5.42a1,1,0,0,0,1.42,0A1,1,0,0,0,20.71,19.29ZM9,16a5,5,0,1,1,5-5A5,5,0,0,1,9,16Z"
            />
          </svg>
        </button>
      </div>
      <div
        v-if="suggestions.length > 0"
        class="w-full max-w-3xl mt-2 bg-white border border-gray-300 rounded-lg shadow-lg divide-y divide-gray-300"
      >
        <ul class="divide-y divide-gray-300">
          <li
            v-for="suggestion in suggestions"
            :key="suggestion.id"
            class="px-4 py-2 cursor-pointer hover:bg-gray-100"
            @click="selectSuggestion(suggestion)"
          >
            {{ suggestion.title }}
          </li>
        </ul>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      query: "",
      suggestions: [],
    };
  },
  methods: {
    search() {
      if (this.query) {
        const url = `/search?q=${encodeURIComponent(this.query)}`;
        fetch(url)
          .then((response) => response.json())
          .then((data) => {
            // Do something with the search results here
            console.log("Search results:", data);
          })
          .catch((error) => {
            console.error("Error while searching:", error);
          });
      }
    },
    suggest() {
      if (this.query) {
        const url = `/suggest?q=${encodeURIComponent(this.query)}`;
        fetch(url)
          .then((response) => response.json())
          .then((data) => {
            this.suggestions = data;
            console.log("Suggest results:", data);
          })
          .catch((error) => {
            console.error("Error while suggesting:", error);
          });
      } else {
        this.suggestions = [];
      }
    },
    selectSuggestion(suggestion) {
      this.query = suggestion.title;
      this.suggestions = [];
    },
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style></style>
