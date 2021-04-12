import Vue from 'vue'
import VueRouter from 'vue-router'
import EmailEdit from '@/views/UserEditDelete/EmailEdit.vue'
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
    path: '/salelist',
    name: 'SaleList',
    component: () => import(/* webpackChunkName: "salelist" */'@/views/SaleList.vue'),
    children:[
      {      
        path: '/saledetail',
        name: 'SaleDetail',
        component: () => import(/* webpackChunkName: "saledetail" */'@/views/SaleDetail.vue'),


      }
    ]
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
  base: process.env.BASE_URL,
  routes
})

export default router
