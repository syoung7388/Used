import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import vuetify from './plugins/vuetify';
import '@fortawesome/fontawesome-free/js/all.js';
import VueDaumPostcode from "vue-daum-postcode";
import ExportTypography from 'antd/lib/typography/Typography';

 
Vue.use(VueDaumPostcode)

export const eventBus  = new Vue()
// window.addEventListener('message', function(e){
//   if(e.data.event === 'warranty-transaction-success'){
//     eventBus.$emit('warranty-order-finalize', e.data.data)
//   }
// })


Vue.config.productionTip = false

new Vue({
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount('#app')
