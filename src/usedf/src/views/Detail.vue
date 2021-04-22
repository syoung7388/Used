<template>
    <v-app>
        <v-container class="pa-0" v-show="detail_show === true">
            <v-carousel            
            height="300"
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
                    <template v-slot:activator="{ on, attrs }">
                        <v-row class="pt-1">
                            <v-col cols="10">
                                <v-btn 
                                style="font-size: large;" 
                                icon 
                                @click="ListBack"
                               
                                >
                                    <i class="fas fa-arrow-left" style="font-size: large;"></i>
                                </v-btn>
                            </v-col>
                            
                            <v-col cols="2" v-show="userInfo.username === productInfo.username">
                                <v-btn style="font-size: large;" icon v-bind="attrs" v-on="on">
                                    <i class="fas fa-ellipsis-v"></i>
                                </v-btn>
                            </v-col> 
                           
                        </v-row>
                    </template>
                    <v-list>
                        <v-list-item  class="mx-3" dense>
                            <v-list-item-title style="font-size: 15px" @click="Edit">수정</v-list-item-title>
                        </v-list-item >
                        <v-divider></v-divider>
                        <v-list-item class="mx-3" dense > 
                            <v-list-item-title style="font-size: 15px" @click="KIDeleteOK({p_num: productInfo.p_num})">삭제</v-list-item-title>
                        </v-list-item>
                    </v-list>
                    </v-menu>
                </v-carousel-item>
            </v-carousel>
            <v-row class="ma-0">
                <v-col cols="9" class="mt-2">
                    <v-list-item-title v-html="productInfo.title" style="font-size: 20px; font-weight: bold"></v-list-item-title>
                </v-col>
                <v-col cols="3" class="ma-0">      
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
                    <v-tab class="ml-0" style="font-size: 15px;">제품 정보</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">경매 순위</v-tab>
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
                    <v-tab-item>
                        <v-card flat class="pa-5"> 
                            <v-row v-for="(item, int) in productInfo.auction" :key="int">
                                <v-col cols="2" >
                                    <h1 style="font-size: 15px;" >{{int+1}}등</h1>
                                </v-col>
                                <v-col cols="5" >
                                    <h1 style="font-size: 15px;" >{{item.price}}원</h1>
                                </v-col>
                                <v-col cols="2">
                                    <p style="font-size: 15px;">{{item.participant}}님</p>
                                </v-col>
                                <v-col cols="3">
                                    <p style="font-size: 10px;">{{item.aTime}}</p>
                                </v-col>
                            </v-row>
                        </v-card>
                    </v-tab-item>
                </v-tabs> 
                <v-bottom-navigation
                grow
                height="70"       
                fixed   
                >

                    <v-row class="ma-2" v-if="productInfo.username === userInfo.username">
                        <v-col cols="5">
                            <h1 style="font-size: 20px; text-align:center;" class="primary--text">최고가</h1>
                        </v-col>
                        <v-col cols="7" >
                            <h1 style="font-size: 20px; text-align:center;" v-if="productInfo.auction.length ===0">0원</h1>
                            <h1 v-else style="font-size: 20px; text-align:center;">{{productInfo.auction[0].price}}원</h1>
                        </v-col>
                    </v-row>
                    <v-row class="ma-1 " v-else>
                        <v-col cols="7" class="ma-0" >
                            <v-text-field outlined dense v-model="price"></v-text-field>
                        </v-col>
                        <v-col cols="1" class="pa-0 mt-4">
                            <h1 style="font-size: 20px">원</h1>
                        </v-col>
                        <v-col cols="4" >
                            <v-btn large class="primary mt-1" block>
                                <span style="font-size:15px;" class="white--text ma-2" @click="Overlay">가격제안</span>
                            </v-btn>
                            <v-overlay :value="overlay">
                                <v-card color="white" >
                                    <v-card-title class="black--text justify-center" style="font-size: 17px;">입력하신 금액 </v-card-title>
                                    <v-card-title class="black--text justify-center" style="font-size: 17px; text-align: center"> {{price}}원이 맞나요?</v-card-title>
                                    <v-card-actions>
                                        <v-btn text color="primary" x-small 
                                        @click="PriceOffer({
                                        p_num: productInfo.p_num,
                                        price: price

                                        })">
                                            <span class="primary--text ma-1">확인</span>
                                        </v-btn>
                                        <v-btn text color="primary" >
                                            <span class="primary--text ma-1" @click="Overlay">취소</span>
                                        </v-btn>
                                    </v-card-actions>

                                    
                                </v-card>
                            </v-overlay>
                        </v-col>
                    </v-row>
                </v-bottom-navigation>     
        </v-container>
        <div v-show="detail_show === false">
            <Edit></Edit>
        </div>

    </v-app>
</template>
<script>
import {mapActions, mapState} from 'vuex'
import Edit from '@/components/EditComponents/Edit.vue'
export default {
    data(){
        return {
            price: 0
        }
    },
    methods: {
        ...mapActions(['KIDeleteOK']),
    

        Edit(){
            this.$store.state.editType = "I/K"
            this.$store.state.detail_show = false
        },
        ListBack(){
            this.$store.state.removeBar= false
            this.$store.state.I_list_show = true
            if(this.$store.state.backType === "kind"){
                this.$router.push({name : 'KindList'})
            }else if(this.$store.state.backType === "industry"){
                this.$router.push({name: 'IndustryList'})
            } else{
                this.$router.push({name: 'Home'})
            }

            
        },
        Overlay(){
            this.$store.state.overlay = !this.$store.state.overlay

        },
        PriceOffer(payload){
            this.$store.dispatch('priceOffer',{
                                            p_num: payload.p_num,
                                            price: payload.price
                                            })
            this.price = 0
        }
    },
    computed: {
     

        ...mapState(['productInfo' , 'detail_show' , 'overlay', 'userInfo'])
    },
    components: {
        Edit
    },

    
}
</script>