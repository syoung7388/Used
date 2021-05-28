<template>
    <div>
        <v-text-field id="p_token" v-model="token"></v-text-field>
        <v-btn @click="G({token:token})">확인</v-btn>
    </div>

</template>
<script>
export default {
    name: 'PayReady',
    data(){

        return{
            que: null,
            token: null
             
        }
        
     },
    // beforeCreate(){
    //     var url = this.$store.state.payUrl
    //     window.open(url)
    // },

    methods: {
        G(payload){
            alert(payload.token)
        }

    },

    

}
</script>