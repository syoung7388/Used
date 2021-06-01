import Vue from 'vue';
import App from './App.vue';
import Router from './router/index.js';
import store from './store/index.js';
import vuetify from './plugins/vuetify';
import '@fortawesome/fontawesome-free/js/all.js';
import io  from 'socket.io-client';

 


export const eventBus  = new Vue()

const socket = io('http://192.168.1.46:2100',  { transports: ['websocket'] })


Vue.prototype.$socket = socket



Vue.use(Router)

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
