  
<template>
   <v-app>
      <v-container  id="container" style="width: 100%; height: 100%;">
         <v-row  align="center" style="height: 100%;">
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
               :type="p"
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
         multiline: true,
         p: 'Password'
      }
   },
   methods: {
      ...mapActions(['Login','nowLatLon']),
      Choose(payload){
         this.$store.state.Storage.setItem('role', payload)
         this.$store.state.role_choose = false
         console.log( this.$store.state.Storage.getItem('role'))
         if( this.$store.state.Storage.getItem('role') === 'ROLE_ADMIN'){
            this.$router.push({name: 'App'})
         }else{
            this.nowLatLon()   
         }     
      }


   },
   computed: {
      ...mapState(['isLoginError', 'role_choose', 'Roles', 'role'])
   },

}
</script>