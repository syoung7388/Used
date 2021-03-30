<template>
  <v-app>
    <div v-show="show === 0" class="text-center">
       <v-container>
          <v-row align="center" style="height: 100vh">
            <v-col>                   
              <h2 class="primary--text" style="font-size: 70px; text-align: center" > 
                Used
              </h2>
              <v-spacer></v-spacer>
              <v-btn @click="login" class="ml-2">로그인</v-btn>
              <v-btn @click="signup" class="ml-2"> 회원가입</v-btn>
            </v-col>
          </v-row> 
        </v-container>
    </div>
    <div v-show="show=== 1">
      <Login></Login>
    </div>
    <div v-show="show=== 2">
      <Phone></Phone>
    </div>
  </v-app>
</template>

<script>
import Login from "@/components/Login.vue"
import Phone from "@/components/Phone.vue"
export default ({
  components: {
    Login,
    Phone
  },
  data() {
    return{
      show: 0
    }
  },
  methods: {
    login(){
      this.show = 1
    },
    signup(){
      this.show = 2
    },
  }
  
})
</script>

