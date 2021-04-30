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
                    @click="Kakao({
                        a_num: offerInfo.a_num,
                        o_num: offerInfo.o_num,
                        o_username: offerInfo.o_username,
                        price: offerInfo.price,
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
import {mapActions, mapState} from 'vuex'
export default {
    computed:{

        ...mapState(['offerInfo', 'proInfo'])

    },
    methods:{
        ...mapActions(['Kakao']),
        Toss(){
            
        }
    }
}
</script>