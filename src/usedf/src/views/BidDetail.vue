<template>
    <v-app>
        <v-container class="pa-0">
            <v-carousel            
            height="260"
            >
                <v-carousel-item
                v-for="(item, i) in beforeImage"
                :key="i"
                :src="require('@/assets/'+item.pictureName)"
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
                                @click="ListBack" 
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
                        <v-card flat class="pa-3"> 
                            <v-row v-for="(item, int) in offerInfo" :key="int" align="center" class="pt-3">
                                <v-col cols="2" >
                                    <h1 style="font-size: 17px; text-align:center" >{{int+1}}등</h1>
                                </v-col>
                                <v-col cols="5" >
                                    <h1 style="font-size: 17px; text-align:center" >{{item.price|comma}}원</h1>
                                </v-col>
                                <v-col cols="5" >
                                    <h1 style="font-size: 17px; text-align:center">{{item.o_username}}님</h1>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="pa-3"> 
                            <v-row v-for="(item, int) in offerInfo" :key="int" align="center" justify="center" >
                                <v-col cols="5" v-show="item.o_username === userInfo.username">
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
                        <v-card flat class="pa-5">
                            <v-simple-table>
                                <template>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>종류</td>
                                            <td>{{proInfo.kind}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>업종</td>
                                            <td>{{proInfo.industry}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>브랜드</td>
                                            <td>{{proInfo.brand}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>연식</td>
                                            <td>{{proInfo.year}}</td>
                                        </tr>
                                    </tbody>
                                </template>
                            </v-simple-table>
                        </v-card>
                    </v-tab-item>
                </v-tabs>
                <v-bottom-navigation
                grow
                height="70"       
                fixed   
                >
                    <v-row class="ma-1 ">
                         <v-col cols="2">
                            <v-btn 
                            icon
                            class="mt-1 mr-1" 
                            @click="Like({a_num: aucInfo.a_num, l_username: userInfo.username})"
                            v-show="heart === false" 
                            >
                                <v-icon color="grey">mdi-heart</v-icon>
                            </v-btn>
                            <v-btn
                            icon 
                            class="mt-1 mr-1"
                            v-show="heart === true" 
                            @click="RemoveLike({a_num: aucInfo.a_num})"
                            >
                            <v-icon color="red">mdi-heart</v-icon>
                            </v-btn> 

                        </v-col> 
                        <v-col cols="6" class="ma-0" >
                             <input type="text" v-model="c_price" v-on="comma(c_price)"  style="font-size:17px;  text-align: left ; " class="mt-1 mx-2" placeholder="가격 입력란">
                        </v-col>

                        <v-col cols="4" >
                            <v-btn large class="primary mt-1" block>
                                <span style="font-size:15px;" class="white--text ma-2" @click="Overlay">가격제안</span>
                            </v-btn>
                            <v-overlay :value="overlay">
                                <v-card color="white" v-if="over_err === false" >
                                    <v-card-title class="black--text justify-center" style="font-size: 17px;">입력하신 금액 </v-card-title>
                                    <v-card-title class="black--text justify-center" style="font-size: 17px; text-align: center"> {{c_price}}원이 맞나요?</v-card-title>
                                    <v-card-actions>
                                        <v-btn text color="primary" x-small 
                                        @click="priceOffer({
                                        a_num: aucInfo.a_num,
                                        price: price

                                        })">
                                            <span class="primary--text ma-1">확인</span>
                                        </v-btn>
                                        <v-btn text color="primary" >
                                            <span class="primary--text ma-1" @click="Overlay">취소</span>
                                        </v-btn>
                                    </v-card-actions>

                                    
                                </v-card>
                                <v-card v-else color="white">
                                    <v-card-text class="black--text">입력금액이 시작가 혹은 최고가 보다 낮습니다.</v-card-text>
                                </v-card>
                            </v-overlay>
                        </v-col>
                    </v-row>
                </v-bottom-navigation> 
        </v-container>

    </v-app>
</template>

<script>
import {mapState, mapActions} from 'vuex'


export default {

    data(){
        return{
            c_price: '',
            price: 0,
            over_err: false
            

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

        Overlay(){
            var aucInfo = this.$store.state.aucInfo
            this.$store.state.overlay = !this.$store.state.overlay

            if(this.price > aucInfo.topprice && this.price > aucInfo.startprice){
                this.over_err = false
            }else{
                this.over_err = true
                setTimeout(()=>{
                    this.$store.state.overlay = false
                    this.over_err = false
                    this.c_price = ''
                    this.price=0
                }, 2000)
            }

        },
        priceOffer(payload){
            this.$store.dispatch('PriceOffer_bid',payload)
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
        ...mapActions(['OfferCancle', 'PriceOffer_bid', 'RemainDelete', 'Like', 'RemoveLike']),


        ListBack(){
            this.$store.state.removeBar = true
            this.$router.go(-1)
        }
    },
 
}
</script>
