<template>
  <v-app>
    <v-app-bar color="white">
      <v-app-bar-nav-icon @click="drawer = true"> <i class="fas fa-bars fa-2x primary--text"></i></v-app-bar-nav-icon>
    </v-app-bar>
    <v-container class=".container">
      <v-navigation-drawer
      v-model="drawer"
      absolute
      temporary
      >
      <v-row class="pt-5" align="center" justify="start">
        <v-col cols="12">
          <v-list>
            <v-list-item-group active-class="primary--text text--accent-4" v-model="model">
              <v-list-item router :to="{name:'Words'}">
                  <h1 style="font-size: 15px; text-align:left" class="py-3">기술 언어</h1>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-col>
      </v-row>
      <v-divider class="my-3"></v-divider>
      <v-row align="center" justify="start" class="pl-3">
        <v-col cols="10">
          <h1 style="font-size: 15px; text-align:left">첫차(경매 시스템)</h1>
        </v-col>
      </v-row>
      <v-row align="center" justify="start"> 
        <v-col cols="2">
        </v-col>
        <v-col cols="9">
          <v-list dense>
            <v-list-item-group>
              <v-list-item router :to="{name:'Auction'}">
                <p>경매기능</p>
              </v-list-item>
              <v-list-item>
                <p>Open API</p>
              </v-list-item>
              <v-list-item>
                <p>채팅(Node.js)</p>
              </v-list-item>
              <v-list-item>
                <p>결제 기능</p>
              </v-list-item>
              <v-list-item>
                <p>회원가입</p>
              </v-list-item>
              <v-list-item>
                <p>통계/회계</p>
              </v-list-item>
              <v-list-item>
                <p>거리계산(List)</p>
              </v-list-item>
              <v-list-item>
                <p>프로젝트 구조</p>
              </v-list-item>
              <v-list-item>
                <p>WebView</p>
              </v-list-item>
              <v-list-item>
                <p>이미지 저장</p>
              </v-list-item>
            </v-list-item-group>
          </v-list>
        </v-col>
      </v-row>
      <v-divider  class="my-3"></v-divider>
      </v-navigation-drawer>
      <router-view></router-view>      
    </v-container>
  </v-app>
</template>
<script>
export default {
  data(){
    return{
      drawer: false,
      group: null,
      model: null, 
    }
  },
  methods:{
    Words(){
      alert("aaa")
      this.model= null
    }

  }
}
</script>
<style>
.container{
    height: 95%;
}

</style>