<template>
  <v-app>
    <div v-if="role ==='ROLE_ADMIN'">
      <AdminMain></AdminMain>
    </div>
    <div v-else>
      <UserMain></UserMain>
    </div>
    
 <ErrorHanding></ErrorHanding>
  </v-app>
</template>

<script>

import ErrorHanding from '@/components/ErrorHanding.vue'
import UserMain from "@/UserMain.vue"
import AdminMain from "@/AdminMain.vue"
import {mapActions, mapState} from 'vuex'


export default {
  data(){
    return{
 
    
    }
  },

  beforeCreate(){
    this.$store.state.role = localStorage.getItem('role')
  },

  components: {
    UserMain,
    ErrorHanding,
    AdminMain
  },

  methods: {
    ...mapActions(['Alogin', 'Asignup'])
  },
  computed: {
    ...mapState(['Ashow', 'role'])
  },

  
}
</script>

