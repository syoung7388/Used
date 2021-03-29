import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    show: false,
    certi: null,


  },
  mutations: {
    certiSuccess(state, payload){
      state.show= true
      state.certi=payload
    }
  },
  actions: {
    sms({commit}, payload){
      axios
      .post('http://localhost:9200/api/sms/sendSMS', payload)
      .then(res => {
        console.log(res.data)
        alert("전송완료")
        commit('certiSuccess', res.data)
      })
      .catch(()=>{
        alert("오류")
      })
    },
    certification({state},payload){

      if(payload === state.certi){
      alert("인증완료")
      router.push({ name: Signup })
      } else{
        alert("인증번호가 틀립니다.")
      }
    }
    
    
  },
  modules: {
  }
})
