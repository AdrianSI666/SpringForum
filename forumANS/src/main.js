import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueJwtDecode from 'vue-jwt-decode'

import { FontAwesomeIcon } from './plugins/font-awesome'
createApp(App)
  .use(router)
  .use(store)
  .component("font-awesome-icon", FontAwesomeIcon)
  .mount("#app");

