import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import '@fortawesome/fontawesome-free/js/all.js';
import ExportTypography from 'antd/lib/typography/Typography';
import io  from 'socket.io-client';
// import Directives from '@/plugins/directive'

//npm install vue-socket.io 설치 필수 인듯
 


export const eventBus  = new Vue()
// window.addEventListener('message', function(e){
//   if(e.data.event === 'warranty-transaction-success'){
//     eventBus.$emit('warranty-order-finalize', e.data.data)
//   }
// })

const socket = io('http://localhost:7000')
Vue.prototype.$socket = socket
// Vue.use(Directives)


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
