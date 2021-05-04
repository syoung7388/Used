<template>
    <v-app class="pa-5">
        <v-container>
            <v-row justify="center" align="center">
                <h1 style="font-size: 20px">원하시는 지불수단을 클릭해 주세요.</h1>
                <v-col cols="3" class="mt-10">
                    <v-card
                    max-width="70"
                    max-height="70"
                    @click="Toss"
                    >
                        <v-img
                        :src="require('@/PayImg/toss.png')"
                        max-width="70"
                        max-height="70"
                        ></v-img>
                    </v-card>
                </v-col>
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
            <!-- <v-btn @click="k_token"></v-btn> -->
        </v-container>
    </v-app>   
</template>
<script>
import {mapActions, mapState} from 'vuex'
import eventBus from '@/main'
export default {
    computed:{

        ...mapState(['offerInfo', 'proInfo'])

    },
    methods:{
        ...mapActions(['KakaoReady']),
        Toss(){ 
        },
  
    },
    created(){



     }
}
function k_token(){
            console.log("k_token")
        
}

</script>