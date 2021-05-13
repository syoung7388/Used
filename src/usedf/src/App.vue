<template>
  <v-app>
        <div>
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
.C{
  width: 100%;
  height: 100%;
}
.Arow{
  height: 100%;
}
</style>

