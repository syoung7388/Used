  
<template>
   <v-app>
      <v-container  id="container">
         <v-row  align="center" class="lrow">
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
               <v-btn @click="Login({
                  username,
                  password
                  })"
                block
                class="primary"
                >확인</v-btn>
            </v-col>
         </v-row>
         <v-snackbar
         v-model="role_choose"
         :multi-line="multiline"
         class="pb-5"
         >
            <p>로그인할 계정을 선택 해 주세요.</p>

            <template v-slot:action="{ attrs }">
               <v-btn
                  color="red"
                  text
                  v-bind="attrs"
                  @click="Choose(`ROLE_USER`)"
               >
                  User
               </v-btn>
               <v-btn
                  color="red"
                  text
                  v-bind="attrs"
                  @click="Choose(`ROLE_ADMIN`)"
               >
                  ADMIN
               </v-btn>
            </template>
         </v-snackbar>
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
         multiline: true
      }
   },
   methods: {
      ...mapActions(['Login','nowLatLon']),
      Choose(payload){
         localStorage.setItem('role', payload)
         this.$store.state.role_choose = false
         this.nowLatLon()
      }


   },
   computed: {
      ...mapState(['isLoginError', 'role_choose', 'Roles', 'role'])
   },

}
</script>



<style>
.container{
   width: 100%;
   height: 100%;
}
.lrow{
   height: 100%;
}
</style>