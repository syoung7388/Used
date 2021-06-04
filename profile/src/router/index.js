import Vue from 'vue'
import VueRouter from 'vue-router'


Vue.use(VueRouter)

const routes = [

  {
    path: '/words',
    name: 'Words',

    component: ()=> {
      return import(/* webpackChunkName: "about" */ '../views/Words.vue')
    }
  },
  {
    path: '/auction',
    name: 'Auction',
    component: ()=> {
      return import(/* webpackChunkName: "about" */ '../views/Auction.vue')
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
