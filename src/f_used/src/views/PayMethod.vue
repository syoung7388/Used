<template>
    <v-app >
        <v-container>
            <v-row justify="start" class="mb-5">
                <v-col cols="3">
                    <v-btn style="font-size: large;" icon @click="Back" fixed>
                        <i class="fas fa-arrow-left" style="font-size: large;"></i>
                    </v-btn>
                </v-col>
            </v-row>
            <v-row justify="center" align="center">
                <h1 style="font-size: 20px">원하시는 지불수단을 클릭해 주세요.</h1>
                <v-col cols="3" class="mt-10">
                    <v-card
                    max-width="70"
                    max-height="70"
                    @click="KakaoReady({
                  
                        a_num: offerInfo[0].a_num,
                        o_num: offerInfo[0].o_num,
                        o_username: offerInfo[0].o_username,
                        price: offerInfo[0].price,
                        p_num: proInfo.p_num,
                        kind: proInfo.kind
                   
                    })"
                    >
                        <v-img
                        :src="require('@/PayImg/kakao.jpg')"
                        max-width="70"
                        max-height="70"
                        ></v-img>
                    </v-card>
                </v-col>
            </v-row>
        </v-container>
     
    </v-app>   
</template>
<script>
import {mapActions, mapState, mapMutations} from 'vuex'

export default {


    beforeCreate(){
        this.$store.state.removeBar =true
    },
    data(){
        return{
          
        }
    },
    computed:{

        ...mapState(['offerInfo', 'proInfo','payreadyInfo'])

    },
    methods:{
        ...mapActions(['KakaoReady']),
        ...mapMutations(['Back']),
        Token_Ok(payload){
            this.$store.dispatch('KakaoApprove', {
                o_num: this.payreadyInfo.o_num,
                o_username : this.payreadyInfo.o_username,
                price : this.payreadyInfo. price,
                p_num : this.payreadyInfo.p_num,
                kind : this.payreadyInfo.kind,
                a_num : this.payreadyInfo.a_num,
                kready_r: {
                tid: this.payreadyInfo.kready_r.tid,
                k_token: payload
                }

            })
      
        } 

  
    },
    created(){



    },
    mounted(){ 

        window.Token_Ok =this.Token_Ok
        
    }
}


</script>