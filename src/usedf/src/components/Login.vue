<template>
   <v-app>
      <v-container  id="container">
         <v-row  align="center" id="row">
            <v-col>
               <div v-show="isLoginError === true">
                  <v-alert
                  dense
                  text
                  type="error"
                  x-small
                  >
                     아이디와 비밀번호를 확인하세요
                  </v-alert>
               </div>
               
               <h1 style="font-size: 40px; text-align: center"  class="primary--text">Login</h1>
               <v-text-field
               label="e-mail"
               v-model="username"
               required
               class="mt-5"
               ></v-text-field>
               <v-text-field
               class="mt-5 mb-10"
               label="password"
               v-model="password"
               required
               ></v-text-field>
               <v-btn @click="login({
                  username,
                  password
                  })"
                block
                x-large
                class="primary"
                >확인</v-btn>
            </v-col>
         </v-row>

      </v-container>
   </v-app>
</template>
<script>
import { mapActions, mapState } from 'vuex'

export default {

   data(){
      return{
         username: null,
         password: null,
      }
   },


   methods: {
      ...mapActions(['login'])
   },
   computed: {
      ...mapState(['isLoginError'])
   }

}
</script>



<style>

.container{
   width: 100%;
   height: 100%;
}
.row{
   height: 100%;

}

</style>