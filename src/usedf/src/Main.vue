  
<template>
    <v-app class="pa-0">
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
                <i class="fas fa-home mb-2"  style="font-size: x-large;"></i>
            </v-btn>

            <v-btn router :to="{name: 'Writing'}">
            <span  style="opacity:0.5 font-weight:500; font-size: 15px"> 글쓰기</span>
            <i class="far fa-edit mb-2" style="font-size: x-large;"></i>
            </v-btn>

            <v-btn @click="Sale">
            <span style="opacity:0.5 font-weight:500; font-size: 15px">판매 리스트</span>
            <i class="fas fa-file-invoice-dollar mb-2" style="font-size: x-large;" ></i>
            </v-btn>

            <v-btn @click="Bid">
                <span style="opacity:0.5 font-weight:500; font-size: 15px">내경매</span>
                <i class="fas fa-hand-holding-usd mb-2" style="font-size: x-large;"></i>
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
    beforeCreate(){
        this.$store.dispatch('nowLatLon')
    },
    computed: {
        ...mapState(['removeBar', 'Role'])
    },
    methods:{
        Sale(){
            
            if(this.Role.length !== 0){
                this.$store.dispatch('getSaleStatistic')
            }else{
                this.$store.state.removeBar = true
                this.$router.push({name:'Auth'})
            }

        },
        Bid(){
            if(this.Role.length !== 0){
               this.$store.dispatch('getBidStatistic')
            }else{
                this.$store.state.removeBar = true
                this.$router.push({name:'Auth'})
            }

        }

    }
}
</script>