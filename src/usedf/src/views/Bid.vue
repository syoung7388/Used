<template>
    <v-app>
        <v-container class="py-2 px-0">
            <v-list class="px-0 py-2">
                <v-list-item-group 
                    color="primary"
                >
                    <v-list-item @click="getBidList({sale:0})"> 
                        <v-list-item-icon style="text-align: center" dark>
                            <i class="fas fa-balance-scale skygreen--text" style="font-size: 23px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">경매 중 ({{bidcount.salecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:1})">
                        <v-list-item-icon>
                            <i class="fas fa-wallet brown--text" style="font-size: 27px; content-align:right"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">결제 대기중({{bidcount.paycount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:2})">
                        <v-list-item-icon>
                            <i class="far fa-handshake yellow--text" style="font-size: 25px" ></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">거래 중({{bidcount.tradecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:3})">
                        <v-list-item-icon>
                            <i class="fas fa-gavel primary--text" style="font-size: 25px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">거래 완료({{bidcount.soldcount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
            <v-card color="secondary" height="25" id="sale" flat tile class="mb-5"></v-card>
            <div v-if="bidcount.soldcount !== 0">
                <h1 style="font-size: 18px; text-align:center" class="mb-7">Used 큰 손 <span class="primary--text">{{bidrank}}위 {{userInfo.username}}님 </span></h1>
                <KindChart :height="250"></KindChart>
            </div>

        </v-container> 
        <router-view/>      
    </v-app>
</template>
<script>
import Vue from 'vue'
import{mapActions, mapState} from 'vuex'
import KindChart from '@/components/KindChart.vue'
export default {
    data(){
        return{   
          
             
           
        }
    },

    computed: {
        ...mapState({
            userInfo: 'userInfo',
            bidcount : 'bidcount',
            bidrank: 'bidrank'
            })
    },
    methods: {
        ...mapActions(['getBidList'])
    },
    components: {
        KindChart
    },
    


}
</script>
<style>
.sale{
    width: 100%;
}
.ASS{
    height: 5%;
}

</style>