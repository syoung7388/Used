import Vue from 'vue'
import Vuex, { createLogger } from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'
import Form from 'antd/lib/form/Form'



Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    Role: [],

    Pshow: false,
    Sshow:false,
    auth_show: 0,
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
    pictureList:[],
    count:[],


    
    likeInfo: [],
    proInfo: [],
    offerInfo: [],
    addrInfo: [],
    aucInfo:[],
    chatInfo: [],
    beforeImage:[],




    


    //saleList~saleDetial
    edit_show: false,
    address_show: false,
    Edit_error:false,
    


    Lat: null,
    Lon: null,


    topList:[],
    toppage: 0,
    toppagination: [], 



    indpagination :[], 
    industryList: [],
    industrypage: 0,
    I_list_show: false,
    industry: null,



    detail_show: true,
    edit_addr: false,
    DetailEdit_error: false,
    overlay: false,
    price: 0 ,
    
    
    kindpagination :[], 
    kindList: [],
    kindpage: 0, 
    kind: null,
    backType: null,
    beforeType: null,


    bidList:[],
  
      
    aucType: null,


    te: null,
    heart: null,


    likeList: [],
    Writingshow: true,
    payUrl: null,
    username_dup : false,
    name_dup: false,
    payreadyInfo:[],
    payInfo:[], 




    roomInfo:[],
    room_num: null,
    chatList: [],
    msg_err: false,


  
  },
  mutations: {
    //공통
    Back_f(state){
      router.go(-1)
      state.removeBar = false
    },
    Back_t(state){
      router.go(-1)
      state.removeBar = true
    },

    //Home.vue
    GetMap(state){
      state.removeBar = true
      router.push({name: 'Map'})

    },


    //Auth.vue
    Auth_login(state){
      state.auth_show = 1

    },
    Auth_signup(state){
      state.auth_show = 2

    },
    Sms_s(state, payload){
      state.Pshow= true;
      state.EPshow= true;
      state.certi= payload.numStr;
      state.phone= payload.phone;
      console.log(state.certi)
    },
    
    phoneFaile(){
      state.phoneError= true
    },
    
    Certification_s(state){
      state.Sshow= true
    },
    Certification_f(state){
      state.certiError= true

    },
    Signup_s(state){
      state.auth_show = 1
    },
    Duplication(state, payload){
      if(payload.check_username = '1'){
        state.username_dup = true
        if(payload.check_name = '1'){
          state.name_dup = true
        }else{
          state.username_dup = false 
        }
      }else{
        state.name_dup = false
      }

    },
    setPhone(state, payload){
      state.phone = payload
      console.log(state.phone)
    },
    Login_s(state, payload){


      for(var i=0; i< payload.authorities.length ; i++){
        var roles = payload.authorities[i]
        for(var j=0; j< roles.authorities.length; j++){
          state.Role.push(roles.authorities[j].authority)
        }
      }
      console.log(state.Role)
      state.userInfo= {
        name: payload.name,
        username: payload.username,
        password: payload.password,
        phone: payload.phone,
        address: payload.address,
        u_num: payload.u_num

      }
      state.isLoginError= false

    },

    Login_f(state){
      state.isLoginError=true
    },
    logout(state){
      state.removeBar = true
      router.push({name: 'Home'}) 
      state.userInfo = null
      state.Role= []
      localStorage.removeItem('access_token')
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
    Writing_f(state){
      state.WritingError= true
    },
    Writing_s(){


      router.push({name: 'Home'})
    },

    SaleCount_s(state, payload){
      console.log(payload)
      state.count = payload


    },
    SaleCount_f(state){


    },
    SaleList_s(state, payload){
    
    
      state.saleList= payload
      console.log(state.saleList)
      state.removeBar = true
      router.push({name: 'SaleList'})
      
    },
    SaleList_f(state){


    },
    SaleDetail_s(state, payload){
      //console.log(payload)
      state.list_show= !state.list_show
      state.aucInfo= payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
     // console.log(state.proInfo)

      
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.removeBar= true
      state.beforeImage= payload.product[0].picture
      router.push({name: 'SaleDetail'})
      
    },
    SaleDetail_f(state){
    
    },
    SaleEdit_s(state, payload){
      //console.log(payload)      
      state.edit_show = false
      state.aucInfo= payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.removeBar= true
      state.beforeImage= payload.product[0].picture


    },

    SaleEdit_f(state){

    },
    TopList_s(state, payload){
      //console.log(payload)
      state.topList = payload.toplist
      state.toppagination = payload.pagination      
      state.removeBar = false
      router.push({name: 'Home'})

    },
    TopList_f(state){

    },
    IndustryList_s(state, payload){
      console.log(payload)
      state.industryList = payload.industrylist
      state.indpagination = payload.pagination  
      state.I_list_show = true
      state.removeBar = true
      router.push({name: 'IndustryList'})
    },
    IndustryList_f(state, payload){

    },
    Detail_s(state, payload){
     
      //console.log(payload)
      state.overlay = false
      state.removeBar = true
      state.aucInfo = payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }


      
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.beforeImage= payload.product[0].picture


      for(var i in payload.like){
        (state.userInfo.username === state.likeInfo[i].l_username)? state.heart = true : state.heart = false
      }
      
      console.log(state.heart)
      
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
    Offer_s(state, payload){
      console.log(payload)
      state.overlay = false
      state.removeBar = true
      state.aucInfo = payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
     // console.log(state.proInfo)

      
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.beforeImage= payload.product[0].picture
      for(var i in payload.like){
        (state.userInfo.username === state.likeInfo[i].l_username)? state.heart = true : state.heart = false
      }
    },
    Offer_bid_f(state){
    },
    Offer_cancle_f(state){
    },
    KindList_s(state, payload){
      console.log(payload)
      state.kindpagination = payload.pagination
      state.kindList = payload.kindlist
      state.removeBar = false
      router.push({name: 'KindList'})
    },
    KindList_f(state){

    },
    BidCount_s(state, payload){
      state.count = payload
    },
    BidCount_f(){

    },
    BidList_s(state, payload){
      state.removeBar = true
      state.bidList= payload
      router.push({name: 'BidList'})
    },
    BidList_f(state){

    },
    BidDetail_s(state, payload){
     
      // console.log(payload)

      state.overlay = false
      state.removeBar = true
      
      state.aucInfo = payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }

     // console.log(state.proInfo)

      
      state.offerInfo= payload.offer 
      state.addrInfo = payload.address
      state.beforeImage=payload.product[0].picture
      for(var i in payload.like){
        (state.userInfo.username === state.likeInfo[i].l_username)? state.heart = true : state.heart = false
      }
      router.push({name: 'BidDetail'})

    },
    BidDetail_f(state){

    },
    RemoveHeart_s(state){
      state.heart = false
    },
    RemoveHeart_f(state){

    },
    Like_s(state, payload){

      console.log(payload)
      state.likeInfo = payload.like
      for(var i in payload.like){
        (state.userInfo.username === state.likeInfo[i].l_username)? state.heart =true : state.heart = false
      }

      state.aucInfo = payload
      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.beforeImage=payload.product[0].picture
      


    },
    Like_f(state){
    },
    LikeList_s(state, payload){
      state.removeBar = true
      state.likeList = payload
      router.push({name: 'LikeList'})

    },
    LikeList_f(state){

    },
    PayDetail_s(state, payload){

      console.log(payload)
      var aucdetail = payload.aucdetail
      state.payInfo = payload.paydetail
      state.aucInfo = aucdetail
      state.chatInfo = payload.chatdetail
      state.likeInfo = aucdetail.like
      
      
      for(var i in aucdetail.product){
        state.proInfo = aucdetail.product[i]
      }
      state.offerInfo= aucdetail.offer
      state.addrInfo = aucdetail.address
      state.beforeImage=aucdetail.product[0].picture
      state.removeBar = true
      router.push({name: 'PayDetail'})
    },
    KakaoReady_s(state, payload){

      state.payreadyInfo = payload
     // console.log(state.payInfo)

    },

    KakaoApprove_f(state){

    },
    Room_s(state, payload){
      console.log(payload)

      router.push({name: 'Chat', params: {num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})

    },
    Room_f(state){

    },
    ChatList_s(state, payload){
      state.chatList =payload
      router.push({name: 'ChatList'})

    },
    ChatList_f(state){

    },
    ChatDetail_s(state,payload){
      state.message = payload.message
      state.removeBar = true
      router.push({name: 'Chat', params: {num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})
    },

    AucEnd_s(state, payload){

      state.bidList= payload

    },
    AucEnd_f(){

    }
  },


  actions:{


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
    Back_f({state}){
      router.go(-1)
      state.removeBar = false
    },

    ///////////////////////////////////////////////////////////////////////////////////////////////페이지 전환 함수 & 페이지 요소 조정 함수

    Sms({commit}, payload){//인증문자
      axios
      .post('http://localhost:9200/api/all/sms', payload)
      .then(Res => {
        (Res.data !== null)? commit('Sms_s', Res.data): ('Sms_f')
      })
    },
    Certification({state, commit}, payload){  
      // console.log(state.certi)
      // console.log(payload)


      (payload.certinum === state.certi)? commit('Certification_s') : commit('Certification_f')
    },
    Signup({commit}, payload){ 

      console.log(payload)
      axios
      .post('http://localhost:9200/api/all/signup', payload)
      .then( Res => {

        (Res.data !== "success")? commit('Duplication', Res.data) : commit('Signup_s') 
      })
    },
    Login({dispatch, commit }, payload){ 

      axios
      .post('http://localhost:9200/api/all/login', payload)
      .then(Lres =>{

        if(Lres.data != null){
          let token = Lres.data.token
          console.log(token)
          localStorage.setItem("access_token", token)
          dispatch('getUserInfo')

        }else{
          commit('Login_f')
        }
  
      })

    },

    getUserInfo({commit, dispatch}){ 
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get('http://localhost:9200/api/user/unpackToken', config)
      .then( Ires =>{
        (Ires.data !== null)? commit('Login_s', Ires.data): commit('Login_f')

        dispatch('nowLatLon')
      
      })

    },
    Logout({commit}){
      commit('logout')
    },
    EditOK({state, commit}){ 
      let userInfo= state.userInfo
      //console.log(userInfo)
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post('http://localhost:9200/api/user/edit', userInfo, config)
      .then(Eres =>{
        console.log("수정완료")
        console.log(Eres.data)
        commit('EditSuccess', Eres.data)
        
      })
      .catch(() => {
        console.log("실패")
      })

    },
    deleteOK({state,commit}){ 
      let username= state.userInfo.username
      //console.log(username)
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      
      
      axios
      .delete(`http://localhost:9200/api/user/delete/${username}`, config)
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

        ////////수정시작


    Writing({state, commit}, payload){/// 게시물 작성 내용 DB전달
      
      //console.log(payload)


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
      let formData = new FormData()

    

      formData.append('title', payload.title)
      formData.append('content',payload.content)
      formData.append('startprice',payload.startprice)
      formData.append('day', payload.day )
      //auction

      formData.append('lat', lat)
      formData.append('lon', lon)
      formData.append('addr', payload.address)
      formData.append('town', payload.town)
      // address




      formData.append('industry',payload.industry)
      formData.append('kind',payload.kind)
      formData.append('brand',payload.brand)
      formData.append('year',payload.year)
      // product 

      for(let i=0; i< payload.files.length; i++){
        formData.append('img',payload.files[i])
      }
      //picture
       
      axios
      .post('http://localhost:9200/api/auction' , formData, config)
      .then(Res => {
        (Res.data === "success" )? commit('Writing_s'): commit('Writing_f') 

      })
    
   
    },


    getSaleCount({commit}){
      let token = localStorage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }
      axios
      .get('http://localhost:9200/api/auction/sale', config)
      .then(Res => {
        (Res.data !== null)? commit('SaleCount_s', Res.data): commit('SaleCount_f') 
      })

    },



    getSaleList({commit}, payload){
      //state.list_show =  true
      let token = localStorage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }


      axios
      .get(`http://localhost:9200/api/auction/sale/${payload.sale}`, config)
      .then(Res => {
        //console.log(Res.data)
        (Res.data !== null)? commit('SaleList_s', Res.data): commit('SaleList_f') 
      })
    },

    
    getSaleDetail({state, commit}, payload){


      let token= localStorage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token
        }
      }
      alert(payload.a_num)
  
      axios
      .get(`http://localhost:9200/api/auction/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('SaleDetail_s', Res.data) :commit('SaleDetail_f') 
      })
    
    },



    DetailEdit({dispatch, commit, state},payload){
    
      //console.log(payload)

      let token= localStorage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }


      let lat = localStorage.getItem('lat')
      let lon = localStorage.getItem('lon')
      let formData = new FormData()

    
      formData.append('a_num', payload.a_num)
      formData.append('title', payload.title)
      formData.append('content',payload.content)
      formData.append('startprice',payload.startprice)
      formData.append('day', payload.day )
      //auction


      // formData.append('address', {lat: lat})
      // formData.append('address', {lon: lon})
      // formData.append('address', {addr: payload.addr})
      // formData.append('address', {town: payload.town})


      

      formData.append('lat', lat)
      formData.append('lon', lon)
      formData.append('addr', payload.addr)
      formData.append('town', payload.town)
      // // address

      // let pro = new FormData()
   
      // pro.append('industry',payload.industry)
      // pro.append('kind',payload.kind)
      // pro.append('brand',payload.brand)
      // pro.append('year',payload.year)

      // formData.append('pro', pro)// 실패
 


      formData.append('industry',payload.industry)
      formData.append('kind',payload.kind)
      formData.append('brand',payload.brand)
      formData.append('year',payload.year)
      // product 

      formData.append('p_num', payload.p_num)
      for(let i=0; i< payload.files.length; i++){
        formData.append('img',payload.files[i])
      }      
      for(let i=0; i< payload.pi_numList.length; i++){
        formData.append('pi_nums', payload.pi_numList[i])
      }
      //picture

      axios
      .put('http://localhost:9200/api/auction', formData, config)
      .then(Res =>{
        //console.log(Res.data)
        (Res.data !== null)? commit('SaleEdit_s', Res.data): commit('SaleEdit_f') 

      })
    },

    SaleDelete({dispatch, commit, state}, payload){
      let a_num = payload.a_num
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(`http://localhost:9200/api/auction/${a_num}`, config)
      .then(Res =>{
        (Res.data === "success")? dispatch('getSaleList'): commit('SaleDelete_f')
        state.removeBar = false
        router.push({name: 'SaleList'})
      })

    },
    nowLatLon({dispatch}){
      if(navigator.geolocation){
         navigator.geolocation.getCurrentPosition(function(position){
              let lat = position.coords.latitude
              let lon = position.coords.longitude
         localStorage.setItem('lat',lat)
         localStorage.setItem('lon',lon)
        //  console.log(localStorage.getItem('lat'))
        //  console.log(localStorage.getItem('lon'))

         })
      }
      dispatch('getTopList')
    },




    getTopList({commit, state}){
      let lat = localStorage.getItem('lat')
      let lon = localStorage.getItem('lon')
      let page= 0
      axios
      .get(`http://localhost:9200/api/all/top?page=${page}&lat=${lat}&lon=${lon}`)
      .then(Res => {
        //console.log(Tres.data)
        (Res.data !== null)? commit('TopList_s', Res.data): commit('TopList_f')

      })

    },

    getIndustryList({commit, state}, payload){
      
      let lat =localStorage.getItem('lat')
      let lon= localStorage.getItem('lon')
      state.industry = payload.industry
      let industry= encodeURI(payload.industry)
      let page = state.industrypage


      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }

      axios
      .get(`http://localhost:9200/api/all/industry?lat=${lat}&lon=${lon}&industry=${industry}&page=${page}`, config)
      .then(Res =>{
        (Res.data !== "null") ? commit('IndustryList_s', Res.data): commit('IndustryList_f')
  
      })

    },

    getKindList({commit, state}, payload){
      // alert(payload.kind)
       let lat = localStorage.getItem("lat")
       let lon = localStorage.getItem("lon")
       let page = state.kindpage
       state.kind = payload.kind
       let kind = encodeURI(payload.kind)
      // console.log(kind)
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
       axios
       .get(`http://localhost:9200/api/all/kind?lat=${lat}&lon=${lon}&kind=${kind}&page=${page}`, config) 
       .then(Res=>{
         (Res.data !== null) ? commit('KindList_s', Res.data): commit('KindList_f')
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
      .get(`http://localhost:9200/api/all/detail/${payload.a_num}`, config)
      .then(Dres =>{


        (Dres.data !== null)? commit('Detail_s', Dres.data): commit('Detail_f')
         router.push({name:'Detail'})
      })
    },

    RemainDelete({commit, dispatch},payload){

      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      
      axios
      .delete(`http://localhost:9200/api/auction/${payload.a_num}`, config)
      .then(Res=>{
        (Res.data === "success")? dispatch('nowLatLon'):commit('RemainDelete_f')
      

      })
    },

    PriceOffer({commit, dispatch, state}, payload){

      let token = localStorage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      axios
      .post('http://localhost:9200/api/offer',payload, config)
      .then(Res => { 
        //console.log(Res.data)
        (Res.data !== null) ? commit('Detail_s', Res.data): commit('Detail_f')   
      })
    },
    PriceOffer_bid({commit}, payload){
      
      let token = localStorage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      axios
      .post('http://localhost:9200/api/offer',payload, config)
      .then(Res => { 
        //console.log(Res.data)
        (Res.data !== null) ? commit('Offer_s', Res.data): commit('Offer_bid_f')   
      })
  


    },

    OfferCancle({state, commit}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(`http://localhost:9200/api/offer/${payload.o_num}/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('Offer_s', Res.data):commit('Offer_cancle_f')
      })
    },

    getBidCount({commit}, payload){
      let token = localStorage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get('http://localhost:9200/api/offer/count', config)
      .then(Res =>{
        (Res.data !== null) ? commit('BidCount_s', Res.data): commit('BidCount_f')
      })
    },
    getBidList({commit}, payload){
 
      let token = localStorage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(`http://localhost:9200/api/offer?sale=${payload.sale}`, config)
      .then(Res =>{
        (Res.data !== null) ? commit('BidList_s', Res.data): commit('BidList_f')
      })

    },

    getBidDetail({commit},payload){


      let token = localStorage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
 
      axios
      .get(`http://localhost:9200/api/offer/${payload.a_num}`, config)
      .then(Res =>{
        
        (Res.data !== null)? commit('BidDetail_s', Res.data): commit('BidDetail_f')

      })
    },




    Like({commit, state}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post('http://localhost:9200/api/like', payload, config)
      .then(Res =>{
        (Res.data !== null)? commit('Like_s', Res.data): commit('Like_f')
        
      })

    },
    RemoveLike({commit}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(`http://localhost:9200/api/like/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('Like_s', Res.data) : commit('Like_f')
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
      .get('http://localhost:9200/api/like/', config)
      .then(Res => {
        (Res.data !== null)? commit('LikeList_s',Res.data ) : commit('LikeList_f' )
      })
    },
    getPayDetail({commit}, payload){


      let token = localStorage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(`http://localhost:9200/api/payment/${payload.a_num}`, config)
      .then(Res => {
        (Res.data !== null)? commit('PayDetail_s' , Res.data):commit('PayDetail_f' , Res.data) 
      })
    },
    KakaoReady({commit,state, dispatch}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post('http://localhost:9200/api/payment/kready', payload, config)
      .then(Res =>{
        
        (Res.data !== null)? commit('KakaoReady_s', Res.data) : commit('KakaoReady_f')
        //console.log(Res.data)
        var url = Res.data.kready_r.next_redirect_pc_url
        //console.log(url)
        var a = window.open(url)

        
        
      })
     
    },
    KakaoApprove({commit, state}, payload){
      console.log(payload)
      localStorage.setItem("back", "pay")
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
     
      // axios
      // .post(`http://localhost:9200/api/payment/kapproval`, payload, config)
      // .then(Res=>{
      //   (Res.data !== null)? commit('PayDetail_s', Res.data): commit('KakaoApprove_f')

      // })
    },
    Room({commit, state}, payload){

      //state.roomInfo = payload
      //console.log(payload)

      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(`http://localhost:9200/api/chat`, payload, config)
      .then(Res =>{
               
        (Res.data !== null)? commit('Room_s', {
          seller: payload.seller,
          buyer: payload.buyer,
          ch_num: Res.data
        }): commit('Room_f')
 
      })

    },
    getChatList({commit}){
      let token = localStorage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get('http://localhost:9200/api/chat', config)
      .then(Res =>{

        (Res.data !== null)? commit('ChatList_s', Res.data): commit('ChatList_f')
        
      })

    }, 
    getChatDetail({commit}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get(`http://localhost:9200/api/chat/${payload.ch_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('ChatDetail_s', Res.data): commit('ChatDetail_f')
        
      })
    }, 
    Message({state}, payload){
      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }

      axios
      .post("http://localhost:9200/api/chat/msg", payload, config)
      .then(Res =>{
        if(Res.data !== 'success'){
          localStorage.setItem('err', true)
          state.overlay = true
          setTimeout(()=>{
          state.overlay = false
          }, 2000)
        }else{
          localStorage.setItem('err', false)
        }


      })
    
      
    },
    AucEnd({commit, dispatch}, payload){

      let token = localStorage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      // console.log(config)
      

      axios
      .put('http://localhost:9200/api/auction/step', payload ,config )
      .then(Res =>{
        (Res.data !== null)? commit('AucEnd_s', Res.data): ('AucEnd_f')

      })
      
    }
  
  }
})