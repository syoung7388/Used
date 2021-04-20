<template>
    <v-app>
        <v-container v-show="edit_show === false" class="pa-0">
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
                <p class="black--text">{{item.pictureName}}</p>

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
                                    <i class="fas fa-angle-double-left" style="font-size: large;"></i>
                                </v-btn>
                            </v-col>
                            
                            <v-col cols="2">
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
                            <v-list-item-title style="font-size: 15px" @click="SaleDeleteOK({p_num: productInfo.p_num})">삭제</v-list-item-title>
                        </v-list-item>
                    </v-list>
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
                    <v-tab class="ml-0" style="font-size: 15px;">경매 요청</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품 정보</v-tab>
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
          
        </v-container>
        <v-container v-show="edit_show === true">
            <Edit></Edit>
        </v-container>
    </v-app>
</template>

<script>
import {mapState, mapActions} from 'vuex'
import Edit from '@/components/EditComponents/Edit.vue'

export default {

    data(){
        return{

        }
    },
    computed: {
        ...mapState([ 'productInfo','userInfo', 'edit_show', 'RemoveBar'])
    },
    methods: {
        Edit(){
            localStorage.setItem("Editkind", "saleEdit")
            this.$store.state.edit_show = true
        },
        ListBack(){
            this.$store.state.list_show =true
            this.$store.state.removeBar= false
            this.$router.push({name: 'SaleList'})
        },
        ...mapActions(['SaleDeleteOK'])
    },
    components: {
        Edit
    }
    
}
</script>

