import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
  },
  mutations: {
  },
  actions: {
    sms({commit}, payload){
      axios
      .post('http://localhost:9200/api/sms/sendSMS', payload)
      .then(res => {
        console.log(res.data.numStr);
        alert("전송완료")

      })
      .catch(()=>{
        alert("오류")
      })
    }
    
  },
  modules: {
  }
})
