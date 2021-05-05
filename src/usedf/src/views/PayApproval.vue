<template>
    <div class="py-15">
        <v-row justify="center">
            <input id="c_token" :value="$route.query.pg_token" hidden>
            <v-col cols="12" v-if="pay_err === false">
                <h1  style="font-size: 20px; text-align:center;">고객님 돌아가기 버튼을 눌러주세요!</h1>
            </v-col>
            <v-col cols="4">
                <v-btn @click="Back" text large class="primary" block >돌아가기</v-btn>
            </v-col>
            <v-col cols="5" v-if="pay_err === true">
                <h1  style="font-size: 20px; text-align:center;">고객님 결제 오류가 발생했습니다. 다시 결제 부탁 드립니다.</h1>
            </v-col>
        </v-row>
    </div>

</template>
<script>
import { mapState } from 'vuex'
import eventBus from '@/main'
export default {
    name: 'PayReady',
    data(){

        return{
            pay_err: false 
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
           
           if(k_token !== null){
                window.opener.postMessage({k_token: k_token}, '*')
                self.close();
           } else{

               this.pay_err = true
               self.closed();

           }

        }
    },
    computed: {
        ...mapState({payInfo:'payInfo'})
    }
    

}
opener.popup = this


</script>