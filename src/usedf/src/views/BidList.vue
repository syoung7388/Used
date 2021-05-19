<template>
    <v-app>
        <v-container class="px-0 py-2"> 
            <v-btn style="font-size: large;" icon @click="BidBack">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <v-list three-line v-if="bidList.length !== 0">
                <h1 style="text-align: center; font-size: 15px" v-show="bidList[0].sale === 2">물건 거래를 완료시 꼭 확인 버튼을 눌러주세요</h1>
                <template 
                v-for="(item, index) in bidList"
                >  
                    <v-row justify="start" align="center" :key="item.a_num">
                        <v-col cols="9"> 
                            <v-list-item 
                            @click="selectDetail({
                            a_num: item.a_num,
                            sale: item.sale
                            })">
                                <v-row justify="start" align="center">
                                    <v-col cols="5"  class="py-5">
                                        <v-card
                                        width="90"
                                        >
                                            <v-img 
                                            :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                            max-width="90"
                                            height="90" 
                                            >                                         
                                            </v-img>
                                        </v-card>
                                    </v-col>
                                    <v-col cols="7">
                                    <v-list-item-content class="ml-4">
                                        <v-list-item-title v-html="item.title" style="font-weight: bold"></v-list-item-title>
                                        <v-list-item-title style="font-weight: bold" class="mt-3">{{item.topprice|comma}} 원</v-list-item-title>
                                    </v-list-item-content>
                                    </v-col>
                                </v-row>
                            </v-list-item>
                        </v-col>
                        <v-col  v-show="item.sale === 2" cols="3" class="pa-0">
                            <v-btn class="primary" small  @click="AucEnd({a_num: item.a_num})">확인</v-btn>    
                        </v-col>
                        <v-col cols="3">
                            <v-list-item-title  style="font-size: 10px" class="mt-3"  v-show="item.sale === 1" >대기시간</v-list-item-title>
                            <v-list-item-title v-show="item.sale === 1" class="mt-2 primary--text">
                                <CountDown :endtime="item.offer[0].endtime" :o_num="item.offer[0].o_num" :sale="item.sale"></CountDown>
                            </v-list-item-title>
                        </v-col>   
       
                    </v-row>
                  
                    <v-divider
                        v-if="index < bidList.length-1"
                        :key="index"
                    ></v-divider>
                </template>
            </v-list>
            <NullError name="경매가"></NullError>
            </v-container>
    </v-app>
</template>
<script>
import CountDown from '@/components/CountDown.vue'
import {mapActions, mapState} from 'vuex'
import NullError from '@/components/NullError.vue'
export default {
    computed: {
        ...mapState(['bidList'])
    },
    filters:{
      comma(price){
        var num = new Number(price)
        return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
      }
    },
    methods: {
        ...mapActions(['getBidDetail', 'getPayDetail', 'AucEnd']),
        BidBack(){
            this.$store.state.removeBar = false
            this.$router.go(-1)
        },
        selectDetail(payload){
            (payload.sale === 0)? this.$store.dispatch('getBidDetail', {a_num: payload.a_num}): this.$store.dispatch('getPayDetail', {a_num: payload.a_num})
        }
    },
    components:{
        CountDown,
        NullError
    }

    
}
</script>