import { createRouter, createWebHistory } from "vue-router";
import ItemPage from "@/components/ItemPage.vue";
import SearchComponent from "@/components/SearchComponent.vue";

const routes = [
  { path: "/", redirect: "/search" },
  { path: "/items", component: ItemPage },
  { path: "/search", component: SearchComponent },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
