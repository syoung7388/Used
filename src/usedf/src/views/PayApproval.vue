<template>
    <div>
        <input id="c_token" :value="$route.query.pg_token">
        <v-btn @click="Back"></v-btn>
    </div>

</template>
<script>
import { mapState } from 'vuex'
import eventBus from '@/main'
export default {
    name: 'PayReady',
    data(){

        return{
            que: null 
        }
        
    },
    beforeCreate(){
        this.$store.state.removeBar= true
        this.$store.state.Ashow= 3
        



    },
    methods: {
        Back(){
            // opener.document.getElementById("p_token").value 
            let k_token= document.getElementById("c_token").value
            //console.log(k_token)
            // localStorage.removeItem('k_token')
            // localStorage.setItem('k_token', a)
            //this.$store.dispatch('ApprovalDetail', {k_token: k_token}
            //eventBus.$emit('k_token', k_token)
            //opener.k_token()
           // opener.$store.dispatch('ApprovalDetail', {k_token: k_token})
           //window.opener.document.k_token
            //opener.parent.k_token()
           // window.opener.app.$root.$store.commit("KakaoReady_s", 'gg');
           
           
           window.opener.postMessage({k_token: k_token}, '*')


            //self.close();
        }
    },
    computed: {
        ...mapState({payInfo:'payInfo'})
    }
    

}
opener.popup = this


</script>