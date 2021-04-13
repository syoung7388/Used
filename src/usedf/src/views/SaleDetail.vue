<template>
    <v-app>
        <v-carousel            
        height="270"
        >
            <v-carousel-item
            v-for="(item, i) in productInfo.pictureList"
            :key="i"
            :src="require('@/assets/'+item)"
            reverse-transition="fade-transition"
            transition="fade-transition"
            max-height= "300"
            ></v-carousel-item>
        </v-carousel>
        <v-container class="pa-0">
            <v-row class="ma-0">
                <v-col cols="9" class="mt-2">
                    <v-list-item-title v-html="productInfo.title" style="font-size: 20px; font-weight: bold"></v-list-item-title>
                </v-col>
                <v-col cols="3" v-show="productInfo.sale=== false" class="ma-0">   
                    <v-list-item-title style="font-size: 15px;" class="primary--text">거래중</v-list-item-title>
                    <v-list-item-subtitle v-html="productInfo.p_date" style="font-size: 12px;"></v-list-item-subtitle>
                </v-col>
                <v-col cols="3" v-show="productInfo.sale === true">   
                        <h1>거래완료</h1>
                </v-col>
            </v-row>
            <v-row class="ma-3"> 
                 <v-list-item-title v-html="productInfo.content" style="font-size: 15px"></v-list-item-title>       
            </v-row>
          <v-sheet
            class="grey"
            height="10"
            width="360"
          ></v-sheet>
            <v-row class="ma-0">
                <v-col cols="6">
                    <h1 style="font-size: 15px; text-align: center" class="primary--text mx-3 mt-3">거래요청</h1>
                </v-col>
            </v-row>


           
        
        </v-container>

        
        
    </v-app>
</template>

<script>
import {mapState, mapActions} from 'vuex'
export default {

    data(){
        return{

        }
    },
    computed: {
        ...mapState(['auctionInfo', 'productInfo','userInfo'])
    }
    
}
</script>