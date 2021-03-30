import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    pshow: false,
    certi: null,
    ashow:false,


  },
  mutations: {
    certiSuccess(state, payload){
      state.pshow= true;
      state.certi= payload;
      alert(state.certi)
    },
    Address(state){
      state.ashow= true
    }

  

  },
  actions: {
    sms({commit}, payload){
      axios
      .post('http://localhost:9200/api/sms/sendSMS', payload)
      .then(res => {
      
        alert("전송완료")
        commit('certiSuccess', res.data)
      })
      .catch(()=>{
        alert("오류")
      })
    },
    certification({state, commit}, payload){
      
      console.log(state.certi)
      console.log(payload)

      if(payload.certinum = state.certi){
        alert("인증완료")
        commit('Address')

      } else{
        alert("인증번호가 틀립니다.")
      }
    }
    
    
  },
  modules: {

  }
})
