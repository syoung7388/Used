<template>
    <v-app>
        <v-container class="pa-0">
            <v-carousel            
            height="260"
            >
                <v-carousel-item
                v-for="(item, i) in beforeImage"
                :key="i"
                 :src="getImg(item.pictureName)"
                reverse-transition="fade-transition"
                transition="fade-transition"
                max-height= "300"
                hide-delimiter-background
                >
                <v-menu 
                offset-y
                absolute
                >
                    <template  v-slot:activator="{on}">
                        <v-row class="pt-1">
                            <v-col cols="10">
                                <v-btn 
                                style="font-size: large;" 
                                icon
                                v-on="on"
                                @click="Back" 
                                >
                                    <i class="fas fa-arrow-left" style="font-size: large;"></i>
                                </v-btn>
                            </v-col>
                        </v-row>
                    </template>
                    </v-menu>
                </v-carousel-item>
            </v-carousel>
            <v-row class="ma-0">
                <v-col cols="6" class="ma-0">
                    <v-list-item-title style="font-size: 16px; text-align: left">시작가: &nbsp; <span style="font-weight: bold">{{aucInfo.startprice| comma}}원</span></v-list-item-title>      
                    <v-list-item-title style="font-size: 16px; text-align: left">최고가: &nbsp;<span style="font-weight: bold">{{aucInfo.topprice| comma}}원</span></v-list-item-title>
                </v-col>
                <v-col cols="6" class="ma-0">
                    <v-list-item-title style="font-size: 11px; text-align: right">마감기간: &nbsp; {{aucInfo.enddate}}</v-list-item-title>      
                    <v-list-item-title style="font-size: 11px; text-align: right">조회수: &nbsp;{{aucInfo.hits}}</v-list-item-title>
                    <v-list-item-title v-if="aucInfo.d_day < 0" style="font-size: 11px; text-align: right">d-day: &nbsp;D{{aucInfo.d_day}}</v-list-item-title>
                    <v-list-item-title v-else style="font-size: 11px; text-align: right">d-day: &nbsp;거래완료</v-list-item-title>
                </v-col>
            </v-row>
            <v-row class="ma-0" justify="center" > 
                <v-expansion-panels flat>
                    <v-expansion-panel>
                        <v-expansion-panel-header class="grey--text">게시물 상세보기</v-expansion-panel-header>
                        <v-expansion-panel-content>
                            <v-row justify="start">
                                <v-col cols="12">
                                    <h1 style="font-size: 15px">{{aucInfo.title}}</h1> 
                                </v-col>
                            </v-row>
                               <v-row justify="start">
                                <v-col cols="12">
                                    <h1 style="font-size: 12px">{{aucInfo.content}}</h1> 
                                </v-col>
                            </v-row>
    
                        </v-expansion-panel-content>
                    </v-expansion-panel>
                </v-expansion-panels>       
            </v-row>
            <v-divider></v-divider>
                <v-tabs
                align-with-title
                fixed-tabs
                primary
                height= "43"
        
                >
                    <v-tabs-slider></v-tabs-slider>
                    <v-tab class="ml-0" style="font-size: 15px;">경매 순위</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">내 경매</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품 정보</v-tab>

                    <v-tab-item>
                        <OfferInfo></OfferInfo>
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="pt-3"> 
                            <v-row v-for="(item, int) in offerInfo" :key="int" align="center" justify="center" >
                                <v-col cols="4" v-show="item.o_username === userInfo.username">
                                    <h1 style="font-size: 17px; text-align:center" >{{item.price|comma}}원</h1>
                                </v-col>
                                <v-col cols="4" v-show="item.o_username === userInfo.username">
                                    <h1 style="font-size: 14px; text-align:center">{{item.time}}</h1>
                                </v-col>
                                <v-col cols="3" v-show="item.o_username === userInfo.username && aucInfo.sale === 0">
                                    <v-btn text color="primary" @click="OfferCancle({o_num: item.o_num, a_num: item.a_num})">철회</v-btn>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item>
                        <ProductInfo></ProductInfo>
                    </v-tab-item>
                </v-tabs>
                <v-bottom-navigation
                grow
                height="70"       
                fixed   
                >
                    <v-row class="my-1 mr-1" >
                        <v-col cols="2"   
                        >
                            <v-btn 
                            icon
                            class="mt-2 mr-1" 
                            @click="Like({a_num: aucInfo.a_num})"
                            v-show="heart === false" 
                            >
                               <i class="far fa-heart" style="font-size:26px"></i>
                            </v-btn>
                            <v-btn
                            icon 
                            class="mt-2 mr-1"
                            v-show="heart === true" 
                           @click="RemoveLike({a_num: aucInfo.a_num})"
                            >
                            
                                <i class="fas fa-heart red--text"  style="font-size:26px"></i>
                            </v-btn> 

                        </v-col> 
                        <v-col cols="6" class="ma-0" >
                            <input type="text" v-model="c_price" v-on="comma(c_price)"  style="font-size:17px;  text-align: left ; " class="mt-2 mx-2" placeholder="가격 입력란">
                        </v-col>
                  
                        <v-col cols="4" >
                            <v-btn large class="primary mt-1 mr-1" block>
                                <span style="font-size:15px;" class="white--text ma-2" @click="Offer">가격제안</span>
                            </v-btn>

                        </v-col>
                    </v-row>
                </v-bottom-navigation> 
        </v-container>
        <OfferOverlay ref="ch_overlay" @Origin="Origin"></OfferOverlay>

    </v-app>
</template>

<script>
import {mapState, mapActions , mapMutations} from 'vuex'
import OfferOverlay from '@/components/OfferOverlay.vue'
import {checkImg} from '@/mixins/checkImg.js'
import ProductInfo from '@/components/DetailComponents/ProductInfo'
import OfferInfo from '@/components/DetailComponents/OfferInfo'


export default {
    mixins: [checkImg],
    beforeCreate(){
        this.$store.state.removeBar =true
    },

    data(){
        return{
            c_price: '',
            price: 0

        }
    },
    filters:{
        comma(pri){
            var num = new Number(pri)
            return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
        }

                
    },
    computed: {
        
        ...mapState([ 'overlay', 'userInfo', 'heart','aucInfo','likeInfo','proInfo', 'offerInfo','addrInfo','beforeImage'])
    },
    methods: {
        Offer(){
            this.$refs.ch_overlay.Overlay({price: this.price, c_price:this.c_price })
        },
        Origin(){
            this.c_price = '',
            this.price = 0
        },
        comma(price){
            
            var n = price.replace(/\D/g,"")
            this.price = n
            var reg = /(^[+-]?\d+)(\d{3})/
            n += ''
            while(reg.test(n)){
                n= n.replace(reg, '$1'+','+'$2') 
            }
            this.c_price = n
           
        },

        Back(){
            this.$store.dispatch('getOfferList',{sale: this.aucInfo.sale})
        },
        ...mapActions(['OfferCancle', 'RemainDelete', 'Like', 'RemoveLike'])
    },
    components:{
        OfferOverlay,
        ProductInfo,
        OfferInfo

    }
 
}
</script>
