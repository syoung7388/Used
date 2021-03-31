<template>
  <v-app>
      <v-container id="container">
        <v-row align="center" id="row">
          <v-col>
            <div v-show="Ashow === 0" class="text-center">                   
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
  </v-app>
</template>

<script>

import Login from "@/components/Login.vue"
import Phone from "@/components/Phone.vue"
import {mapActions, mapState} from 'vuex'


export default {

  components: {
    Login,
    Phone
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
.row{

   width: 100%;
   height: 100%;

}

</style>

