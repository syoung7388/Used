  
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
            <v-btn @click="getTopList">
                <span style="opacity:0.5 font-weight:500; font-size: 15px">홈</span>
                <i class="fas fa-home mb-2"  style="font-size: x-large;"></i>
            </v-btn>
            <v-btn @click="getTurnOverInfo">
                    <span style="opacity:0.5 font-weight:500; font-size: 15px">매출액</span>
                    <i class="fas fa-chart-line mb-2" style="font-size: x-large;" ></i>
            </v-btn>

            <v-btn @click="getAccountInfo" >
                <span style="opacity:0.5 font-weight:500; font-size: 15px">재무비율</span>
                <i class="fas fa-file-invoice mb-2" style="font-size: x-large;"></i>
            </v-btn>    
        </v-bottom-navigation>

    </v-app>
</template>
<script>
import { mapActions, mapState } from 'vuex'
  export default {
    data() {
        return{
            value: 1
        }
    },

    beforeCreate(){
        this.$store.dispatch('nowLatLon')
    },
    computed: {
        ...mapState(['removeBar'])
    },
    methods:{
        ...mapActions(['getAccountInfo', 'getTurnOverInfo', 'getTopList'])

    },
 

}
</script>