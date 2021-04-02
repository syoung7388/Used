import Vue from 'vue'
import VueRouter from 'vue-router'
import UserEdit from '@/views/UserEdit.vue'
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
          path: '/edit',
          name: 'UserEdit',
          component: UserEdit,
  
          }
    ]
  }



]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
