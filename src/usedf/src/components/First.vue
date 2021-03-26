<template>
  <v-app>
    
    <div class="ok" v-show="show === 0"> 
      <v-row>
        <v-col>
            <h4 class="primary--text" style="font-size: 70px; text-align: center" >Used</h4>
            <v-spacer></v-spacer>
          </v-col>
        </v-row>
      <v-btn @click="login">로그인</v-btn>
      <v-btn @click="signup">회원가입</v-btn>
    </div>

    <div v-show="show=== 1">
      <Login></Login>
    </div>

    <div v-show="show=== 2">
      <Signup></Signup>
    </div>
    

  </v-app>
</template>

<script>
import Login from "@/components/Login.vue"
import Signup from "@/components/Signup.vue"


export default ({

  components: {
    Login,
    Signup
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
    }

  }
  
})
</script>


<style>
</style>
