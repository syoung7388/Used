import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Pshow: false,
    certi: null,
    Sshow:false,
    phone: null
  
  },
  mutations: {
    certiSuccess(state, payload){
      state.Pshow= true;
      state.certi= payload.numStr;
      state.phone= payload.phone;
      alert(state.certi)
    },
    Address(state){
      state.Sshow= true
    },
    setPhone(state, payload){
      state.phone = payload
      console.log(state.phone)
    }

  

  },
  actions: {
    sms({commit}, payload){//인증문자
      axios
      .post('http://localhost:9200/api/user/sendSMS', payload)
      .then(res => {
        alert("전송완료")
        commit('certiSuccess', res.data)
      })
      .catch(()=>{
        alert("오류")
      })
    },
    certification({state, commit}, payload){//인증번호 (payload-user가 적음) = /!=  인증번호 (백에서 가져온거)   
      
      console.log(state.certi)
      console.log(payload)

      if(payload.certinum === state.certi){
        alert("인증완료")
        commit('Address')

      } else{
        alert("인증번호가 틀립니다.")
      }
    },
    signup({state,commit}, payload){ //회원가입 정보 백엔드로 보내는 함수

      console.log(payload)
      axios
      .post('http://localhost:9200/api/user/signup', payload)
      .then( Sres => {
        if(Sres.data === "success"){
          console.log("성공")
        }
      })
      .catch(()=> {
        alert("오류")
      })
    }


  },

  modules: {

  }
})
