<template>
    <v-app>
        <v-container v-show="ShowList === true" class="pa-2"> 
            <v-list three-line>
                <h1 style="font-size:19px; text-align: center" class="mb-5">{{userInfo.name}}님의 판매내역</h1>
                <h1 style="font-size:15px;" class="primary--text mb-3">판매중</h1>
                
                <v-list-item-group
                active-class="primary--text"
                >
                    <template 
                    v-for="(item,index) in saleList"
                    >  
                        <v-list-item :key="item.p_num" @click="Product" router :to="{name:'SaleDetail'}">      
                                <v-row>
                                    <v-col cols="5">
                                        <v-img 
                                        :src="require('@/assets/'+item.pictureList[0])"
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
                    <v-list-item :key="item.p_num"> 
                    
                            <v-row>
                                <v-col cols="5">
                                    <v-img 
                                    :src="require('@/assets/'+item.pictureList[0])"
                                    max-height="90"
                                    max-width="90"
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
        <router-view/>
    </v-app>
</template>
<script>
import Vue from 'vue'
import{mapState} from 'vuex'
export default {
    data(){
        return{            
            ShowList: true
        }

    },

    computed: {
        ...mapState({
            saleList: 'saleList',
            soldList: 'soldList',
            userInfo: 'userInfo'
            })
    },
    methods: {
        Product(){
            this.ShowList= false
            alert("알지 알지")
        }
    }
 
}
</script>
<style>

</style>