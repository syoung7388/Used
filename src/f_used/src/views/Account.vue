<template>
    <v-app class="pa-3">
        <v-timeline
            align-top
        >
            <v-timeline-item
            color="red lighten-2"
            icon="mdi-star"
            fill-dot
            >
            <v-card
                color="red lighten-2"
                dark
            >
                <v-card-title class="title"  style="text-align:center">
                    <p style="font-size: 18px;">안정성</p>
                </v-card-title>
                <v-card-text class="white text--primary pt-5"  style="text-align:center">
                    <v-row>
                        <p style="font-size:15px">부채 상환능력</p>                
                        <span style="font-weight:bold">{{accountInfo.current_rate}}%</span>
                    </v-row>
                    <v-row>
                        <p style="font-size:15px">부채 비율</p>
                        <span style="font-weight:bold"> {{accountInfo.debt_rate}}%</span>
                    </v-row>
                </v-card-text>
            </v-card>
            </v-timeline-item>
            <v-timeline-item
            color="purple darken-1"
            icon="mdi-book-variant"
            fill-dot
            >
            <v-card
                color="purple darken-1"
                dark
            >
                <v-card-title class="title"  style="text-align:center">
                    <p style="font-size: 18px;">활동성</p>
                </v-card-title>
                <v-card-text class="white text--primary pt-5"  style="text-align:center">
                    <v-row>
                        <p style="font-size:15px">총자산 회전율</p>                
                        <span style="font-weight:bold">{{accountInfo.capital_turnover}}회</span>
                    </v-row>
                    <v-row>
                        <p style="font-size:15px">재고자산 회전율</p>
                        <span style="font-weight:bold"> {{accountInfo.store_turnover}}회</span>
                    </v-row>
                    <v-row>
                        <p style="font-size:15px">매출채권 회전율</p>
                        <span style="font-weight:bold"> {{accountInfo.credit_turnover}}회</span>
                    </v-row>
                </v-card-text>
            </v-card>
            </v-timeline-item>
                <v-timeline-item
                color="indigo"
                icon="mdi-buffer"
                fill-dot
                >
            <v-card
                color="indigo"
                dark
            >
                <v-card-title class="title"  style="text-align:center">
                    <p style="font-size: 18px;">매출 순이익</p>
                </v-card-title>
                <v-card-text class="white text--primary pt-5" style="text-align:center">                
                    <span style="font-size: 30px;font-weight:bold">{{accountInfo.sale_income_rate}}%</span>
                </v-card-text>
            </v-card>
            </v-timeline-item>
        </v-timeline>
    </v-app>
</template>
<script>
import { mapState } from 'vuex'

export default {
    beforeCreate(){
        this.$store.state.removeBar = false    
    },
    data(){
        return{
        items: [
            {
            color: 'red lighten-2',
            icon: 'mdi-star',
            },
            {
            color: 'purple darken-1',
            icon: 'mdi-book-variant',
            },
            {
            color: 'green lighten-1',
            icon: 'mdi-airballoon',
            },
            {
            color: 'indigo',
            icon: 'mdi-buffer',
            },
      ],
        }
    },
    computed:{
        ...mapState(['accountInfo'])
    }
    
}
</script>