import Vue from 'vue'
import VueRouter from 'vue-router'
import EmailEdit from '@/views/UserEdit/EmailEdit.vue'
import MyPage from '@/views/MyPage.vue'

Vue.use(VueRouter)

const routes = [
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
    path: '/salelist',
    name: 'SaleList',
    component: () => import(/* webpackChunkName: "salelist" */'@/views/SaleList.vue')
  },
  {
    path: '/buyinglist',
    name: 'BuyingList',
    component: () => import(/* webpackChunkName: "buyinglist" */'@/views/BuyingList.vue')

  },
  {
    path: '/mypage',
    name: 'MyPage',
    component: MyPage,
    children: [
        {
          path: '/emailedit',
          name: 'EmailEdit',
          component: EmailEdit, 
        },  
        {
          path: '/passwordedit',
          name: 'PasswordEdit',
          component: () => import(/* webpackChunkName: "passwordedit" */'@/views/UserEdit/PasswordEdit.vue')
      
        },
        {
          path: '/phonedit',
          name: 'PhonEdit',
          component: () => import(/* webpackChunkName: "phonedit" */'@/views/UserEdit/PhonEdit.vue')
      
        },
        {
          path: '/nameedit',
          name: 'NameEdit',
          component: () => import(/* webpackChunkName: "nameedit" */'@/views/UserEdit/NameEdit.vue')
      
        },
        {
          path: '/addressedit',
          name: 'AddressEdit',
          component: () => import(/* webpackChunkName: "addressedit" */'@/views/UserEdit/AddressEdit.vue')
      
        },

    ]
  }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
