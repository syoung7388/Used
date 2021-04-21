<template>
    <v-app>
        <router-view></router-view>

        <v-bottom-navigation
            v-show="removeBar === false"
            color="primary"
            grow
            height="75"
            :value="value"
            fixed
        >
            <v-btn router :to="{name: 'Home'}">
                <span style="opacity:0.5 font-weight:500; font-size: 15px">홈</span>
                <i class="fas fa-home mb-2"  style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn router :to="{name: 'Writing'}">
            <span  style="opacity:0.5 font-weight:500; font-size: 15px"> 글쓰기</span>
            <i class="far fa-edit mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn router :to="{name:'SaleList'}" @click="getSaleList">
            <span style="opacity:0.5 font-weight:500; font-size: 15px">판매 리스트</span>
            <i class="fas fa-file-invoice-dollar mb-2" style="font-size: x-large; opacity:0.5;" ></i>
            </v-btn>

            <v-btn router :to="{name:'BuyingList'}">
                <span style="opacity:0.5 font-weight:500; font-size: 15px">내경매</span>
                <i class="fas fa-shopping-cart mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>
        </v-bottom-navigation>

    </v-app>
</template>
<script>
import { mapActions, mapState } from 'vuex'
  export default {
    data() {
        return{
            
            value: 1,

        }
    },
    computed: {
        ...mapState(['removeBar'])
    },
    methods: {

        ...mapActions(['getSaleList'])
    }
  }
</script>
 