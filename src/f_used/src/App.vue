<template>
  <v-app>
    <div v-if="Kshow === true"> 
      <router-view></router-view>
    </div>
    <div v-else>
      <Main></Main>
    </div>
    
 <ErrorHanding></ErrorHanding>
  </v-app>
</template>

<script>

import Login from "@/components/Login.vue"
import Phone from "@/components/Phone.vue"
import ErrorHanding from '@/components/ErrorHanding.vue'
import Main from "@/Main.vue"
import {mapActions, mapState} from 'vuex'


export default {
  data(){
    return{
    
    }
  },

  components: {
    Login,
    Phone,
    Main,
    ErrorHanding
  },

  methods: {
    ...mapActions(['Alogin', 'Asignup'])
  },
  computed: {
    ...mapState(['Ashow', 'Kshow'])
  },

  
}
</script>
<style>
.C{
  width: 100%;
  height: 100%;
}
.Arow{
  height: 100%;
}
</style>

