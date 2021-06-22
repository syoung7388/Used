import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import '@fortawesome/fontawesome-free/js/all.js';
import io  from 'socket.io-client';


//npm install vue-socket.io 설치 필수
 


export const eventBus  = new Vue()

const socket = io('http://3.34.22.100:2100',  { transports: ['websocket'] })
//const socket = io('http://localhost:2100',  { transports: ['websocket'] })

Vue.prototype.$socket = socket

Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
