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
                    <h1 style="font-size: 16px; text-align: left">D{{aucInfo.d_day}}</h1>
                </v-col>
                <v-col cols="6" class="ma-0">
                    <v-list-item-title style="font-size: 11px; text-align: right">마감기간</v-list-item-title>      
                    <v-list-item-title v-html="aucInfo.enddate" style="font-size: 11px; text-align: right"></v-list-item-title>
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
                                    <h1 style="font-size: 15px; text-align: center" >{{item.price}}원</h1>
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
                        <v-col cols="5" class="ma-0" >
                            <v-text-field outlined dense v-model="price"></v-text-field>
                        </v-col>
                        <v-col cols="1" class="pa-0 mt-4">
                            <h1 style="font-size: 20px">원</h1>
                        </v-col>
                        <v-col cols="4" >
                            <v-btn large class="primary mt-1 mr-1" block>
                                <span style="font-size:15px;" class="white--text ma-2" @click="Overlay">가격제안</span>
                            </v-btn>
                            <v-overlay :value="overlay">
                                <v-card color="white" >
                                    <v-card-title class="black--text justify-center" style="font-size: 17px;">입력하신 금액 </v-card-title>
                                    <v-card-title class="black--text justify-center" style="font-size: 17px; text-align: center"> {{price}}원이 맞나요?</v-card-title>
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
import Edit from '@/components/EditComponents/Edit.vue'
export default {
    data(){
        return {
            price: 0,
           
        
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
            if(this.$store.state.backType === "kind"){
                this.$router.push({name : 'KindList'})
            }else if(this.$store.state.backType === "industry"){
                this.$router.push({name: 'IndustryList'})
            }else if(this.$store.state.backType === "like"){
                this.$router.push({name: 'LikeList'})
            } else{
                this.$router.push({name: 'Home'})
            }

            
        },
        Overlay(){
            this.$store.state.overlay = !this.$store.state.overlay

        },
        priceOffer(payload){
            this.$store.dispatch('PriceOffer',payload)
            this.price = 0
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