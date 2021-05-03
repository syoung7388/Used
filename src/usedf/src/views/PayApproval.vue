<template>
    <div>
        <input id="c_token" :value="$route.query.pg_token">
        <v-btn @click="Back"></v-btn>
    </div>

</template>
<script>
import { mapState } from 'vuex'
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
            console.log(k_token)
            // localStorage.removeItem('k_token')
            // localStorage.setItem('k_token', a)
            this.$store.dispatch('ApprovalDetail', {k_token: k_token
              


            
            })


            self.close();
        }
    },
    computed: {
        ...mapState({payInfo:'payInfo'})
    }
    

}
</script>