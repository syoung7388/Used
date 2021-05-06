<template>
    <v-app>
        <v-container class="ma-0 pa-0 " id="salecontainer"> 
            <v-list three-line>
                <h1 style="font-size:19px; text-align: center" class="mb-5">{{userInfo.name}}님의 판매내역</h1>
                <h1 style="font-size:16px;" class="primary--text ml-5 mb-3">판매중</h1>
                
                <v-list-item-group
                active-class="primary--text"
                >
                    <template 
                    v-for="(item,index) in saleList"
                    >  
                        <v-list-item 
                        :key="item.p_num" 
                        @click="getSaleDetail({
                         a_num: item.a_num
                        })" 
                        router :to="{name:'SaleDetail'}">      
                                <v-row align="center"> 
                                    <v-col cols="4"  class="my-3">
                                        <v-card
                                        width="90"
                                        >
                                            <v-img 
                                            :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                            max-width="90"
                                            height="90" 
                                            ></v-img>
                                        </v-card>
                                    </v-col>
                                    <v-col cols="8" >
                                    <v-list-item-content>
                                        <v-list-item-title v-html="item.title" class="mb-5"></v-list-item-title>
                                        <v-list-item-title class="mb-5"> {{item.toprice | comma}}원 </v-list-item-title>
                                        <v-list-item-subtitle>D-{{item.d_day}}</v-list-item-subtitle>
                                    </v-list-item-content>
                                    </v-col>    
                                </v-row>
                        </v-list-item>
                    <v-divider
                        v-if="index < saleList.length - 1"
                        :key="index"
                    ></v-divider>
                    </template>
                    <v-row justify="center">
                        <v-col cols="3">
                            <v-btn text @click="addList({sale: 0})"><span style="font-weight: bold">더 보기</span></v-btn>
                        </v-col>
                    </v-row>
                </v-list-item-group>
                <v-card flat height="20" color="secondary" id="salecard"></v-card>
                <h1 style="font-size:16px;"  class="primary--text ml-5 mt-5">판매완료</h1>
                <template 
                v-for="(item, index) in soldList"
                >  
                    <v-list-item 
                    :key="item.p_num"
                    @click="getSaleDetail({
                    a_num: item.a_num
                    })"
                    router :to="{name:'SaleDetail'}"
                    
                    >       
    
                        <v-row align="center">
                                <v-col cols="5"  class="py-5">
                                    <v-card
                                    width="90"
                                    >
                                        <v-img 
                                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                        max-width="90"
                                        height="90" 
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                <v-list-item-content>
                                    <v-list-item-title v-html="item.title"></v-list-item-title>
                                </v-list-item-content>
                                </v-col>    
                            </v-row>
                    </v-list-item>
                    <v-divider
                        v-if="index < soldList.length- 1"
                        :key="index"
                    ></v-divider>
                </template>
            </v-list>
                <v-row justify="center">
                    <v-col cols="3">
                        <v-btn text><span style="font-weight: bold">더 보기</span></v-btn>
                    </v-col>
                </v-row>
        </v-container>
        <router-view/>      
    </v-app>
</template>
<script>
import Vue from 'vue'
import{mapActions, mapState} from 'vuex'
export default {
    data(){
        return{   
          
             
           
        }
    },
    filters:{
      comma(price){
        var num = new Number(price)
        return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
      }
    },
    beforeCreate(){
        this.$store.dispatch('getSaleList')
    },
    computed: {
        ...mapState({
            saleList: 'saleList',
            soldList: 'soldList',
            userInfo: 'userInfo',
            list_show: 'list_show',
            })
    },
    methods: {
        ...mapActions(['getSaleDetail'])
    },


}
</script>
<style>
.salecard{
    width: 100%;
}
.salecontainer{
    width: 100%;
}
</style>