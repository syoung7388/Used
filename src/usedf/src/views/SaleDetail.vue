<template>
    <v-app>
        <v-container v-show="edit_show === false" class="pa-0">
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
                            <v-list-item-title style="font-size: 15px" @click="SaleDelete({a_num: aucInfo.a_num})">삭제</v-list-item-title>
                        </v-list-item>
                    </v-list>
                    </v-menu>
                </v-carousel-item>
              
            </v-carousel>
            <v-row class="ma-0">
                <v-col cols="12" class="ma-0"  v-if="aucInfo.sale=== 'false'" >   
                    <v-list-item-title style="font-size: 15px; text-align:right" class="primary--text">거래중</v-list-item-title>
                    <v-list-item-subtitle v-html="aucInfo.enddate" style="font-size: 12px; text-align:right"></v-list-item-subtitle>
                </v-col>
                <v-col cols="12" v-else>   
                    <h1 style="font-size: 15px; text-align:right" class="primary--text"> 거래완료</h1>
                    <v-list-item-subtitle v-html="aucInfo.enddate" style="font-size: 12px; text-align:right"></v-list-item-subtitle>
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
                    <v-tab class="ml-0" style="font-size: 15px;">경매순위</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">게시물</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품정보</v-tab>

                    <v-tab-item>
                        <v-card class="pa-10" flat v-if="offerInfo.length === 0">
                            <v-row>
                                <v-col>
                                    <h1 style="font-size: 15px; text-align: center" class="grey--text">현재 요청 대기중입니다.</h1>
                                </v-col>
                            </v-row>
                        </v-card>
                        <v-card flat class="pa-5" v-else> 
                            <v-row v-for="(item, int) in offerInfo" :key="int">
                                <v-col cols="2" >
                                    <h1 style="font-size: 15px;" >{{int+1}}등</h1>
                                </v-col>
                                <v-col cols="5" >
                                    <h1 style="font-size: 15px;" >{{item.price}}원</h1>
                                </v-col>
                                <v-col cols="2">
                                    <p style="font-size: 15px;">{{item.o_username}}님</p>
                                </v-col>
                                <v-col cols="3">
                                    <p style="font-size: 10px;">{{item.time}}</p>
                                </v-col>
                            </v-row>
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
                        <v-card flat class="px-5 py-5" >
                            <v-simple-table>
                                <template  >
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
        ...mapState([ 'aucInfo','likeInfo', 'proInfo', 'offerInfo', 'addrInfo' ,'userInfo', 'edit_show', 'RemoveBar', 'beforeImage'])
    },
    methods: {
        Edit(){
            this.$store.state.edit_show = true
        },
        ListBack(){
            this.$store.state.list_show =true
            this.$store.state.removeBar= false
            this.$router.push({name: 'SaleList'})
        },
        ...mapActions(['SaleDelete'])
    },
    components: {
        Edit
    }
    
}
</script>

