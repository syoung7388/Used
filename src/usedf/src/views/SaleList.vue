<template>
    <v-app>
        <v-container v-show="list_show === true" class="pa-2"> 
            <v-list three-line>
                <h1 style="font-size:19px; text-align: center" class="mb-5">{{userInfo.name}}님의 판매내역</h1>
                <h1 style="font-size:15px;" class="primary--text mb-3">판매중</h1>
                
                <v-list-item-group
                v-model="selecteditem"
                active-class="primary--text"
                >
                    <template 
                    v-for="(item,index) in saleList"
                    >  
                        <v-list-item 
                        :key="item.p_num" 
                        @click="getSaledetail({
                            p_num: item.p_num
                        })" 
                        router :to="{name:'SaleDetail'}">      
                                <v-row>
                                    <v-col cols="5">
                                        <v-img 
                                        :src="require('@/assets/'+item.picture[0].pictureName)"
                                        max-height="80"
                                        max-width="80"
                                        ></v-img>
                                    </v-col>
                                    <v-col cols="6">
                                    <v-list-item-content>
                                        <v-list-item-title v-html="item.title"></v-list-item-title>
                                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
                                    </v-list-item-content>
                                    </v-col>    
                                </v-row>
                        </v-list-item>
                    <v-divider
                        v-if="index < saleList.length - 1"
                        :key="index"
                    ></v-divider>
                    </template>
                </v-list-item-group>
                <h1 style="font-size:15px;" class="grey--text mt-8 mb-3">판매완료</h1>
                <template 
                v-for="(item, index) in soldList"
                >  
                    <v-list-item 
                    :key="item.p_num"
                    @click="getSaledetail({
                    p_num: item.p_num
                    })"
                    router :to="{name:'SaleDetail'}">       
    
                            <v-row>
                                    <v-col cols="5">
                                        <v-img 
                                        :src="require('@/assets/'+item.picture[0].pictureName)"
                                        max-height="80"
                                        max-width="80"
                                        ></v-img>
                                    </v-col>
                                    <v-col cols="6">
                                    <v-list-item-content>
                                        <v-list-item-title v-html="item.title"></v-list-item-title>
                                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
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
            <v-divider></v-divider>
        </v-container>
        <v-container v-show="list_show === false" class="pa-0">
            <router-view/>
        </v-container>
    </v-app>
</template>
<script>
import Vue from 'vue'
import{mapActions, mapState} from 'vuex'
export default {
    data(){
        return{   
            selecteditem:1        
           
        }
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
        ...mapActions(['getSaledetail'])
    }
 
}
</script>
<style>
</style>