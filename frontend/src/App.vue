<template>
  <div class="flex flex-col h-screen">
    <!-- Navbar -->
    <nav class="bg-gray-800 shadow">
      <div class="max-w-7xl mx-auto px-2 sm:px-6 lg:px-8">
        <div class="relative flex items-center justify-between h-16">
          <!-- Logo -->
          <div class="flex-shrink-0 flex items-center">
            <img class="h-8 w-8" src="@/assets/logo.png" alt="Logo" />
            <span class="text-white ml-2 font-bold">My App</span>
          </div>
          <!-- Links -->
          <div
            class="flex-1 flex items-center justify-center sm:items-stretch sm:justify-start"
          >
            <div class="hidden sm:block sm:ml-6">
              <div class="flex space-x-4">
                <router-link
                  to="/items"
                  class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  active-class="bg-gray-900"
                >
                  Items
                </router-link>

                <router-link
                  to="/search"
                  class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  active-class="bg-gray-900"
                >
                  Search
                </router-link>

                <a
                  class="text-gray-300 hover:bg-gray-700 hover:text-white px-3 py-2 rounded-md text-sm font-medium"
                  href="#"
                  @click.prevent="indexAll"
                >
                  Index All
                </a>
              </div>
            </div>
          </div>
        </div>
      </div>
    </nav>

    <!-- Content -->
    <div class="flex-1 overflow-auto">
      <router-view style="height: calc(100vh - 4rem)"></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: "App",
  methods: {
    async indexAll() {
      try {
        const response = await fetch("/index");
        const data = await response.json();
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    },
  },
};
</script>

<style></style>
