<template>
    <v-app>
        <v-overlay :value="offer_overlay">
            <v-card color="white" v-if="over_err === false">
                <v-card-title class="black--text justify-left" style="font-size: 17px;">입력하신 금액 </v-card-title>
                <v-card-title class="black--text justify-left" style="font-size: 17px; text-align: center"> {{c_pr}}원이 맞나요?</v-card-title>
                <v-card-actions>
                    <v-btn text color="primary" x-small 
                    @click="priceOffer" >
                        <span class="primary--text " style="font-size:12px">확인</span>
                    </v-btn>
                    <v-btn text color="primary" >
                        <span class="primary--text " @click="Cancle" style="font-size:12px">취소</span>
                    </v-btn>
                </v-card-actions>
        
        
            </v-card>
            <v-card v-else color="white">
                <v-card-text class="black--text">입력금액이 시작가 혹은 최고가 보다 낮습니다.</v-card-text>
            </v-card>
        </v-overlay>
    </v-app>
</template>
<script>
import { mapState } from 'vuex'
export default {
    // props:['c_price', 'price'],
    data(){
        return{
            over_err: false,
            offer_overlay: false,
            c_pr: null,
            pr: null

        }
    },
    methods: {
        Overlay(payload){
            this.c_pr = payload.c_price
            this.pr = payload.price         
            this.offer_overlay = true
            //console.log(payload.price)
            if(payload.price > this.aucInfo.topprice && payload.price > this.aucInfo.startprice){
                this.over_err = false
            }else{
                this.over_err = true
                setTimeout(()=>{
                    this.offer_overlay = false
                    this.over_err = false
                    this.$emit('Origin')
                }, 1000)
            }
        },
        priceOffer(){
            this.$store.dispatch('PriceOffer',{a_num: this.aucInfo.a_num, price: this.pr})
            this.offer_overlay = false
            this.$emit('Origin')
        },
        Cancle(){
            this.offer_overlay = false
            this.$emit('Origin')
        }
    },
    computed:{
        ...mapState(['aucInfo'])
    }
    
}
</script>