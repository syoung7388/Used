import Vue from 'vue'
import VueRouter from 'vue-router'
import MyPage from '@/views/MyPage.vue'
import App from '@/App.vue'
import Home from '@/views/Home.vue'
import Writing from '@/views/Writing.vue'
import Sale from '@/views/Sale.vue'
import SaleList from '@/views/SaleList.vue'
import SaleDetail from '@/views/SaleDetail.vue'
import Detail from '@/views/Detail.vue'
import IndustryList from '@/views/IndustryList.vue' 
import KindList from '@/views/KindList.vue'
import Offer from '@/views/Offer.vue'
import OfferList from '@/views/OfferList.vue'
import OfferDetail from '@/views/OfferDetail.vue'
import PayDetail from '@/views/PayDetail.vue'
import LikeList from '@/views/LikeList.vue'
import LikeDetail from '@/views/LikeDetail.vue'
import PayMethod from '@/views/PayMethod.vue'
import Chat from'@/views/Chat.vue'
import ChatList from '@/views/ChatList.vue'
import Auth from '@/views/Auth.vue'
import Account from '@/views/Account.vue'
import TurnOver from '@/views/TurnOver.vue'
import PasswordEdit from '@/views/UserEditDelete/PasswordEdit.vue'
import PhonEdit from '@/views/UserEditDelete/PhonEdit.vue'
import NameEdit from '@/views/UserEditDelete/NameEdit.vue'
import AddressEdit from '@/views/UserEditDelete/AddressEdit.vue'
import UserDelete from '@/views/UserEditDelete/UserDelete.vue'





Vue.use(VueRouter)


const routes = [
  {
    path:'/',
    name: 'App',
    component: App
  },

  
  {
    path:'/home',
    name: 'Home',
    component: Home
  },
  {
    path: '/writing',
    name: 'Writing',
    component: Writing
  },

  {
    path: '/sale',
    name: 'Sale',
    component: Sale

  },
  {
    path: '/salelist',
    name: 'SaleList',
    component: SaleList
  },
  {      
    path: '/saledetail',
    name: 'SaleDetail',
    component: SaleDetail

  },
  {
    path: '/detail',
    name: 'Detail',
    component: Detail,
  },
  {
    
    path: '/industrylist',
    name: 'IndustryList',
    component: IndustryList

  },
  {
    
    path: '/kindlist',
    name: 'KindList',
    component: KindList

  },
  {
    path: '/offer',
    name: 'Offer',
    component: Offer

  },

  {
    path: '/offerlist',
    name: 'OfferList',
    component: OfferList

  },
  {
    path: '/offerdetail',
    name: 'OfferDetail',
    component: OfferDetail

  },
  {
    path: '/paydetail',
    name: 'PayDetail',
    component: PayDetail

  },
  {
    path: '/likelist',
    name: 'LikeList',
    component: LikeList

  },
  {
    path: '/likedetail',
    name: 'LikeDetail',
    component:LikeDetail

  },
  {
    path: '/paymethod',
    name: 'PayMethod',
    component: PayMethod

  },

  {
    path: '/chat',
    name: 'Chat',
    component: Chat

  },
  {
    path: '/chatlist',
    name: 'ChatList',
    component: ChatList

  },
  {
    path: '/auth',
    name: 'Auth',
    component: Auth

  },
  {
    path: '/account',
    name: 'Account',
    component: Account

  },
  {
    path: '/turnover',
    name: 'TurnOver',
    component: TurnOver

  },
  

  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
    children: [
        {
          path: '/passwordedit',
          name: 'PasswordEdit',
          component: PasswordEdit
      
        },
        {
          path: '/phonedit',
          name: 'PhonEdit',
          component:  PhonEdit
      
        },
        {
          path: '/nameedit',
          name: 'NameEdit',
          component: NameEdit
        
        },
        {
          path: '/addressedit',
          name: 'AddressEdit',
          component: AddressEdit
      
        },
        {
          path:'/delete',
          name: 'UserDelete',
          component: UserDelete

        }

    ]
  }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,routes,
  scrollBehavior(to, from, savedPostion){
    if(savedPostion){
      console.log(savedPostion)
      return savedPostion
    } else{
      return {x: 0, y:0}
    }

  }
})

export default router
