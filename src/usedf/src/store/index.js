import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Pshow: false,
    Sshow:false,
    Ashow: 0,
    removeBar: false,
    
    
    certi: null,
    phone: null,
    username: null,
    password: null,


    isLoginError: false,
    phoneError:false,
    certiError: false,

    userInfo: null,


  
  },
  mutations: {
    phoneSuccess(state, payload){
      state.Pshow= true;
      state.certi= payload.numStr;
      state.phone= payload.phone;
      console.log(state.certi)
    },
    
    phoneFaile(){
      state.phoneError= true
    },
    
    certiSuccess(state){
      state.Sshow= true
    },
    certiFaile(state){
      state.certiError= true

    },
    setPhone(state, payload){
      state.phone = payload
      console.log(state.phone)
    },
    LoginSuccess(state, payload){
      state.userInfo= payload
      state.isLoginError= false

    },

    LoginFaile(state){
      state.isLoginError=true
    }

  

  },
  actions: {

    Alogin({state}){ //App.vue에서 login페이지 전환
      state.Ashow =1
    },
    Asignup({state}){ //App.vue에서 signup페이지 전환
      state.Ashow =2
    },
    RemoveBar({state}){
      state.removeBar= true
    },


    ///////////////////////////////////////////////////////////////////////////////////////////////페이지 전환 함수 & 페이지 요소 조정 함수

    sms({commit}, payload){//인증문자
      axios
      .post('http://localhost:9200/api/user/sendSMS', payload)
      .then(res => {
        commit('phoneSuccess', res.data)
      })
      .catch(()=>{
        commit('phoneFaile')
      })
    },
    certification({state, commit}, payload){//인증번호 (payload-user가 적음) = /!=  인증번호 (백에서 가져온거)   
      
      console.log(state.certi)
      console.log(payload)

      if(payload.certinum === state.certi){
        commit('certiSuccess')

      } else{
        commit('certiFaile')
      }
    },
    signup({state}, payload){ //회원가입 정보 백엔드로 보내는 함수

      console.log(payload)
      axios
      .post('http://localhost:9200/api/user/signup', payload)
      .then( Sres => {
        if(Sres.data === "success"){
          console.log("성공")
          state.Ashow = 0

        }
      })
      .catch(()=> {
        alert("오류")
      })
    },
    login({dispatch, commit , state}, payload){ //Login.vue에서 login요청하는 함수
      axios
      .post('http://localhost:9200/api/user/login', payload)
      .then(Lres =>{
        console.log("로그인 완료")
        let token = Lres.data.token
        console.log(token)
        localStorage.setItem("access_token", token)
        dispatch('getUserInfo')
        state.Ashow= 3 //다끝나고 Main으로 가라 !
      })
      .catch(()=>
        commit('LoginFaile')
      )
    },
    getUserInfo({commit}){ //토큰 이용해서 유저정보 얻어오기
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get('http://localhost:9200/api/user/unpackToken', config)
      .then( Ires =>{
        console.log(Ires.data)
        let userInfo={
          username: Ires.data.username,
          name: Ires.data.name,
          phone: Ires.data.phone,
          address: Ires.data.address
        }
        commit('LoginSuccess', userInfo)
      
      })
    }



  },

  modules: {

  }
})



