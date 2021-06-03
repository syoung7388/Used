<template>
    <v-app>
        <v-container class="px-0 py-2"> 
            <v-btn style="font-size: large;" icon @click="Back">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <v-list three-line v-if="offerList.length !== 0">
                <h1 style="text-align: center; font-size: 15px" v-show="offerList[0].sale === 2" class="mb-4">물건 거래를 완료시 꼭 확인 버튼을 눌러주세요</h1>
                <template 
                v-for="(item, index) in offerList"
                >
          
                    <v-row  :key="item.a_num"  v-if="item.sale === 2" align="center" >
                        <v-col cols="8"> 
                            <v-list-item 
                            @click="selectDetail({
                            a_num: item.a_num,
                            sale: item.sale
                            })">
                                <v-row justify="center" align="center">
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
                                            <v-list-item-title style="font-size: 15px" class="mt-3">{{item.offer[0].price|comma}} 원</v-list-item-title>
                                        </v-list-item-content>
                                    </v-col>
                                </v-row>
                            </v-list-item>
                        </v-col>
                        <v-col  v-show="item.sale === 2" cols="3" class="pl-7">
                            <v-btn class="primary--text" large dense  @click="AucEnd({a_num: item.a_num})">확인</v-btn>    
                        </v-col>
                    </v-row>
                
                    <v-list-item 
                    @click="selectDetail({
                    a_num: item.a_num,
                    sale: item.sale
                    })"
                    :key="item.a_num" 
                    v-else
                    >  
                        <v-row justify="start" align="center" >
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
                            <v-col cols="3" v-if="item.sale === 1" class="pa-0"> 
                                <v-card class="mr-2 primary--text" height="80" style="border: solid grey;">
                                    <v-card-text class="mb-3">
                                        <h1 style="font-size: 10px; text-align:center">대기시간</h1>
                                        <CountDown :endtime="item.offer[0].endtime" :o_num="item.offer[0].o_num" :sale="item.sale"></CountDown>
                                    </v-card-text>
                                </v-card>
                            </v-col>  
                            <v-col cols="3" align-self="start" class="mt-8" v-show="item.sale === 0">
                                <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day === 0">D-day</v-list-item-title >
                                <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day < 0">D{{item.d_day}}</v-list-item-title >
                                <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day > 0">경매종료</v-list-item-title >                   
                            </v-col>
                        </v-row>
                    </v-list-item> 
                  
                    <v-divider
                        v-if="index < offerList.length-1"
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
    beforeCreate(){
        this.$store.state.removeBar =true
    
    },
    computed: {
        ...mapState(['offerList'])
    },
    filters:{
      comma(price){
        var num = new Number(price)
        return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
      }
    },
    methods: {
        ...mapActions([ 'getPayDetail', 'AucEnd']),
        Back(){
            this.$store.dispatch('getOfferStatistic')
        },
        selectDetail(payload){
            (payload.sale === 0)? this.$store.dispatch('getOfferDetail', {a_num: payload.a_num}): this.$store.dispatch('getPayDetail', {a_num: payload.a_num})
        }
    },
    components:{
        CountDown,
        NullError
    },

    
}
</script>