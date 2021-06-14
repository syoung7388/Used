import Vue from 'vue'
import Vuex, { createLogger } from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'
import Form from 'antd/lib/form/Form'



Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    http: 'http://3.34.22.100:9200',
    //http:'http://172.30.1.33:9200',
    Storage: localStorage,
    img_err: false,
    Mshow: true,
    Kshow:false, 
    Pshow: false,
    Sshow:false,
    auth_show: 0,
    removeBar: false,
    EPshow: false,
    Eshow: false,
    list_show: true,
    certi_err: false,


    ImageList:[],
    
    
    certi: null,
    phone: null,
    username: null,
    password: null,
  

    userInfo: {},
    Roles: [],
    role: null,
    role_choose: false,

    saleList: [],
    pictureList:[],
    count:[],
    month: [],
    total: [],


    
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


    offerList:[],
  
      
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


    offercount:[],
    offerkind: [],
    offerrate: [],
    offerrank: null,
    accountInfo: [],


    t_amount:[],
    t_month:[],


    err: false,
    inserterr: false,
    homeerr : false,
    nullerr: false,
    askerr: false,


    map:[],


  
  },
  mutations: {
    //공통
    Back(state){
      router.go(-1)
    },

    DetailSave(state, payload){
      state.overlay = false
      state.aucInfo = payload
      state.likeInfo = payload.like
      console.log(state.likeInfo)
      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.beforeImage= payload.product[0].picture
      for(var i in payload.like){
        if(state.userInfo.username === state.likeInfo[i].l_username){
          state.heart =true
          break;
        }else{
          state.heart = false
          continue
        }  
      
      }
    },

    //Home.vue
    GetMap(state){

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

    },
    CheckCerti(state, payload){

      if(state.certi === payload.certinum){
        state.Sshow = true 
        state.Pshow = true
        state.certi_err = false
      }else{
        state.certi_err = true
      }
    },



    Signup_s(state){
      state.auth_show = 1
    },
    Duplication(state, payload){


      if(payload.check_username === 1){
        state.username_dup = true
      }else{
        state.username_dup = false
      }


      if(payload.check_name === 1){
        state.name_dup = true
      }else{
        state.name_dup = false 
      }

      console.log(state.name_dup)

    },
    setPhone(state, payload){
      state.phone = payload
    },
    Login_s(state, payload){
      state.userInfo= {
        name: payload.name,
        username: payload.username,
        password: payload.password,
        phone: payload.phone,
        address: payload.address,
        u_num: payload.u_num
      },

      
      state.Storage.setItem("Roles", payload.authorities)
      if(payload.authorities.length === 1){
          state.Storage.setItem("role", payload.authorities[0].authority)
      }

    },
    ChooseRole(state){
      state.role_choose = true
    },
    logout(state){
      state.Storage.clear() 
      state.role_choose = false
      state.auth_show = 0
      router.push({name: 'App'})
      state.userInfo = null
    },
    Edit_s(state, payload){
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
    Delete_s(state){

      state.Ashow = 0
      router.push({name: 'App'})

    },

    Writing_s(state){
   
      router.push({name: 'Home'})
    },

    SaleStatistic_s(state, payload){

      state.count = payload.count
      state.month = payload.month
      state.total = payload.total
      router.push({name: 'Sale'})
    },

    SaleList_s(state, payload){
      state.saleList= payload
      state.nullerr =false
      router.push({name: 'SaleList'})
      
    },

    SaleDetail_s(state, payload){
      state.list_show= !state.list_show
      state.aucInfo= payload
      state.likeInfo = payload.like
      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
      state.beforeImage= payload.product[0].picture
      router.push({name: 'SaleDetail'})
      
    },

    SaleEdit_s(state, payload){
     
      state.edit_show = false
      state.aucInfo= payload
      state.likeInfo = payload.like

      for(var i in payload.product){
        state.proInfo = payload.product[i]
      }
      state.offerInfo= payload.offer
      state.addrInfo = payload.address
    
      state.beforeImage=[]
      state.beforeImage= payload.product[0].picture


    },


    TopList_s(state, payload){
      state.removeBar = false
     
      state.topList = payload.toplist
      state.toppagination = payload.pagination

      if(router.currentRoute.name !== 'Home'){
          router.push({name: 'Home'})
      }

   

  
        
      
      

    },

    IndustryList_s(state, payload){

      state.industryList = payload.industrylist
      state.indpagination = payload.pagination  
      state.I_list_show = true


      router.push({name: 'IndustryList'})
    },



    
   
    DetailEdit_s(state, payload){

     setTimeout(()=>{
        state.productInfo = payload
        state.beforeImage = payload.picture
  
        state.detail_show = true

      }, 2000)

    },
    KIDelete_s(state){
   
      router.push({name: 'Home'})
    },

 

 
    KindList_s(state, payload){
  
      state.kindpagination = payload.pagination
      state.kindList = payload.kindlist
      router.push({name: 'KindList'})
    },
 
    OfferStatistic_s(state, payload){
      state.offercount = payload.count
      state.offerkind = payload.kind
      state.offerrate = payload.rate
      state.offerrank = payload.rank
      router.push({name: 'Offer'})
    },
 
    OfferList_s(state, payload){

      state.offerList= payload
      state.nullerr =false
      router.push({name: 'OfferList'})
    },

   

    LikeList_s(state, payload){

      state.likeList = payload
      router.push({name: 'LikeList'})

    },
  
    PayDetail_s(state, payload){

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
      router.push({name: 'PayDetail'})
    },
    KakaoReady_s(state, payload){

      state.payreadyInfo = payload


    },

    Room_s(state, payload){
      state.backType = "detail"
      router.push({name: 'Chat', params: {ch_num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})

    },

    ChatList_s(state, payload){
  
      state.chatList =payload
      state.nullerr =false
      router.push({name: 'ChatList'})

    },

    ChatDetail_s(state,payload){
      state.message = payload.message
    
      state.nullerr =false
      router.push({name: 'Chat', params: {ch_num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})
    },

    AucEnd_s(state, payload){

      state.offerList= payload

    },
 
    AccountInfo_s(state, payload){
      state.accountInfo = payload

      router.push({name:'Account'})
    },

    TurnOverInfo_s(state, payload){
      state.t_month = payload.month
      state.t_amount = payload.amount
      router.push({name: 'TurnOver'})

    },
    CheckSkip_s(state, payload){
      state.offerList= payload
    },
    Err(state){
      state.overlay = true
      state.err = true
      setTimeout(()=>{
        state.overlay = false
        state.err = false
      }, 1000)

    },
    InsertErr(state){
      state.overlay = true
      state.inserterr = true
      setTimeout(()=>{
        state.overlay = false
        state.inserterr =false
      }, 1000)
    },
    AskErr(state){
      state.overlay = true
      state.askerr = true
      setTimeout(()=>{
        state.overlay = false
        state.askerr =false
      }, 1000)
    },
    HomeErr(state){
      state.overlay = true
      state.homeerr = true
      setTimeout(()=>{
        state.overlay = false
        state.homeerr = false
        router.push({name:'Home'})
      }, 1000)
    },
    NullErr(state, payload){

      state.saleList = []
      state.offerList = []
      state.chatList= []
      state.message=[]
      

      state.nullerr =true
      router.push({name: payload.router})
      

    },
  

  },


  actions:{

    E_Back({state}){
      state.Eshow = false

      router.push({name: 'MyPage'})
    },
    RouterBack({state}, payload){
      router.push({name: payload.name})
    },
    isEmpty({state}, val){
      if(val === "" || val === null || val === undefined || val !== null && typeof val === "object" && !Object.keys(val).length){
        return true
      }else{
        return false
      }    
    
    },
    AuthCheck({state,dispatch}){
      if(state.Storage.getItem("role") !== null && state.Storage.getItem("access_token") !== null){
        dispatch("isEmpty", state.userInfo).then((value)=>{
          if(value === true){
            dispatch('getUserInfo')
          }
        })
        return false
      }else{
        return true
      }
    },

    ReDetail({state, dispatch, commit}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then((Res)=>{
        dispatch('isEmpty', Res).then((value)=>{
          if(value === false){
            commit('DetailSave', Res.data)
            if(payload.router !== null){
              router.push({name: payload.router})
            
            }
          }else{
            commit('ReDetail', payload)
          }

        })
      })

    },

    
    Sms({commit, state,dispatch}, payload){
      axios
      .post(state.http+'/api/all/sms', payload)
      .then(Res => {
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('Sms_s', Res.data): commit('InsertErr')
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },
    Signup({commit, state}, payload){ 

      axios
      .post(state.http+'/api/all/signup', payload)
      .then( Res => {

        (Res.data === "success")? commit('Signup_s') : commit('Duplication', Res.data)
      })
      .catch(()=>{
        commit('Err')
      })
    },
    Login({dispatch, commit, state}, payload){ 

      axios
      .post(state.http+'/api/all/login', payload)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            let token = Res.data.token
  
            state.Storage.setItem("access_token", token)
            dispatch('getUserInfo')
          }else{
            commit('InsertErr')

          }
        })
      })
      .catch(()=>{
        commit('InsertErr')
      })

    },

    getUserInfo({commit, dispatch, state}){ 
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get(state.http+'/api/user/unpackToken', config)
      .then(Res =>{


        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('Login_s', Res.data)
            if(Res.data.authorities.length === 1){
              dispatch('nowLatLon')
            }else{
              commit('ChooseRole')
            }
          }else{
            commit('InsertErr')
          }
        })
      })
      .catch(()=>{
        commit('InsertErr')
      })

    },
    Logout({commit}){
      commit('logout')
    },
    EditOK({state, commit, dispatch}){ 
      let userInfo= state.userInfo
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(state.http+'/api/user/edit', userInfo, config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('Edit_s', Res.data): commit('InsertErr')
        })
      })
      .catch(()=>{
        commit('InsertErr')
      })

      
    },
    deleteOK({state,commit}){ 

      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+'/api/user/', config)
      .then(Res =>{
        (Res.data === "success")? commit('Delete_s'): commit('Err')
      })
      .catch(()=>{
        commit('Err')
      })
    },




    Writing({state, commit}, payload){
      



      let token = state.Storage.getItem("access_token")
      let config={
        headers: {
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }



      let lat = state.Storage.getItem('lat')
      let lon = state.Storage.getItem('lon')
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
      .post(state.http+'/api/auction' , formData, config)
      .then(Res => {
        (Res.data === "success" )? commit('Writing_s'): commit('InsertErr') 

      })
      .catch(()=>{
        commit('InsertErr')
      })
    
   
    },


    getSaleStatistic({commit, state,dispatch}){
      let token = state.Storage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/auction/statistic', config)
      .then(Res => {

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('SaleStatistic_s', Res.data): commit('Err')
        })
      })
      .catch(()=>{
        commit('Err')
      })
    

    },



    getSaleList({commit, state, dispatch}, payload){
  
      let token = state.Storage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }


      axios
      .get(state.http+`/api/auction/${payload.sale}`, config)
      .then(Res => {

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('SaleList_s', Res.data):  commit('NullErr', {router:"SaleList"})
        })       
      })
      .catch(()=>{
        commit('Err')
      })
    },

    
    getSaleDetail({state, commit,dispatch}, payload){


      let token= state.Storage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token
        }
      }
  
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)?  commit('SaleDetail_s', Res.data): commit('Err')
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },
    SelectOffer({commit, dispatch, state}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token
        }
      }

      axios
      .put(state.http+'/api/process/1', payload, config)
      .then(Res =>{
        (Res.data === "success")? dispatch('getSaleList', {sale: 1}):commit('Err')
      })
      .catch(()=>{
        commit('Err')
      })

    },



    DetailEdit({dispatch, commit, state},payload){


      let token= state.Storage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token,
          'Content-Type': 'multipart/form-data',
          'Access-Control-Allow-Origin': '*'
        }
      }


      let lat = state.Storage.getItem('lat')
      let lon = state.Storage.getItem('lon')
      let formData = new FormData()

    
      formData.append('a_num', payload.a_num)
      formData.append('title', payload.title)
      formData.append('content',payload.content)
      formData.append('startprice',payload.startprice)
      formData.append('day', payload.day )
      //auction
      formData.append('lat', lat)
      formData.append('lon', lon)
      formData.append('addr', payload.addr)
      formData.append('town', payload.town)
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
      .put(state.http+'/api/auction', formData, config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('SaleEdit_s', Res.data): commit('InsertErr') 
        })
      })
      .catch(()=>{
        commit('InsertErr')
      })
    },

    SaleDelete({dispatch, commit, state}, payload){
      let a_num = payload.a_num
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+`/api/auction/${a_num}`, config)
      .then(Res =>{
        (Res.data === 'success' )? dispatch('getSaleList',{sale:0}): commit('HomeErr')
       
      })
      .catch(()=>{
        commit('HomeErr')
      })

    },
    nowLatLon({dispatch, state}){
      // if(navigator.geolocation){
      //    navigator.geolocation.getCurrentPosition(function(position){
              // let lat = position.coords.latitude
              // let lon = position.coords.longitude
              // if(state.Storage.getItem('lat')=== null || state.Storage.getItem("lon") === null){  
              //   state.Storage.setItem('lat',lat)
              //   state.Storage.setItem('lon',lon)
              // }



              if(state.Storage.getItem('lat')=== null || state.Storage.getItem("lon") === null){  
                state.Storage.setItem('lat',37.3595316)
                state.Storage.setItem('lon',127.1052133)
              }

      //    })
      // }
      dispatch('AuthCheck')
      dispatch('getTopList')
    },




    getTopList({commit, state, dispatch}){

      let lat = state.Storage.getItem('lat')
      let lon = state.Storage.getItem('lon')
      state.toppage= 0
      axios
      .get(state.http+`/api/all/top?page=${state.toppage}&lat=${lat}&lon=${lon}`)
      .then(Res => {
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('TopList_s', Res.data): commit('NullErr', {router:"TopList"})
        })

      })
      .catch(()=>{
        commit('Err')
      })

    },

    getIndustryList({commit, state,dispatch}, payload){
      
      let lat =state.Storage.getItem('lat')
      let lon=state.Storage.getItem('lon')
      state.industry = payload.industry
      let industry= encodeURI(payload.industry)
      state.industrypage=0

      axios
      .get(state.http+`/api/all/industry?lat=${lat}&lon=${lon}&industry=${industry}&page=${state.industrypage}`)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('IndustryList_s', Res.data):commit('NullErr', {router:"IndustryList"})
        })
  
      })
      .catch(()=>{
        commit('Err')
      })

    },

    getKindList({commit, state ,dispatch}, payload){
       let lat = state.Storage.getItem("lat")
       let lon = state.Storage.getItem("lon")
       state.kindpage = 0
       state.kind = payload.kind
       let kind = encodeURI(payload.kind)
       axios
       .get(state.http+`/api/all/kind?lat=${lat}&lon=${lon}&kind=${kind}&page=${state.kindpage}`) 
       .then(Res=>{


        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)?  commit('KindList_s', Res.data): commit('NullErr', {router:"KindList"})
        })
       })
       .catch(()=>{
        commit('Err')
      })
       
     },
 
    getDetail({commit,dispatch, state}, payload){

      let token = state.Storage.getItem("access_token")

      let config = {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('DetailSave', Res.data)
            router.push({name:'Detail'})
          }else{
            commit('Err')
          } 
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },

    RemainDelete({commit, dispatch, state},payload){

      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      
      axios
      .delete(state.http+`/api/auction/${payload.a_num}`, config)
      .then(Res=>{
        (Res.data === "success")? dispatch('nowLatLon'):commit('Err')
      

      })
      .catch(()=>{
        commit('Err')
      })
    },

    PriceOffer({commit, dispatch, state}, payload){//

      let token = state.Storage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      axios
      .post(state.http+'/api/offer',payload, config)
      .then(Res => { 
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)?commit('DetailSave', Res.data): commit('ReDetail',{a_num: payload.a_num})
        })  
      })
      .catch(()=>{
        commit('HomeErr')
      })
    },
    OfferCancle({state, commit,dispatch}, payload){//
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+`/api/offer/${payload.o_num}/${payload.a_num}`, config)
      .then(Res =>{


        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('DetailSave', Res.data): commit('ReDetail',{a_num: payload.a_num})
        })
      })
      .catch(()=>{
        commit('HomeErr')
      })
    },

    getOfferStatistic({commit, state ,dispatch}, payload){
      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/offer/count', config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('OfferStatistic_s', Res.data)
          } 
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getOfferList({commit, state,dispatch}, payload){
 
      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/offer?sale=${payload.sale}`, config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('OfferList_s', Res.data): commit('NullErr', {router:"OfferList"})
        })
      })
      .catch(()=>{
        commit('Err')
      })

    },

    getOfferDetail({commit, state,dispatch},payload){//


      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
 
      axios
      .get(state.http+`/api/offer/${payload.a_num}`, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('DetailSave', Res.data)
            router.push({name:'OfferDetail'})

          }else{
            commit('ReDetail',{a_num: payload.a_num, router: "OfferDetail"})
          }
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },




    Like({commit, state,dispatch}, payload){//
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(state.http+'/api/like', payload, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('DetailSave', Res.data): commit('ReDetail',{a_num: payload.a_num})
        })
        
      })
      .catch(()=>{
        commit('Err')
      })

    },
    RemoveLike({commit,state,dispatch}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      console.log(payload)
      axios
      .delete(state.http+`/api/like/${payload.a_num}`, config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('DetailSave', Res.data): commit('ReDetail',{a_num: payload.a_num})
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getLikeList({commit,state ,dispatch}){
      

      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/like/', config)
      .then(Res => {

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('LikeList_s',Res.data ):  commit('NullErr', {router:"LikeList"})
        })
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getLikeDetail({commit,dispatch,state}, payload){//

      let token = state.Storage.getItem("access_token")

      let config = {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('DetailSave', Res.data)
            router.push({name: 'LikeDetail'})
          }else{
            commit('ReDetail',{a_num: payload.a_num, router: "LikeDetail"})
          } 
        })
        
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getPayDetail({commit, state, dispatch}, payload){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/payment/${payload.a_num}`, config)
      .then(Res => {
        dispatch('isEmpty', Res.data).then((value)=>{

          if(value === false){
            commit('PayDetail_s' , Res.data)
          }else{
            dispatch('getPayDetail', payload)
          } 
        }) 
      })
      .catch(()=>{
        commit('Err')
      })
    },
    KakaoReady({commit,state, dispatch}, payload){//////////
     
      let token= state.Storage.getItem("access_token")
 
      let config= {
        headers: {
          access_token: token
        }
      }

      axios
      .post(state.http+'/api/payment/kready', payload, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('KakaoReady_s', Res.data)
            var url = Res.data.kready_r.next_redirect_app_url
            window.kakaopay.PayWindow(url)
          }else{ 
            commit('KakaoReady', payload)
          }
        })
      })   
    },
    KakaoApprove({commit, state,dispatch}, payload){
      

      let token= localStorage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
     
      axios
      .post(state.http+`/api/payment/kapproval`, payload, config)
      .then(Res=>{
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('PayDetail_s', Res.data): dispatch('getPayDetail', {a_num: payload.a_num})
        })
      
      })
    },
    Room({commit, state,dispatch}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(state.http+`/api/chat`, payload, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('Room_s', Res.data): commit('HomeErr')
        })
 
      })
      .catch(()=>{
        commit('Err')
      })

    },
    getChatList({commit, state ,dispatch}){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/chat', config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('ChatList_s', Res.data): commit('NullErr',{router:"ChatList"})
        })
      }).catch(()=>{
        commit('Err')
      })

    }, 
    getChatDetail({commit, state, dispatch}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get(state.http+`/api/chat/${payload.ch_num}`, config)
      .then(Res =>{


        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('ChatDetail_s', Res.data)
          } 
        })
      }).catch(()=>{
        commit('HomeErr')
      })
    }, 
    Message({state, commit, dispatch}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }

      axios
      .post(state.http+"/api/chat/msg", payload, config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)?   state.Storage.setItem('err', false):  commit('Err')
        })
      }).catch(()=>{
        commit('Err')
      })
    
      
    },
    AucEnd({commit, dispatch, state}, payload){

      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
   
      axios
      .put(state.http+'/api/process/3', payload ,config )
      .then(Res =>{

        console.log(Res.data)

        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('AucEnd_s', Res.data)
          }else{
            commit('NullErr')
          }
        })
      }).catch(()=>{
        commit('Err')
      })
      
    },
    getAccountInfo({commit,state ,dispatch}){//
      
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/account', config)
      .then(Res =>{

        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('AccountInfo_s', Res.data): commit('Err')
        })
      }).catch(()=>{
        commit('Err')
      })
    },
    getTurnOverInfo({commit,state, dispatch}){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/turnover', config)
      .then(Res => {
        dispatch('isEmpty', Res.data).then((value)=>{
          (value === false)? commit('TurnOverInfo_s', Res.data): dispatch('getTurnOverInfo')
        })
      }).catch(()=>{
        commit('Err')
      })
    },
    CheckSkip({dispatch, commit,state}, payload){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      

      axios
      .put(state.http+'/api/process/0', payload, config)
      .then(Res => {
        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('CheckSkip_s', Res.data)
          }  
        })
      }).catch(()=>{
        commit('HomeErr')
      })

    },

    Delay({dispatch, commit, state}, payload){

      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .put(state.http+'/api/auction/delay', payload, config)
      .then(Res =>{
        dispatch('isEmpty', Res.data).then((value)=>{
          if(value === false){
            commit('DetailSave', Res.data)
          }else{
            dispatch('ReDetail', {a_num: payload.a_num})
          }

        })

      })


    },
  //   CheckImg: function (state, link){
  //     console.log(link)
  //     try{
  //         return require("../../../asset/"+link)
  //     }catch{
  //         return require("../../../asset/no.png")
  //     }
  //  }

  
  },

  
})