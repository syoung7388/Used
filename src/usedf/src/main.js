import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import '@fortawesome/fontawesome-free/js/all.js';
import VueDaumPostcode from "vue-daum-postcode";
 
Vue.use(VueDaumPostcode)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
