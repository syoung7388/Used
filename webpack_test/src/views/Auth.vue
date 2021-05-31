<template>
  <v-app>
      <v-container id="C" v-show="auth_show === 0">
        <v-btn 
        style="font-size: large;" 
        icon  
        @click="Back" 
        >
            <i class="fas fa-arrow-left" style="font-size: large;"></i>
        </v-btn>
        <v-row align="center" class="Arow">
          <v-col>
            <div class="text-center">                   
              <h1 style="font-size: 20px" class="mb-10">고객님 로그인이 필요한 페이지 입니다.</h1>
              <v-spacer></v-spacer>
              <v-btn @click="Auth_login" class="ml-2 primary">로그인</v-btn>
              <v-btn @click="Auth_signup" class="ml-2 primary"> 회원가입</v-btn> 
            </div>
          </v-col>
        </v-row>
      </v-container>    
        <div v-show="auth_show=== 1">
          <Login></Login>
        </div>
        <div v-show="auth_show=== 2">
          <Phone></Phone>
        </div>
  </v-app>
</template>

<script>

import Login from "@/components/Login.vue"
import Phone from "@/components/Phone.vue"
import {mapActions, mapMutations, mapState} from 'vuex'


export default {
    beforeCreate(){
        this.$store.state.removeBar = true    
    },

  components: {
    Login,
    Phone
  },

  methods: {
    ...mapMutations(['Auth_login', 'Auth_signup', 'Back'])
  },
  computed: {
    ...mapState(['auth_show', 'removeBar'])
  }
  
}
</script>
<style>
.C{
  width: 100%;
  height: 100%;
}
.Arow{
  height: 90%;
}
</style>

