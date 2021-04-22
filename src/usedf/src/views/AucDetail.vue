<template>
    <v-app>
        <v-container class="pa-0">
            <v-carousel            
            height="260"
            >
                <v-carousel-item
                v-for="(item, i) in productInfo.picture"
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
                <v-col cols="9" class="mt-2">
                    <v-list-item-title v-html="productInfo.title" style="font-size: 20px; font-weight: bold"></v-list-item-title>
                </v-col>
                <v-col cols="3" class="ma-0"  v-if="productInfo.sale=== 'false'" >   
                    <v-list-item-title style="font-size: 15px;" class="primary--text">거래중</v-list-item-title>
                    <v-list-item-subtitle v-html="productInfo.p_date" style="font-size: 12px;"></v-list-item-subtitle>
                </v-col>
                <v-col cols="3" v-else>   
                        <h1 style="font-size: 15px;" class="primary--text"> 거래완료</h1>
                        <v-list-item-subtitle v-html="productInfo.p_date" style="font-size: 12px;"></v-list-item-subtitle>
                </v-col>
            </v-row>
            <v-row class="ma-3"> 
                <v-list-item-title v-html="productInfo.content" style="font-size: 15px"></v-list-item-title>       
            </v-row>
            <v-divider></v-divider>
                <v-tabs
                align-with-title
                fixed-tabs
                primary
                height= "40"
        
                >
                    <v-tabs-slider></v-tabs-slider>
                    <v-tab class="ml-0" style="font-size: 15px;">경매 순위</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">내 경매</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품 정보</v-tab>

                    <v-tab-item>
                        <v-card flat class="pa-3"> 
                            <v-row v-for="(item, int) in productInfo.auction" :key="int" align="center">
                                <v-col cols="2" >
                                    <h1 style="font-size: 13px;" >{{int+1}}등</h1>
                                </v-col>
                                <v-col cols="4" >
                                    <h1 style="font-size: 13px;" >{{item.price}}원</h1>
                                </v-col>
                                <v-col cols="3" >
                                    <h1 style="font-size: 13px;">{{item.participant}}님</h1>
                                </v-col>
                                <v-col cols="3">
                                    <h1 style="font-size: 10px;" class="pt-3">{{item.aTime}}</h1>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="pa-3"> 
                            <v-row v-for="(item, int) in productInfo.auction" :key="int" align="center" justify="center">
                                <v-col cols="1" >
                                    <v-checkbox
                                    v-show="userInfo.username === item.participant"
                                    color="secondary"                          
                                    @click="Cancle"
                                    v-model="item.a_num"
                                    class="mt-5"
                                    ></v-checkbox>
                                </v-col>
                                <v-col cols="4">
                                    <h1 style="font-size: 13px; text-align:center" >{{item.price}}원</h1>
                                </v-col>
                                <v-col cols="4">
                                    <h1 style="font-size: 13px; text-align:center">{{item.participant}}님</h1>
                                </v-col>
                                <v-col cols="3">
                                    <h1 style="font-size: 10px; text-align:center">{{item.aTime}}</h1>
                                </v-col>
                            </v-row>
                            <v-btn 
                            v-show="cancle === true"
                            small 
                            block 
                            color="primary" 
                            class="mt-4"
                            style="font-size: 18px" 
                            text
                            @click="offerCancle()"
                            >철회</v-btn>
                        </v-card>
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="pa-5">
                            <v-simple-table>
                                <template>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>종류</td>
                                            <td>{{productInfo.kind}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>업종</td>
                                            <td>{{productInfo.industry}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>브랜드</td>
                                            <td>{{productInfo.brand}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>연식</td>
                                            <td>{{productInfo.year}}</td>
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
                        <v-col cols="7" class="ma-0" >
                            <v-text-field outlined dense v-model="price"></v-text-field>
                        </v-col>
                        <v-col cols="1" class="pa-0 mt-4">
                            <h1 style="font-size: 20px">원</h1>
                        </v-col>
                        <v-col cols="4" >
                            <v-btn large class="primary mt-1" block>
                                <span style="font-size:15px;" class="white--text ma-2" >가격제안</span>
                            </v-btn>
                            <!-- <v-overlay :value="overlay">
                                <v-card color="white" >
                                    <v-card-title class="black--text justify-center" style="font-size: 17px;">입력하신 금액 </v-card-title>
                                    <v-card-title class="black--text justify-center" style="font-size: 17px; text-align: center"> {{price}}원이 맞나요?</v-card-title>
                                    <v-card-actions>
                                        <v-btn text color="primary" x-small >
                                            <span class="primary--text ma-1">확인</span>
                                        </v-btn>
                                        <v-btn text color="primary" >
                                            <span class="primary--text ma-1">취소</span>
                                        </v-btn>
                                    </v-card-actions>

                                    
                                </v-card>
                            </v-overlay> -->
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

            cancle: false

        }
    },
    computed: {
        ...mapState([ 'productInfo', 'userInfo', 'price'])
    },
    methods: {

        ListBack(){

        },
        Cancle(){
            this.cancle = true

        },
        offerCancle(){
            
        }
    },
 
}
</script>
