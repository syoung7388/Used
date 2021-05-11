<template>
    <v-app>
        <v-container class="py-2 px-0">
            <v-list class="px-0 py-2">
                <v-subheader style="font-size: 16px;" >{{userInfo.username}}님의 판매내역</v-subheader>
                <v-list-item-group 
                    color="primary"
                >
                    <v-list-item @click="getBidList({sale:0})"> 
                        <v-list-item-icon style="text-align: center" dark>
                            <i class="fas fa-balance-scale skygreen--text" style="font-size: 23px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">경매 중 ({{count.salecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:1})">
                        <v-list-item-icon>
                            <i class="fas fa-wallet brown--text" style="font-size: 27px; content-align:right"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">결제 대기중({{count.paycount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:2})">
                        <v-list-item-icon>
                            <i class="far fa-handshake yellow--text" style="font-size: 25px" ></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">거래 중({{count.tradecount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                    <v-list-item @click="getBidList({sale:3})">
                        <v-list-item-icon>
                            <i class="fas fa-gavel primary--text" style="font-size: 25px"></i>
                        </v-list-item-icon>
                        <v-list-item-content>
                            <v-list-item-title style="font-size: 18px; font-weight: bold">거래 완료({{count.soldcount}})</v-list-item-title>
                        </v-list-item-content>
                    </v-list-item>
                </v-list-item-group>
            </v-list>
            <v-card color="secondary" height="25" id="sale" flat tile></v-card>
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

    beforeCreate(){
        this.$store.dispatch('getBidCount')
    },
    computed: {
        ...mapState({
            userInfo: 'userInfo',
            count : 'count'
            })
    },
    methods: {
        ...mapActions(['getBidList'])
    },


}
</script>
<style>
.sale{
    width: 100%;
}

</style>