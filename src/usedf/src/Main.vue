<template>
    <v-app>
        <router-view></router-view>

        <v-bottom-navigation
            v-show="removeBar === false"
            absolute
            color="primary"
            grow
            height="70"
            :value="value"
        >
            <v-btn router :to="{name: 'Home'}">
                <span style="opacity:0.5 font-weight:500;">홈</span>
                <i class="fas fa-home mb-2"  style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn router :to="{name: 'Writing'}">
            <span  style="opacity:0.5 font-weight:500;"> 글쓰기</span>
            <i class="far fa-edit mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn router :to="{name:'SaleList'}">
            <span style="opacity:0.5 font-weight:500;">판매 리스트</span>
            <i class="fas fa-file-invoice-dollar mb-2" style="font-size: x-large; opacity:0.5;" ></i>
            </v-btn>

            <v-btn router :to="{name:'BuyingList'}">
                <span style="opacity:0.5 font-weight:500;">구매 리스트</span>
                <i class="fas fa-shopping-cart mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>
        </v-bottom-navigation>

    </v-app>
</template>
<script>
import { mapState } from 'vuex'
  export default {
    data() {
        return{
            
            value: 1,

        }
    },
    computed: {
        ...mapState(['removeBar'])
    },
  }
</script>
 