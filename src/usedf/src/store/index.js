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
    edit_show: false,
    address_show: false,
    Edit_error:false,
    


    Lat: null,
    Lon: null,


    topList:[],
    industryList: [],
    I_list_show: false,



    detail_show: true,
    edit_addr: false,
    DetailEdit_error: false,
    overlay: false,
    price: 0 ,
    
    

    kindList: [],
    backType: null,
    editType: null,
    beforeType: null,


    bidingList:[],
    bidList:[],
 
      
    aucType: null,


    te: null,
    heart: null,


    likeList: [],
    Writingshow: true,


  
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
    Saledetail_s(state, payload){
      state.list_show= !state.list_show
      state.productInfo= payload
      state.removeBar= true
      state.beforeImage= payload.picture
      
    },
    SaleEdit_s(state){
      state.edit_show = false
      state.list_show= !state.list_show

    },

    SaleEdit_f(state){

    },
    LatLon_s(state, payload){
      state.topList = payload
      state.removeBar = false
      router.push({name: 'Home'})
    },
    IndustryList_s(state, payload){
      state.industryList = payload
      state.I_list_show = true
      router.push({name: 'IndustryList'})
    },
    Detail_s(state, payload){
      state.removeBar = true
      state.productInfo= payload
      state.beforeImage= payload.picture



      if(payload.like === null){ state.heart = false }else{ state.heart = true}

      if(state.beforeType === "offer"){
        
        state.overlay = false
        
      }else{
        console.log("DD")
        router.push({name:'Detail'})
      
      }
    },
    DetailEdit_s(state, payload){

     setTimeout(()=>{
        state.productInfo = payload
        state.beforeImage = payload.picture
        state.removeBar = true
        state.detail_show = true

      }, 2000)

    },
    KIDelete_s(state){
      state.removeBar = false
      router.push({name: 'Home'})
    },
    KIDelete_f(){

    },
    priceOffer_s(state, payload){
      state.price =0
      state.overlay = false
      state.productInfo = payload
      state.beforeImage= payload.picture
      
    },
    priceOffer_f(state){
    },
    KindList_s(state, payload){
      console.log(payload)
      state.kindList = payload
      state.removeBar = false
      router.push({name: 'KindList'})
    },
    KindList_f(state){

    },
    AuctionList_s(state, payload){

      state.bidingList = payload.bidinglist
      //console.log( state.bidingList)
      state.bidList = payload.bidList
    },
    AucDetail_s(state,payload){
      state.removeBar = true
      state.productInfo = payload
      if(state.aucType === "cancle"){
        state.overlay = false
        state.aucType = null
      }else{
        router.push({name: 'AucDetail'})
      }
    },
    RemoveHeart_s(state){
      state.heart = false
    },
    RemoveHeart_f(state){

    },
    Like_s(state, payload){

      console.log(payload)
      state.heart = true
      state.removeBar = true
      state.productInfo= payload


    },
    Like_f(state){
    },
    LikeList_s(state, payload){
      state.removeBar = true
      state.likeList = payload
      router.push({name: 'LikeList'})

    }



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

      console.log(payload)
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
        dispatch('nowLatLon')
      
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
      console.log(payload)

      let token = localStorage.getItem("access_token")
      let config={
        headers: {
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }



      let lat = localStorage.getItem('lat')
      let lon = localStorage.getItem('lon')


      var now = new Date()

  

      let formData = new FormData()

      formData.append('lat', lat)
      formData.append('lon', lon)
      formData.append('title', payload.title)
      formData.append('content',payload.content)
      formData.append('industry',payload.industry)
      formData.append('kind',payload.kind)
      formData.append('brand',payload.brand)
      formData.append('year',payload.year)
      formData.append('startprice',payload.startprice)
      formData.append('address', payload.address)

      




      //console.log(enddate)
      //formData.append('enddate', enddate )
      console.log(formData)
      for(let i=0; i< payload.files.length; i++){
        formData.append('multipartfile',payload.files[i])
      }
       
      // axios
      // .post('http://localhost:9200/api/product' , formData, config)
      // .then(wres=>{
      //   if(wres.data === "success"){
      //     commit('WritingSuccess')
      //   }
      // })
      // .catch(()=>{
      //   commit('WritingFaile')
      // })
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


      let token= localStorage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }
  

      axios
      .get(`http://localhost:9200/api/product?p_num=${payload.p_num}`, config)
      .then(Dres =>{
        commit('Saledetail_s', Dres.data)
      })
      .catch(()=>{
        alert("오류")
      })
    },



    DetailEditOK({dispatch, commit, state},payload){
    

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

          if(state.editType === "Sale"){
            dispatch('getSaledetail', {p_num: p_num})
            commit('SaleEdit_s')
            alert("sale")
          }else{
            dispatch('getDetail', {p_num: p_num, detailType: 'edit'})
          }
          

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

    },
    nowLatLon({dispatch}){
      // const script = document.createElement('script')
      // script.onload //= () => kakao.maps.load(this.initMap)
      // script.src = 'https://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e4ae1156e9644814145b77eeb30b26b0c&libraries=services'
      // document.head.appendChild(script)
      if(navigator.geolocation){
         navigator.geolocation.getCurrentPosition(function(position){
              let lat = position.coords.latitude
              let lon = position.coords.longitude
         localStorage.setItem('lat',lat)
         localStorage.setItem('lon',lon)
         console.log(localStorage.getItem('lat'))
         console.log(localStorage.getItem('lon'))

         })
      }
      dispatch('LatLonOK')
    },




    LatLonOK({commit}){
      let lat = localStorage.getItem('lat')
      let lon = localStorage.getItem('lon')
      console.log(lat)
      console.log(lon)

      axios
      .get(`http://localhost:9200/api/product/${lat}/${lon}`)
      .then(Tres => {
        console.log(Tres.data)
        commit('LatLon_s', Tres.data)

      })
      .catch(()=>{
        commit('LatLon_f')
      })

    },

    getIndustryList({commit}, payload){
      
      let lat =localStorage.getItem('lat')
      let lon= localStorage.getItem('lon')
      let industry= encodeURI(payload.industry)

      axios
      .get(`http://localhost:9200/api/product/industry?lat=${lat}&lon=${lon}&industry=${industry}`)
      .then(Ires =>{
        if(Ires.data === "null"){
          commit('Listnull')
          console.log(Ires.data)
        }else{
          commit('IndustryList_s', Ires.data)
          console.log(Ires.data)
        }
      })

    },
    getDetail({commit,dispatch}, payload){



      let token = localStorage.getItem("access_token")

      let config = {
        headers: {
          "access_token": token
        }
      }
      


      axios
      .get(`http://localhost:9200/api/product?p_num=${payload.p_num}`, config)
      .then(Dres =>{

        if(payload.detailType === 'edit'){ // Edit후 Reload할경우
          commit('DetailEdit_s',Dres.data)
            
        } else {
          console.log(Dres.data)
          commit('Detail_s', Dres.data) // 제일 처음에 Detail 정보 가져올 경우  
        }
      })
      .catch(()=>{
        alert("오류")
      })
    },


    KIDeleteOK({commit},payload){
      let p_num = payload.p_num
      axios
      .delete(`http://localhost:9200/api/product/${p_num}`)
      .then(Dres=>{
        if(Dres.data === "success"){
          commit('KIDelete_s')
        }else{
          commit('KIDelete_f')
        }
      })
    },
    priceOffer({commit, dispatch, state}, payload){

      let token = localStorage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      console.log(payload)
      let p_num = payload.p_num
      state.beforeType = "offer"
      axios
      .post('http://localhost:9200/api/auction',payload, config)
      .then(Pres => {
        if(Pres.data === "success"){
          if(payload.Type === "aucdetail"){
            dispatch('getAucDetail', {p_num: p_num })

          }else{
            dispatch('getDetail', {p_num: p_num })
          }
          
        }else {
          commit('priceOffer_f')
        }
      })
    },
    getKindList({commit}, payload){
     // alert(payload.kind)
      let lat = localStorage.getItem("lat")
      let lon = localStorage.getItem("lon")
    
      let kind = encodeURI(payload.kind)
      console.log(kind)
      axios
      .get(`http://localhost:9200/api/product/${lat}/${lon}/${kind}`)
      .then(Kres=>{
        if(Kres.data !== null){
          commit('KindList_s', Kres.data)
        } else{
          commit('KindList_f')
        }
      })
      
    },
    getAuctionList({commit}){
     


      let token = localStorage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get('http://localhost:9200/api/auction', config)
      .then(Ares =>{
        if(Ares.data !== null){
          commit('AuctionList_s', Ares.data)
        }else{
          console.log("AuctionList=>null")
        }
      })

    },
    getAucDetail({commit},payload){
      axios
      .get(`http://localhost:9200/api/auction/${payload.p_num}`)
      .then(Ares =>{
        if(Ares.data !== null){
          
          commit('AucDetail_s', Ares.data)
          
          //console.log(Ares.data)
        }else{
          //console.log("err")
        }
      })
    },
    offerCancle({state, dispatch}, payload){
      axios
      .delete(`http://localhost:9200/api/auction/${payload.a_num}`)
      .then(Ores =>{
        if(Ores.data === "success"){
          state.aucType = "cancle"
          dispatch('getAucDetail',{p_num: payload.p_num})
        }
      })
    },
    Like({commit, state}, payload){
      axios
      .post('http://localhost:9200/api/like', payload)
      .then(Lres =>{

        console.log(Lres.data)
        // (Lres.data === null)? commit('Like_f'): commit('Like_s', Lres.data)
        
      })

    },
    RemoveLike({commit}, payload){
      axios
      .delete(`http://localhost:9200/api/like/${payload.p_num}/${payload.l_username}`)
      .then(Hres =>{
        (Hres.data === "success")? commit('RemoveHeart_s') : commit('RemoveHeart_f')
      })
    },
    getLikeList({commit}){

      let token = localStorage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }


      axios
      .get('http://localhost:9200/api/like', config)
      .then(Lres => {
        (Lres.data === null)? commit('LikeList_f',Lres.data ) : commit('LikeList_s',Lres.data )
      })
    }



  }
})