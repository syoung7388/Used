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
                    <v-list-item 
                    :key="item.a_num"
                    @click="selectDetail({
                    a_num: item.a_num,
                    sale: item.sale
                    })"
                    > 
                        <v-row justify="start" align="center">
                                <v-col cols="3"  class="py-5">
                                    <v-card
                                    width="90"
                                    >
                                        <v-img 
                                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                        max-width="90"
                                        height="90" 
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                <v-list-item-content class="ml-4">
                                    <v-list-item-title v-html="item.title" style="font-weight: bold"></v-list-item-title>
                                    <v-list-item-title style="font-weight: bold" class="mt-3">{{item.topprice|comma}} 원</v-list-item-title>
                                </v-list-item-content>
                                </v-col>
                                <v-col class="mt-5" v-if="item.sale === 2">
                                    <v-btn class="primary" small >확인</v-btn>    
                                </v-col>
                                <v-col cols="3" align-self="start" class="mt-5" v-else>
                                    <v-list-item-title  style="text-align: right; font-size: 15px" v-show="item.sale === 0">D{{item.d_day}}</v-list-item-title>
                                    <v-list-item-title  style="text-align: right; font-size: 15px" v-show="item.sale === 1">D-day</v-list-item-title>                    
                                </v-col>    
                        </v-row>
                    </v-list-item>
                    <v-divider
                        v-if="index < bidList.length-1"
                        :key="index"
                    ></v-divider>
                </template>
            </v-list>
            <v-list v-else>
                <v-list-item-title style="text-align: center; font-size: 17px" class="text--black">현재 진행중인 제품이 없습니다</v-list-item-title>
            </v-list>
            </v-container>
    </v-app>
</template>
<script>
import {mapActions, mapState} from 'vuex'
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
        ...mapActions(['getBidDetail', 'getPayDetail']),
        BidBack(){
            this.$store.state.removeBar = false
            this.$router.go(-1)
        },
        selectDetail(payload){
            (payload.sale === 0)? this.$store.dispatch('getBidDetail', {a_num: payload.a_num}):this.$store.dispatch('getPayDetail', {a_num: payload.a_num})
        }
    },

    
}
</script>