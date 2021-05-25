import Vue from 'vue'
import VueRouter from 'vue-router'
import MyPage from '@/views/MyPage.vue'

Vue.use(VueRouter)



const routes = [
  {
    path:'/app',
    name: 'App',
    component: () => import(/* webpackChunkName: "appp" */'@/App.vue')
  },

  
  {
    path:'/home',
    name: 'Home',
    component: () => import(/* webpackChunkName: "home" */'@/views/Home.vue')
  },
  {
    path: '/writing',
    name: 'Writing',
    component: () => import(/* webpackChunkName: "writing" */'@/views/Writing.vue')
  },

  {
    path: '/sale',
    name: 'Sale',
    component: () => import(/* webpackChunkName: "sale" */'@/views/Sale.vue')

  },
  {
    path: '/salelist',
    name: 'SaleList',
    component: () => import(/* webpackChunkName: "salelist" */'@/views/SaleList.vue'),
  },
  {      
    path: '/saledetail',
    name: 'SaleDetail',
    component: () => import(/* webpackChunkName: "saledetail" */'@/views/SaleDetail.vue'),

  },
  {
    path: '/detail',
    name: 'Detail',
    component: () => import(/* webpackChunkName: "detail" */'@/views/Detail.vue'),
  },
  {
    
    path: '/industrylist',
    name: 'IndustryList',
    component: () => import(/* webpackChunkName: "industrylist" */'@/views/IndustryList.vue')

  },
  {
    
    path: '/kindlist',
    name: 'KindList',
    component: () => import(/* webpackChunkName: "kindlist" */'@/views/KindList.vue')

  },
  {
    path: '/bid',
    name: 'Bid',
    component: () => import(/* webpackChunkName: "bid" */'@/views/Bid.vue')

  },

  {
    path: '/bidlist',
    name: 'BidList',
    component: () => import(/* webpackChunkName: "bidlist" */'@/views/BidList.vue')

  },
  {
    path: '/biddetail',
    name: 'BidDetail',
    component: () => import(/* webpackChunkName: "biddetail" */'@/views/BidDetail.vue')

  },
  {
    path: '/paydetail',
    name: 'PayDetail',
    component: () => import(/* webpackChunkName: "paydetail" */'@/views/PayDetail.vue')

  },
  {
    path: '/likelist',
    name: 'LikeList',
    component: () => import(/* webpackChunkName: "likelist" */'@/views/LikeList.vue')

  },
  {
    path: '/likedetail',
    name: 'LikeDetail',
    component: () => import(/* webpackChunkName: "likedetail" */'@/views/LikeDetail.vue')

  },
  {
    path: '/paymethod',
    name: 'PayMethod',
    component: () => import(/* webpackChunkName: "paymethod" */'@/views/PayMethod.vue')

  },
  {
    path: '/payready',
    name: 'PayReady',
    component: () => import(/* webpackChunkName: "payready" */'@/views/PayReady.vue')

  },
  {
    path: '/payapproval',
    name: 'PayApproval',
    component: () => import(/* webpackChunkName: "payapproval" */'@/views/PayApproval.vue')

  },
  {
    path: '/chat',
    name: 'Chat',
    component: () => import(/* webpackChunkName: "chat" */'@/views/Chat.vue')

  },
  {
    path: '/chatlist',
    name: 'ChatList',
    component: () => import(/* webpackChunkName: "chatlist" */'@/views/ChatList.vue')

  },
  {
    path: '/auth',
    name: 'Auth',
    component: () => import(/* webpackChunkName: "auth" */'@/views/Auth.vue')

  },
  {
    path: '/account',
    name: 'Account',
    component: () => import(/* webpackChunkName: "account" */'@/views/Account.vue')

  },
  {
    path: '/turnover',
    name: 'TurnOver',
    component: () => import(/* webpackChunkName: "turnover" */'@/views/TurnOver.vue')

  },
  

  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
    children: [
        {
          path: '/passwordedit',
          name: 'PasswordEdit',
          component: () => import(/* webpackChunkName: "passwordedit" */'@/views/UserEditDelete/PasswordEdit.vue')
      
        },
        {
          path: '/phonedit',
          name: 'PhonEdit',
          component: () => import(/* webpackChunkName: "phonedit" */'@/views/UserEditDelete/PhonEdit.vue')
      
        },
        {
          path: '/nameedit',
          name: 'NameEdit',
          component: () => import(/* webpackChunkName: "nameedit" */'@/views/UserEditDelete/NameEdit.vue')
      
        },
        {
          path: '/addressedit',
          name: 'AddressEdit',
          component: () => import(/* webpackChunkName: "addressedit" */'@/views/UserEditDelete/AddressEdit.vue')
      
        },
        {
          path:'/delete',
          name: 'UserDelete',
          component: () => import(/* webpackChunkName: "delete" */'@/views/UserEditDelete/UserDelete.vue')

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
