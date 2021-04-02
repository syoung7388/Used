<template>
  <v-app>
      <v-container id="container" v-show="Ashow === 0">
        <v-row align="center" id="row">
          <v-col>
            <div class="text-center">                   
              <h2 class="primary--text" style="font-size: 70px; text-align: center" > 
                Used
              </h2>
              <v-spacer></v-spacer>
              <v-btn @click="Alogin" class="ml-2">로그인</v-btn>
              <v-btn @click="Asignup" class="ml-2"> 회원가입</v-btn> 
            </div>
          </v-col>
        </v-row>
      </v-container>    
        <div v-show="Ashow=== 1">
          <Login></Login>
        </div>
        <div v-show="Ashow=== 2">
          <Phone></Phone>
        </div>
        <div v-show="Ashow=== 3">
          <Main></Main>
        </div>
  </v-app>
</template>



<script>

import Login from "@/components/Login.vue"
import Phone from "@/components/Phone.vue"
import Main from "@/Main.vue"
import {mapActions, mapState} from 'vuex'


export default {

  components: {
    Login,
    Phone,
    Main
  },

  methods: {
    ...mapActions(['Alogin', 'Asignup'])
  },
  computed: {
    ...mapState(['Ashow'])
  }
  
}
</script>
<style>
.container{
  width: 100%;
  height: 100%;
}
</style>

