import Vue from 'vue'
import Vuex, { createLogger } from 'vuex'
import axios from 'axios'
import router from '../router'
import colors from 'vuetify/lib/util/colors'
import Form from 'antd/lib/form/Form'



Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    http:'http://172.30.1.55:9200',
    Storage: localStorage,
    Mshow: true,
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


    bidcount:[],
    bidkind: [],
    bidrate: [],
    bidrank: null,
    accountInfo: [],


    t_amount:[],
    t_month:[],


    err: false,
    inserterr: false,
    homeerr : false,
    nullerr: false


  
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
    DetailSave(state, payload){
      console.log("DetailSave")
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
    CheckCerti(state, payload){
      console.log(payload.certinum)
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
      state.userInfo= {
        name: payload.name,
        username: payload.username,
        password: payload.password,
        phone: payload.phone,
        address: payload.address,
        u_num: payload.u_num
      },

      
      state.Roles = payload.authorities
      if(state.Roles.length === 1){
          state.role = state.Roles[0].authority
      }
      state.isLoginError= false

    },
    ChooseRole(state){
      state.role_choose = true
    },
    logout(state){
      state.removeBar = false
      state.userInfo = null
      state.Roles= []
      state.role= null
      state.role_choose = false
      state.auth_show = 0
      state.Storage.removeItem('access_token')
      router.push({name: 'Home'}) 
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
      state.removeBar = false
      router.push({name: 'Home'})
    },

    SaleStatistic_s(state, payload){
      console.log(payload)
      state.count = payload.count
      state.month = payload.month
      state.total = payload.total
      router.push({name: 'Sale'})
    },

    SaleList_s(state, payload){
      state.saleList= payload
      console.log(state.saleList)
      state.removeBar = true
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
      console.log(state.offerInfo)
      state.addrInfo = payload.address
      state.removeBar= true
      state.beforeImage= payload.product[0].picture
      router.push({name: 'SaleDetail'})
      
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
      state.beforeImage=[]
      console.log( state.beforeImage)
      state.beforeImage= payload.product[0].picture


    },


    TopList_s(state, payload){
      console.log(payload)
      state.topList = payload.toplist
      state.toppagination = payload.pagination      
      state.removeBar = false
      router.push({name: 'Home'})

    },

    IndustryList_s(state, payload){
      console.log(payload)
      state.industryList = payload.industrylist
      state.indpagination = payload.pagination  
      state.I_list_show = true
      state.removeBar = true
      router.push({name: 'IndustryList'})
    },



    // Detail_s(state, payload){
    
    //   state.overlay = false
    //   state.removeBar = true
    //   state.aucInfo = payload
    //   state.likeInfo = payload.like

    //   for(var i in payload.product){
    //     state.proInfo = payload.product[i]
    //   }


      
    //   state.offerInfo= payload.offer
    //   state.addrInfo = payload.address
    //   state.beforeImage= payload.product[0].picture


    //   for(var i in payload.like){
    //     (state.userInfo.username === state.likeInfo[i].l_username)? state.heart = true : state.heart = false
    //   }
    // },
   
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

    // Offer_s(state, payload){
    //   console.log(payload)
    //   state.overlay = false
    //   state.removeBar = true
    //   state.aucInfo = payload
    //   state.likeInfo = payload.like

    //   for(var i in payload.product){
    //     state.proInfo = payload.product[i]
    //   }
    //  // console.log(state.proInfo)

      
    //   state.offerInfo= payload.offer
    //   state.addrInfo = payload.address
    //   state.beforeImage= payload.product[0].picture
    //   for(var i in payload.like){
    //     (state.userInfo.username === state.likeInfo[i].l_username)? state.heart = true : state.heart = false
    //   }
    // },

 
    KindList_s(state, payload){
      console.log(payload)
      state.kindpagination = payload.pagination
      state.kindList = payload.kindlist
      state.removeBar = false
      router.push({name: 'KindList'})
    },
 
    BidStatistic_s(state, payload){
      state.bidcount = payload.count
      state.bidkind = payload.kind
      state.bidrate = payload.rate
      state.bidrank = payload.rank
      router.push({name: 'Bid'})
    },
 
    BidList_s(state, payload){
      state.removeBar = true
      state.bidList= payload
      state.nullerr =false
      router.push({name: 'BidList'})
    },

    // BidDetail_s(state, payload){
    //   state.overlay = false
    //   state.removeBar = true 
    //   state.aucInfo = payload
    //   state.likeInfo = payload.like

    //   for(var i in payload.product){
    //     state.proInfo = payload.product[i]
    //   }
    //   state.offerInfo= payload.offer 
    //   state.addrInfo = payload.address
    //   state.beforeImage=payload.product[0].picture

    //   for(var i in payload.like){
    //     if(state.userInfo.username === state.likeInfo[i].l_username){
    //       state.heart =true
    //       break;
    //     }else{
    //       state.heart = false
    //       continue
    //     }  
    //   }
    //   router.push({name: 'BidDetail'})
    // },

    // RemoveHeart_s(state){
    //   state.heart = false
    // },
 
    // Like_s(state, payload){
    //   state.likeInfo = payload.like
    //   for(var i in payload.like){
    //     if(state.userInfo.username === state.likeInfo[i].l_username){
    //       state.heart =true
    //       break;
    //     }else{
    //       state.heart = false
    //       continue
    //     }  
    //   }
    //   console.log(state.heart)

    //   state.aucInfo = payload
    //   for(var i in payload.product){
    //     state.proInfo = payload.product[i]
    //   }
    //   state.offerInfo= payload.offer
    //   state.addrInfo = payload.address
    //   state.beforeImage=payload.product[0].picture
      


    // },

    LikeList_s(state, payload){
      state.removeBar = true
      state.likeList = payload
      router.push({name: 'LikeList'})

    },
  
    // PayDetail_s(state, payload){

    //   console.log(payload)
    //   var aucdetail = payload.aucdetail
    //   state.payInfo = payload.paydetail
    //   state.aucInfo = aucdetail
    //   state.chatInfo = payload.chatdetail
    //   state.likeInfo = aucdetail.like
      
      
    //   for(var i in aucdetail.product){
    //     state.proInfo = aucdetail.product[i]
    //   }
    //   state.offerInfo= aucdetail.offer
    //   state.addrInfo = aucdetail.address
    //   state.beforeImage=aucdetail.product[0].picture
    //   state.removeBar = true
    //   router.push({name: 'PayDetail'})
    // },
    // KakaoReady_s(state, payload){

    //   state.payreadyInfo = payload
    //  // console.log(state.payInfo)

    // },

    Room_s(state, payload){
      console.log(payload)
      router.push({name: 'Chat', params: {num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})

    },

    ChatList_s(state, payload){
      state.removeBar = true
      state.chatList =payload
      state.nullerr =false
      router.push({name: 'ChatList'})

    },

    ChatDetail_s(state,payload){
      state.message = payload.message
      state.removeBar = true
      state.nullerr =false
      router.push({name: 'Chat', params: {num: payload.ch_num, seller: payload.seller, buyer: payload.buyer}})
    },

    AucEnd_s(state, payload){

      state.bidList= payload

    },
 
    AccountInfo_s(state, payload){
      state.accountInfo = payload
      console.log(payload)
      router.push({name:'Account'})
    },

    TurnOverInfo_s(state, payload){
      state.t_month = payload.month
      state.t_amount = payload.amount
      router.push({name: 'TurnOver'})

    },
    CheckPay_s(state, payload){
      state.bidList= payload
    },
    Err(state){
      state.overlay = true
      state.err = true
      setTimeout(()=>{
        state.overlay = false
        state.err = false
      }, 3000)

    },
    InsertErr(state){
      state.overlay = true
      state.inserterr = true
      setTimeout(()=>{
        state.overlay = false
        state.inserterr =false
      }, 3000)
    },
    HomeErr(state){
      state.overlay = true
      state.homeerr = true
      setTimeout(()=>{
        state.overlay = false
        state.homeerr = false
        state.removeBar = false
        router.push({name:'Home'})
      }, 3000)
    },
    NullErr(state, payload){

      state.saleList = []
      state.bidList = []
      state.chatList= []
      state.message=[]
      
      console.log(payload)
      state.removeBar = payload.Bar
      state.nullerr =true
      router.push({name: payload.router})
      

    },
  

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

    Sms({commit, state}, payload){//인증문자
      axios
      .post(state.http+'/api/all/sms', payload)
      .then(Res => {
        (Res.data !== null)? commit('Sms_s', Res.data): ('InsertErr')
      })
      .catch(()=>{
        commit('Err')
      })
    },
    Signup({commit, state}, payload){ 

      console.log(payload)
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
      .then(Lres =>{

        if(Lres.data !== null){
          let token = Lres.data.token
          console.log(token)
          state.Storage.setItem("access_token", token)
          dispatch('getUserInfo')

        }else{
          commit('InsertErr')
        }
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
      .then( Ires =>{
        
        if(Ires.data !== null ){
          commit('Login_s', Ires.data)
          if(Ires.data.authorities.length === 1){
            dispatch('nowLatLon')
          }else{
            commit('ChooseRole')
          }
        }else{
          commit('InsertErr')
        }
      })
      .catch(()=>{
        commit('InsertErr')
      })

    },
    Logout({commit}){
      commit('logout')
    },
    EditOK({state, commit}, payload){ 
      if(state.certi === payload.certinum){
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
          (Res.data !== null)? commit('Edit_s', Res.data):  commit("InsertErr")
        })
        .catch(()=>{
          commit('InsertErr')
        })

      }else{
        commit("InsertErr")
      }
    },
    deleteOK({state,commit}){ 
      let username= state.userInfo.username
      //console.log(username)
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+`/api/user/delete/${username}`, config)
      .then(Res =>{
        (Res.data === "success")? commit('Delete_s'): commit('Err')
      })
      .catch(()=>{
        commit('Err')
      })
    },

        ////////수정시작


    Writing({state, commit}, payload){/// 게시물 작성 내용 DB전달
      
      //console.log(payload)


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


    getSaleStatistic({commit, state}){
      let token = state.Storage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/auction/statistic', config)
      .then(Res => {
        if(Res.data !== null){
          commit('SaleStatistic_s', Res.data)
        }
      })
      .catch(()=>{
        commit('Err')
      })
    

    },



    getSaleList({commit, state}, payload){
      //state.list_show =  true
      let token = state.Storage.getItem("access_token")
      let config={
        headers: {  
          "access_token": token
        }
      }


      axios
      .get(state.http+`/api/auction/${payload.sale}`, config)
      .then(Res => {
        (Res.data.length !== 0)? commit('SaleList_s', Res.data): commit('NullErr', {router:"SaleList", Bar:"true"}) 
      })
      .catch(()=>{
        commit('Err')
      })
    },

    
    getSaleDetail({state, commit}, payload){


      let token= state.Storage.getItem("access_token")
      let config= {
        headers:{
          "access_token": token
        }
      }
  
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('SaleDetail_s', Res.data) :commit('Err') 
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
      console.log(payload)
      axios
      .put(state.http+'/api/offer', payload, config)
      .then(Res =>{
        (Res.data === "success")? dispatch('getSaleList', {sale: 1}):commit('Err')
      })
      .catch(()=>{
        commit('Err')
      })

    },



    DetailEdit({dispatch, commit, state},payload){
    
      //console.log(payload)

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
        //console.log(Res.data)
        (Res.data !== null)? commit('SaleEdit_s', Res.data): commit('InsertErr') 

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
    nowLatLon({dispatch}){
      if(navigator.geolocation){
         navigator.geolocation.getCurrentPosition(function(position){
              let lat = position.coords.latitude
              let lon = position.coords.longitude
              state.Storage.setItem('lat',lat)
              state.Storage.setItem('lon',lon)
              console.log(state.Storage.getItem('lat'))
              console.log(state.Storage.getItem('lon'))

         })
      }
      dispatch('getTopList')
    },




    getTopList({commit, state}){
      // let lat = '37.372551'
      // let lon = '127.762025'
      let lat = state.Storage.getItem('lat')
      let lon = state.Storage.getItem('lon')
      state.toppage= 0
      axios
      .get(state.http+`/api/all/top?page=${state.toppage}&lat=${lat}&lon=${lon}`)
      .then(Res => {
   
        if(Res.data.length !== 0){
          commit('TopList_s', Res.data)
        }

      })
      .catch(()=>{
        commit('Err')
      })

    },

    getIndustryList({commit, state}, payload){
      
      let lat =state.Storage.getItem('lat')
      let lon=state.Storage.getItem('lon')
      state.industry = payload.industry
      let industry= encodeURI(payload.industry)
      state.industrypage=0

      axios
      .get(state.http+`/api/all/industry?lat=${lat}&lon=${lon}&industry=${industry}&page=${state.industrypage}`)
      .then(Res =>{
        if(Res.data.length !== 0){
          commit('IndustryList_s', Res.data)

        } 
  
      })
      .catch(()=>{
        commit('Err')
      })

    },

    getKindList({commit, state}, payload){
      // alert(payload.kind)
       let lat = state.Storage.getItem("lat")
       let lon = state.Storage.getItem("lon")
       state.kindpage = 0
       state.kind = payload.kind
       let kind = encodeURI(payload.kind)
      // console.log(kind)
      // let token= localStorage.getItem("access_token")
      // let config= {
      //   headers: {
      //     access_token: token
      //   }
      // }
       axios
       .get(state.http+`/api/all/kind?lat=${lat}&lon=${lon}&kind=${kind}&page=${state.kindpage}`) 
       .then(Res=>{
          if(Res.data.length !== 0) {
            commit('KindList_s', Res.data)
          } 
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


        (Res.data !== null)? commit('DetailSave', Res.data): commit('Err')
        router.push({name:'Detail'})
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

    PriceOffer({commit, dispatch, state}, payload){

      let token = state.Storage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      axios
      .post(state.http+'/api/offer',payload, config)
      .then(Res => { 
        //console.log(Res.data)
        (Res.data !== null) ? commit('DetailSave', Res.data): commit('HomeErr')   
      })
      .catch(()=>{
        commit('HomeErr')
      })
    },
    PriceOffer_bid({commit, state}, payload){
      
      let token = state.Storage.getItem("access_token")
      let config = {
        headers: {
          'access_token': token
        }
      }
      axios
      .post(state.http+'/api/offer',payload, config)
      .then(Res => { 
        //console.log(Res.data)
        (Res.data !== null) ? commit('DetailSave', Res.data): commit('HomeErr')   
      })
      .catch(()=>{
        commit('HomeErr')
      })
  


    },

    OfferCancle({state, commit}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+`/api/offer/${payload.o_num}/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('DetailSave', Res.data):commit('HomeErr')
      })
      .catch(()=>{
        commit('HomeErr')
      })
    },

    getBidStatistic({commit, state}, payload){
      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/offer/count', config)
      .then(Res =>{
        if(Res.data !== null){
          commit('BidStatistic_s', Res.data)

        } 
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getBidList({commit, state}, payload){
 
      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/offer?sale=${payload.sale}`, config)
      .then(Res =>{
        (Res.data.length !== 0) ? commit('BidList_s', Res.data): commit('NullErr', {router:"BidList", Bar:"true"})
      })
      .catch(()=>{
        commit('Err')
      })

    },

    getBidDetail({commit, state},payload){


      let token = state.Storage.getItem("access_token")
      let config= {
        headers: {
          "access_token": token
        }
      }
 
      axios
      .get(state.http+`/api/offer/${payload.a_num}`, config)
      .then(Res =>{
        
        (Res.data !== null)? commit('DetailSave', Res.data): commit('Err')
        router.push({name: 'BidDetail'})

      })
      .catch(()=>{
        commit('Err')
      })
    },




    Like({commit, state}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(state.http+'/api/like', payload, config)
      .then(Res =>{
        (Res.data !== null)? commit('DetailSave', Res.data): commit('Err')
        
      })
      .catch(()=>{
        commit('Err')
      })

    },
    RemoveLike({commit,state}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .delete(state.http+`/api/like/${payload.a_num}`, config)
      .then(Res =>{
        (Res.data !== null)? commit('DetailSave', Res.data) : commit('Err')
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getLikeList({commit}){
      

      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/like/', config)
      .then(Res => {
        (Res.data !== null)? commit('LikeList_s',Res.data ) : commit('Err' )
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getLikeDetail({commit,dispatch}, payload){

      let token = state.Storage.getItem("access_token")

      let config = {
        headers: {
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/all/${payload.a_num}`, config)
      .then(Dres =>{
        (Dres.data !== null)? commit('DetailSave', Dres.data): commit('Err')
        router.push({name: 'LikeDetail'})
      })
      .catch(()=>{
        commit('Err')
      })
    },
    getPayDetail({commit, state}, payload){


      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+`/api/payment/${payload.a_num}`, config)
      .then(Res => {
        (Res.data !== null)? commit('DetailSave' , Res.data):commit('PayDetail_f' , Err) 
        router.push({name: 'PayDetail'})
      })
      .catch(()=>{
        commit('Err')
      })
    },
    // KakaoReady({commit,state, dispatch}, payload){
    //   let token= localStorage.getItem("access_token")
    //   let config= {
    //     headers: {
    //       access_token: token
    //     }
    //   }
    //   axios
    //   .post('http://localhost:9200/api/payment/kready', payload, config)
    //   .then(Res =>{
        
    //     (Res.data !== null)? commit('KakaoReady_s', Res.data) : commit('KakaoReady_f')
    //     //console.log(Res.data)
    //     var url = Res.data.kready_r.next_redirect_pc_url
    //     //console.log(url)
    //     var a = window.open(url)
    //   })   
    // },
    // KakaoApprove({commit, state}, payload){
    //   console.log(payload)
    //   localStorage.setItem("back", "pay")
    //   let token= localStorage.getItem("access_token")
    //   let config= {
    //     headers: {
    //       access_token: token
    //     }
    //   }
     
    //   axios
    //   .post(`http://localhost:9200/api/payment/kapproval`, payload, config)
    //   .then(Res=>{
    //     (Res.data !== null)? commit('PayDetail_s', Res.data): commit('KakaoApprove_f')

    //   })
    // },
    Room({commit, state}, payload){

      //state.roomInfo = payload
      //console.log(payload)

      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .post(state.http+`/api/chat`, payload, config)
      .then(Res =>{
               
        (Res.data !== null)? commit('Room_s', {
          seller: payload.seller,
          buyer: payload.buyer,
          ch_num: Res.data
        }): commit('Err')
 
      }).catch(()=>{
        commit('Err')
      })

    },
    getChatList({commit, state}){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/chat', config)
      .then(Res =>{
        (Res.data.length !== 0)? commit('ChatList_s', Res.data): commit('NullErr',{router:"ChatList", Bar: "true"})
        
      }).catch(()=>{
        commit('Err')
      })

    }, 
    getChatDetail({commit, state}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }
      axios
      .get(state.http+`/api/chat/${payload.ch_num}`, config)
      .then(Res =>{
        (Res.data.length !== 0)? commit('ChatDetail_s', Res.data): commit('NullErr', {router:"Chat", Bar:"true"})
        
      }).catch(()=>{
        commit('HomeErr')
      })
    }, 
    Message({state}, payload){
      let token= state.Storage.getItem("access_token")
      let config= {
        headers: {
          access_token: token
        }
      }

      axios
      .post(state.http+"/api/chat/msg", payload, config)
      .then(Res =>{
        if(Res.data !== 'success'){
          sessionStorage.setItem('err', true)
          state.overlay = true
          setTimeout(()=>{
          state.overlay = false
          }, 2000)
        }else{
          state.Storage.setItem('err', false)
        }
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
      // console.log(config)
      

      axios
      .put(state.http+'/api/auction/step', payload ,config )
      .then(Res =>{
        (Res.data !== null)? commit('AucEnd_s', Res.data): ('HomeErr')
      }).catch(()=>{
        commit('Err')
      })
      
    },
    getAccountInfo({commit,state}){
      
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/account', config)
      .then(Res =>{
        (Res.data !== null)? commit('AccountInfo_s', Res.data):commit('Err')
      }).catch(()=>{
        commit('Err')
      })
    },
    getTurnOverInfo({commit,state}){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      axios
      .get(state.http+'/api/turnover', config)
      .then(Res => {
        (Res.data !== null)? commit('TurnOverInfo_s', Res.data): commit('Err')
      }).catch(()=>{
        commit('Err')
      })
    },
    CheckPay({dispatch, commit,state}, payload){
      let token = state.Storage.getItem("access_token")
      let config = {
        headers:{
          "access_token": token
        }
      }
      console.log(payload)

      axios
      .put(state.http+'/api/offer/check', payload, config)
      .then(Res => {
        if(Res.data !== null ){
          commit('CheckPay')

        } 
      }).catch(()=>{
        commit('HomeErr')
      })

    }

  
  },

  
})