<template>
    <v-app class="pa-3">
       
            <h1 style="font-size: 20px; text-align: center">Used의 작년 한 해</h1>
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
                        style="border: solid "
                        dark
                    >
                        <v-card-title class="py-0">
                            <v-row justify="center" align="center">
                                <v-col cols="8">
                                <h1 style="font-size: 18px;">안정성</h1>
                                </v-col>
                            </v-row> 
                        </v-card-title>
                        <v-card-text class="white text--primary pt-5">
                            <v-row align="center" justify="center" >
                                <v-col cols="6">
                                    <p class="ma-0" style="text-align:center">부채</p>
                                    <p class="ma-0">상환력</p>
                                </v-col>
                                <v-col cols="6">
                                    <span style="font-weight:bold;">{{accountInfo.current_rate}}%</span>
                                </v-col>
                            </v-row>
                            <v-row  align="center" justify="center">
                                <v-col cols="6">
                                    <p class="ma-0" style="text-align:center">부채</p>
                                    <p class="ma-0"  style="text-align:center">비율</p>
                                </v-col>
                                <v-col cols="6">
                                    <span style="font-weight:bold;">{{accountInfo.debt_rate}}%</span>
                                </v-col>
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
                    style="border: solid "
                >
                    <v-card-title class="py-0"  >
                        <v-row justify="center" align="center">
                            <v-col cols="8">
                                <h1 style="font-size: 18px;">활동성</h1>
                            </v-col>
                        </v-row>
                    
                    </v-card-title>
                    <v-card-text class="white text--primary pt-5" >
                        <v-row align="center" justify="center">
                            <v-col cols="6">
                                <p class="ma-0">총자산</p>
                                <p class="ma-0">회전율</p>
                            </v-col>
                            <v-col cols="6">
                                <span style="font-weight:bold">{{accountInfo.capital_turnover}}회</span>
                            </v-col>
                        </v-row>

                        <v-row align="center" justify="center">
                            <v-col cols="7">
                                <p class="ma-0">재고자산</p>
                                <p class="ma-0">회전율</p>
                            </v-col>
                            <v-col cols="5">
                                <span style="font-weight:bold">{{accountInfo.store_turnover}}회</span>
                            </v-col>
                        </v-row>

                        <v-row align="center" justify="center">
                            <v-col cols="7">
                                <p class="ma-0">매출채권</p>
                                <p class="ma-0">회전율</p>
                            </v-col>
                            <v-col cols="5">
                                <span style="font-weight:bold"> {{accountInfo.credit_turnover}}회</span>
                            </v-col>
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
                    style="border: solid "
                >
                    <v-card-title class="py-0">
                        <v-row justify="center" align="center">
                            <v-col cols="12">
                                <h1 style="font-size: 18px; text-align:center">매출 순이익</h1>
                            </v-col>
                        </v-row>    
                    </v-card-title>
                    <v-card-text class="white text--primary pt-5 py-1">
                        <v-row align="center" justify="center">
                            <v-col cols="5">
                                <span style="font-size: 20px;font-weight:bold">{{accountInfo.sale_income_rate}}%</span>
                            </v-col>
                        </v-row>
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