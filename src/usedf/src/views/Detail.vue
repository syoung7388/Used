<template>
    <v-app class="ma-0">
        <v-container class="pa-0" v-show="edit_show === false">
            <v-carousel            
            height="300"
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
                            
                            <v-col cols="2" v-if="userInfo.username === aucInfo.a_username">
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
                            <v-list-item-title style="font-size: 15px" @click="RemainDelete({a_num: aucInfo.a_num})">삭제</v-list-item-title>
                        </v-list-item>
                    </v-list>
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
            <v-divider></v-divider>
                <v-tabs
                align-with-title
                fixed-tabs
                primary
                height= "45"
        
                >
                    <v-tabs-slider></v-tabs-slider>
                    <v-tab class="ml-0" style="font-size: 15px;">제품정보</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">게시물</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">경매순위</v-tab>
                    <v-tab-item>
                        <v-card flat class="px-3 py-5">
                            <v-simple-table>
                                <template>
                                    <tbody>
                                        <tr class="text-center">
                                            <td style="font-size: 17px">종류</td>
                                            <td style="font-size: 17px">{{proInfo.kind}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 17px">업종</td>
                                            <td style="font-size: 17px">{{proInfo.industry}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 17px">브랜드</td>
                                            <td style="font-size: 17px">{{proInfo.brand}}</td>
                                        </tr>
                                        <tr class="text-center">
                                            <td style="font-size: 17px">연식</td>
                                            <td style="font-size: 17px">{{proInfo.year}}</td>
                                        </tr>
                                    </tbody>
                                </template>
                            </v-simple-table>
                        </v-card>
            
                    </v-tab-item>
                    <v-tab-item>
                         <v-card class="px-4 py-5" flat>
                            <v-simple-table>
                                <template>
                                    <tbody>
                                        <tr>
                                            <td style="font-weight: bold; font-size: 16px">{{aucInfo.title}}</td>
                                        </tr>
                                        <tr>
                                            <td  class="pt-5">{{aucInfo.content}}</td>
                                        </tr>
                                    </tbody>
                                </template>
                            </v-simple-table>
                        </v-card>          
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="pa-5" > 
                            <v-row v-for="(item, int) in offerInfo" :key="int">
                                <v-col cols="2" >
                                    <h1 style="font-size: 15px; text-align: center">{{int+1}}등</h1>
                                </v-col>
                                <v-col cols="4" >
                                    <h1 style="font-size: 15px; text-align: center" >{{item.price | comma}}원</h1>
                                </v-col>
                                <v-col cols="3">
                                    <p style="font-size: 15px;text-align: center">{{item.o_username}}님</p>
                                </v-col>
                                <v-col cols="3">
                                    <p style="font-size: 10px; text-align: center">{{item.time}}</p>
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

                    <v-row class="ma-2" v-if="aucInfo.a_username === userInfo.username">
                        <v-col cols="5">
                            <h1 style="font-size: 20px; text-align:center;" class="primary--text">최고가</h1>
                        </v-col>
                        <v-col cols="7" >
                            <h1 style="font-size: 20px; text-align:center;" v-if="offerInfo.length ===0">0원</h1>
                            <h1 v-else style="font-size: 20px; text-align:center;">{{offerInfo[0].price}}원</h1>
                        </v-col>
                    </v-row>
                    <v-row class="my-1 mr-1" v-else>
                        <v-col cols="2"   
                        >
                            <v-btn 
                            icon
                            class="mt-2 mr-1" 
                            @click="Like({a_num: aucInfo.a_num, l_username: userInfo.username})"
                            v-show="heart === false" 
                            >
                                <v-icon color="grey">mdi-heart</v-icon>
                            </v-btn>
                            <v-btn
                            icon 
                            class="mt-2 mr-1"
                            v-show="heart === true" 
                            @click="RemoveLike({a_num: aucInfo.a_num})"
                            >
                            <v-icon color="red">mdi-heart</v-icon>
                            </v-btn> 

                        </v-col> 
                        <v-col cols="6" class="ma-0" >
                            <input type="text" v-model="c_price" v-on="comma(c_price)"  style="font-size:17px;  text-align: left ; " class="mt-2 mx-2" placeholder="가격 입력란">
                        </v-col>
                  
                        <v-col cols="4" >
                            <v-btn large class="primary mt-1 mr-1" block>
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
        <div v-show="edit_show === true">
            <Edit></Edit>
        </div>

    </v-app>
</template>
<script>
import {mapActions, mapState} from 'vuex'
import Edit from '@/components/Edit.vue'
export default {
    data(){
        return {
            c_price: '',
            price: 0,
            over_err: false

           
        
        }
    },
    filters:{
        comma(price){
            var num = new Number(price)
            return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
        }

                
    },
    methods: {
        ...mapActions(['RemainDelete', 'Like', 'RemoveLike']),
        
    

        Edit(){
            this.$store.state.edit_show = true
        },
        ListBack(){
            this.$store.state.removeBar= false
            this.$store.state.I_list_show = true
            this.$router.go(-1)
        

            
        },
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
            this.$store.dispatch('PriceOffer',payload)
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
      
      



    },
    computed: { 

        ...mapState(['edit_show', 'overlay', 'userInfo', 'heart','aucInfo','likeInfo','proInfo', 'offerInfo','addrInfo','beforeImage'])
      

    },
    components: {
        Edit
    },
  
    
}
</script>