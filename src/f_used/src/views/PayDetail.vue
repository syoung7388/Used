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
            <v-divider></v-divider>
                <v-tabs
                align-with-title
                fixed-tabs
                primary
                height= "43"
        
                >
                    <v-tabs-slider></v-tabs-slider>
                   
                    <v-tab class="ml-0" style="font-size: 15px;">결제</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품 정보</v-tab>
                    <v-tab-item>


                        <v-card flat class="pa-10" v-if="aucInfo.sale === 1"> 
                            <v-row class="mt-10" justify="center">
                                <h1 style="font-size: 14px; text-align:center" class="grey--text">결제를 원하시면 아래의 버튼을 눌러주세요</h1>
                            </v-row>
                            <v-row  align="center" justify="center" class="mt-5">
                                <v-col cols="6">
                                    <h1 style="font-size: 20px; text-align:center" >결제 금액 : </h1>
                                </v-col>
                                <v-col cols="6"> 
                                    <h1 style="font-size: 20px; text-align:center" >{{offerInfo[0].price}}원</h1>
                                </v-col>
                            </v-row>
                            <v-row justify="center" class="mt-10">
                                <v-btn large dense class="primary" @click="PayBtn">결제하기</v-btn>
                            </v-row>
                        </v-card>
                        <v-card v-else-if="aucInfo.sale === 2 || aucInfo.sale === 3" flat class="px-10 py-7">
                            <v-row>
                                <v-col>
                                    <h1 style="font-size: 17px; text-align:center" class="ml-3 mb-2">결제정보 <span class="grey--text">(결제완료)</span></h1>
                                    <v-divider></v-divider>
                                </v-col>
                            </v-row>
                            <v-row >
                                <v-col cols="6" >
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">결제 총액</h1>
                                </v-col>
                                <v-col cols="6">
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">{{payInfo.amount.total}}원</h1>
                                </v-col>
                            </v-row>
                            <v-row class="px-16">
                                <v-col cols="12" class="pa-0">
                                    <p style="font-size: 15px; text-align:left">&nbsp;ㄴ  할인 금액: {{payInfo.amount.discount}}원</p>
                                </v-col>
                                <v-col cols="12" class="pa-0">
                                    <p style="font-size: 15px; text-align:left">ㄴ  포인트사용액: {{payInfo.amount.point}}원</p>
                                </v-col>
                            </v-row>
                            <v-row >
                                <v-col cols="6" >
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">결제 수단</h1>
                                </v-col>
                                <v-col cols="6">
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">{{payInfo.cop}}</h1>
                                </v-col>
                            </v-row>
                            <v-row >
                                <v-col cols="6" >
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">결제 방법</h1>
                                </v-col>
                                <v-col cols="6">
                                    <h1 style="font-size: 15px; text-align:center" class="ml-3">{{payInfo.method}}</h1>
                                </v-col>
                            </v-row>
                            <v-row justify="center" class="mt-5" v-show="chatInfo === null">
                                <v-col cols="8">
                                    <v-btn larges class="primary" @click="Room({
                                        seller: aucInfo.a_username
                                    })">판매자님과 대화 연결하기</v-btn>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item class="my-5">
                        <v-row justify="start" class="mx-2">
                            <v-col cols="10">
                                <h1 style="font-size: 20px">{{aucInfo.title}}</h1>
                            </v-col>
                        </v-row>
                        <v-row justify="start"  class="mx-2">
                            <v-col cols="10">
                                {{aucInfo.content}}
                            </v-col>
                        </v-row>
                        <v-card color="secondary" height="25" id="sale" flat tile class="my-4"></v-card>
                        <v-card flat>
                            <v-simple-table >
                                <template>
                                    <tbody>
                                        <tr class="text-center" >
                                            <td style="font-size: 18px" >종류</td>
                                            <td style="font-size: 18px">{{proInfo.kind}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 18px">업종</td>
                                            <td style="font-size: 18px">{{proInfo.industry}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 18px">브랜드</td>
                                            <td style="font-size: 18px">{{proInfo.brand}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 18px">연식</td>
                                            <td style="font-size: 18px">{{proInfo.year}}</td>
                                        </tr>
                                    </tbody>
                                </template>
                            </v-simple-table>
                        </v-card>
               
                    </v-tab-item>
                </v-tabs>
        </v-container>

    </v-app>
</template>

<script>
import {mapState, mapActions} from 'vuex'

import {checkImg} from '@/mixins/checkImg.js'

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
        ...mapState([ 'userInfo', 'aucInfo','likeInfo','proInfo', 'offerInfo','addrInfo','beforeImage', 'payInfo', 'chatInfo'])
    },
    methods: {

        ListBack(){
            this.$store.dispatch('getOfferList',{sale: this.aucInfo.sale})
        },
        PayBtn(){
            this.$router.push({name: 'PayMethod'})
        },
        ...mapActions(['Room'])

    },

    created (){
        this.$socket.on('roomOK', (data)=>{
            console.log(data.room_msg)
        })
    }
 
}
</script>
<style>

</style>
