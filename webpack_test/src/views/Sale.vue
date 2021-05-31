<template>
    <v-app>
        <v-container class="pa-0 py-2">
            <v-list class="px-0 py-2">
                <v-list-item-group 
                    color="primary"
                >
                    <v-list-item @click="getSaleList({sale:0})"> 
                        <v-list-item-icon style="text-align: center">
                            <i class="fas fa-store aa--text" style="font-size: 22px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">판매 중 ({{count.salecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getSaleList({sale:1})">
                        <v-list-item-icon>
                            <i class="fas fa-dollar-sign yellow--text" style="font-size: 27px; content-align:right"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">결제 대기중 ({{count.paycount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getSaleList({sale:2})">
                        <v-list-item-icon>
                            <i class="far fa-handshake skygreen--text" style="font-size: 25px" ></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">거래 중 ({{count.tradecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getSaleList({sale:3})">
                        <v-list-item-icon>
                            <i class="far fa-check-circle primary--text" style="font-size: 25px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">판매 완료 ({{count.soldcount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
            <v-card color="secondary" height="25" id="sale" flat tile></v-card>
            <div v-if="count.soldcount !== 0" class="d-flex justify-center">
                <TotalChart :height="320"  ></TotalChart>
            </div>
          
        </v-container> 
        <router-view/>      
    </v-app>
</template>
<script>

import TotalChart from '@/components/TotalChart.vue'
import{mapActions, mapState} from 'vuex'

export default {
    beforeCreate(){
        this.$store.state.removeBar =false
    },
    data(){
        return{

       
        }
    },

    computed: {
        ...mapState({
            userInfo: 'userInfo',
            count: 'count'
        }),

    },
    methods: {
        ...mapActions(['getSaleList'])
    },
    components:{
        TotalChart     
    }


}
</script>
<style>
.sale{
    width: 100%;
}


</style>