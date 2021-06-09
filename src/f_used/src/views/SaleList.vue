<template>
    <v-app>
        <v-container class="px-0 py-2"> 
            <v-btn style="font-size: large;" icon @click="SaleBack">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <v-list three-line v-show="saleList.length > 0">
                <template 
                v-for="(item, index) in saleList"
                >  
                    <v-list-item 
                    :key="item.a_num"
                    @click="getSaleDetail({
                    a_num: item.a_num
                    })"
                    >         
                        <v-row justify="start" align="center">
                                <v-col cols="3"  class="py-5">
                                    <v-card
                                    width="90"
                                    >
                                        <v-img 
                                        :src="getImg(item.product[0].picture[0].pictureName)"
                                        max-width="90"
                                        height="90" 
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                <v-list-item-content class="ml-4">
                                    <v-list-item-title v-html="item.title" style="font-weight: bold"></v-list-item-title>
                                    <v-list-item-title style="font-weight: bold" class="mt-3" v-if="item.sale === 0">{{item.topprice|comma}} 원</v-list-item-title>
                                    <v-list-item-title style="font-weight: bold" class="mt-3" v-else-if="item.sale === 1">{{item.offer[0].price|comma}} 원</v-list-item-title>
                                    <v-list-item-title style="font-weight: bold" class="mt-3" v-else>{{item.payment.amount.total|comma}} 원</v-list-item-title>
                                </v-list-item-content>
                                </v-col>
                                <v-col cols="3" v-show="item.sale === 1" class="pa-0"> 
                                    <v-card class="mr-2 primary--text" height="80" style="border: solid grey;">
                                        <v-card-text class="mb-3">
                                            <h1 style="font-size: 10px; text-align:center">대기시간</h1>
                                            <CountDown :endtime="item.offer[0].endtime" :o_num="item.offer[0].o_num" :sale="item.sale"></CountDown>
                                        </v-card-text>
                                    </v-card>
                                </v-col>  
                                <v-col cols="3" align-self="start" class="mt-8" v-if="item.sale === 0">
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day === 0">D-day</v-list-item-title >
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day < 0">D{{item.d_day}}</v-list-item-title >
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day > 0">기간종료</v-list-item-title >                   
                                </v-col>    
                        </v-row>
                    </v-list-item>
                    <v-divider
                        v-if="index < saleList.length- 1"
                        :key="index"
                    ></v-divider>
                </template>
            </v-list>
            <NullError name="제품이"></NullError>
        </v-container>
    </v-app>
</template>
<script>
import {checkImg} from '@/mixins/checkImg.js'
import CountDown from '@/components/CountDown.vue'
import NullError from '@/components/NullError.vue'
import {mapActions, mapState} from 'vuex'
export default {
    mixins: [checkImg],
    beforeCreate(){
        this.$store.state.removeBar =true
    },
    data(){
        return{
            
        }
    },
    computed: {
        // <!-- +item.product[0].picture[0].pictureName-->
        ...mapState(['saleList', 'nullerr'])
    },
    filters:{
      comma(price){
        var num = new Number(price)
        return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
      }
    },
    methods: {
        ...mapActions(['getSaleDetail']),
        SaleBack(){
            this.$store.dispatch('getSaleStatistic')
        },
    },
    components:{
        CountDown,
        NullError
    }

    
}
</script>