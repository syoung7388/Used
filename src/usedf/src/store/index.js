import Vue from 'vue'
import Vuex, { createLogger } from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'
import Form from 'antd/lib/form/Form'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Pshow: false,
    Sshow:false,
    Ashow: 0,
    removeBar: false,
    EPshow: false,
    Eshow: false,
    list_show: true,
    ImageList:[],
    
    
    certi: null,
    phone: null,
    username: null,
    password: null,


    isLoginError: false,
    phoneError:false,
    certiError: false,
    WritingError: false,
  

    userInfo: {},
    saleList: [],
    soldList:[],
    pictureList:[],

    productInfo:[],
    beforeImage:[],



    writingInfo:[],
    


    //saleList~saleDetial
    sale_show: 0,
    address_show: false,
    SaleEdit_error:false,
    

 
      
    


    te: null,


  
  },
  mutations: {
    phoneSuccess(state, payload){
      state.Pshow= true;
      state.EPshow= true;
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
      state.userInfo= {
        name: payload.name,
        username: payload.username,
        password: payload.password,
        phone: payload.phone,
        address: payload.address,
        u_num: payload.u_num

      }
      console.log(state.userInfo)
    
      state.isLoginError= false

    },

    LoginFaile(state){
      state.isLoginError=true
    },
    EditSuccess(state, payload){
      state.userInfo= {
        name: payload.name,
        username: payload.username,
        password: payload.password,
        phone: payload.phone,
        address: payload.address,
        u_num: payload.u_num
      }
      state.Eshow= false
      router.push({name: 'MyPage'})

    },
    DeleteSuccess(state){

      state.Ashow = 0
      router.push({name: 'App'})

    },
    WritingFaile(state){
      state.WritingError= true
    },
    WritingSuccess(){
      router.push({name: 'Home'})
    },
    getSaleListSuccess(state, payload){
      state.saleList= payload.saleList
      state.soldList= payload.soldList
      // console.log(state.soldList)
    },
    SaledetailSuccess(state, payload){
      state.list_show= !state.list_show
      state.productInfo= payload
      state.removeBar= true
      state.beforeImage= payload.picture
      
    },
    SaleEdit_s(state){
      state.sale_show = 0
      state.list_show= !state.list_show

    },

    SaleEdit_f(state){

    },


  },
  actions: {

    Alogin({state}){ //App.vue -> login페이지 전환
      state.Ashow =1
    },
    Asignup({state}){ //App.vue-> signup페이지 전환
      state.Ashow =2
    },
    RemoveBar({state}){ // 하단바 제거하는 함수
      state.removeBar= true
    },
    Editback({state}) { /// Edit&Delete -> deleteMyPage로 돌아가는 함수
      state.Eshow= false
      router.back()

    },
    Homeback({state}){///  MyPage -> Home으로 돌아가는 함수
      state.removeBar=false
      router.push({name: 'Home'})
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
    getUserInfo({commit, dispatch}){ //토큰 이용해서 유저정보 얻어오기
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
        commit('LoginSuccess', Ires.data)
      
      
      })
    },
    EditOK({state, commit}){///UserEdit마무리 
      let userInfo= state.userInfo
      
      console.log(userInfo)
      axios
      .post('http://localhost:9200/api/user/edit', userInfo)
      .then(Eres =>{
        console.log("수정완료")
        console.log(Eres.data)
        commit('EditSuccess', Eres.data)
        
      })
      .catch(() => {
        console.log("실패")
      })

    },
    deleteOK({state,commit}){ ///삭제하러 가는 함수
      let username= state.userInfo.username
      console.log(username)
      
      axios
      .delete(`http://localhost:9200/api/user/delete/${username}`)
      .then(Dres =>{
        if(Dres.data === "success"){
          alert("삭제 성공")
          commit('DeleteSuccess')

        }
      })
      .catch(() => {
        console.log("실패")
      })
      
    },




    WritingOK({state, commit}, payload){/// 게시물 작성 내용 DB전달

      let token = localStorage.getItem("access_token")
      let config={
        headers: {
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }

      let formData = new FormData()

       
      formData.append('title', payload.title)
      formData.append('content',payload.content)
      formData.append('industry',payload.industry)
      formData.append('kind',payload.kind)
      formData.append('brand',payload.brand)
      formData.append('year',payload.year)
      formData.append('startprice',payload.startprice)
      formData.append('address', payload.fullAddress)

      for(let i=0; i< payload.files.length; i++){
        formData.append('multipartfile',payload.files[i])
      }
      
  
      axios
      .post('http://localhost:9200/api/product' , formData, config)
      .then(wres=>{
        if(wres.data === "success"){
          commit('WritingSuccess')
        }
      })
      .catch(()=>{
        commit('WritingFaile')
      })
    },



    getSaleList({state ,commit}){
      state.list_show =  true
      let token = localStorage.getItem("access_token")
      let config={
        headers: {
          "access_token": token
        }
      }
      axios
      .get('http://localhost:9200/api/product/salelist', config)
      .then(lres=> {
        commit('getSaleListSuccess', lres.data)
        
        
      })
      .catch(()=>{
        alert("오류")
      })
    },
    getSaledetail({state, commit}, payload){
      console.log(payload)

      axios
      .get(`http://localhost:9200/api/product/saledetail?p_num=${payload.p_num}`)
      .then(Dres =>{
        commit('SaledetailSuccess', Dres.data)
      })
      .catch(()=>{
        alert("오류")
      })
    },
    SaleEditOK({dispatch, commit},payload){
    

      let token= localStorage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }


      let formData= new FormData()
      formData.append('title', payload.title)
      formData.append('content', payload.content)
      formData.append('industry', payload.industry)
      formData.append('kind', payload.kind)
      formData.append('brand', payload.brand)
      formData.append('year', payload.year)
      formData.append('startprice', payload.startprice)
      formData.append('p_num', payload.p_num)
      formData.append('address', payload.address)

      for(let i=0 ; i< payload.picture.length ; i++){
        formData.append('multipartfile', payload.picture[i])
      }
      for(let i=0; i< payload.pi_numList.length; i++){
        formData.append('pi_nums', payload.pi_numList[i])
      }
      axios
      .post('http://localhost:9200/api/product/edit',  formData, config)
      .then(Seres =>{
        if(Seres.data === "success"){
          let p_num = payload.p_num
          dispatch('getSaledetail', {p_num: p_num})
          commit('SaleEdit_s')

        }
      })
      .catch(()=>{
        commit('SaleEdit_f')
      })
    },

    SaleDeleteOK({dispatch, state}, payload){
      let p_num = payload.p_num
      axios
      .delete(`http://localhost:9200/api/product/${p_num}`)
      .then(Dres =>{
        if(Dres.data === "success"){
          router.push({name: 'SaleList'})
          state.removeBar = false
          dispatch('getSaleList')
        }
      })
      .catch(()=>{
        alert("삭제 오류")
      })

    }
  
 


  }
})