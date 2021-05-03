<template>
    <div>
        <input id="c_token" :value="$route.query.pg_token">
        <v-btn @click="Back"></v-btn>
    </div>

</template>
<script>
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
            var a= document.getElementById("c_token").value
            localStorage.setItem('k_token', a)
            
           // self.close();
        }
    }
    

}
</script>