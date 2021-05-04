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

            <v-row class="ma-0" justify="center" > 
                <v-expansion-panels flat>
                    <v-expansion-panel>
                        <v-expansion-panel-header class="secondary--text">게시물 상세보기</v-expansion-panel-header>
                        <v-expansion-panel-content>
                            <v-row>
                                <v-col>
                                    <h1 style="font-size: 20px">{{aucInfo.title}}</h1>
                                </v-col>
                            </v-row>
                            <v-row>
                                <v-col>
                                    {{aucInfo.content}}
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
                        <v-card v-else-if="aucInfo.sale === 2">
                            <v-row class="mt-10" justify="center">
                                <h1 style="font-size: 14px; text-align:center" class="grey--text">결제를 완료하셨습니다</h1>
                            </v-row>
                            <v-simple-table>
                                <template>
                                    <tbody>
                                        <tr class="text-center">
                                            <td>결제 금액</td>
                                            <td>{{payInfo.amount.total}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>결제 시간</td>
                                            <td>{{payInfo.Patime}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td>결제 수단</td>
                                            <td>{{payInfo.cop}}</td>
                                        </tr>
                                    </tbody>
                                </template>
                            </v-simple-table>
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
        </v-container>

    </v-app>
</template>

<script>
import {mapState, mapActions} from 'vuex'


export default {

    data(){
        return{
   

            

        }
    },
    computed: {
        ...mapState([ 'userInfo', 'aucInfo','likeInfo','proInfo', 'offerInfo','addrInfo','beforeImage', 'payInfo'])
    },
    methods: {

        Back(){
            this.$store.state.removeBar = false
            this.$router.push({name: 'BidList'})
        },
        PayBtn(){
            this.$router.push({name: 'PayMethod'})
        }
    },
 
}
</script>
