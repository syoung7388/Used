<template>
    <v-app>
        <v-container class="px-0">
            <v-list three-line>
                <h1 style="font-size:19px; text-align: center">{{userInfo.name}}님의 경매리스트</h1>
                <h1 style="font-size:15px;" class="primary--text ma-5">진행중</h1>
                <v-list-item-group
                active-class="primary--text"
                >
                    <template v-for="(item, index) in bidingList">
                        <v-list-item :key="item.picture.pi_num"   @click="getAucDetail({p_num: item.p_num})">
                            <v-row>
                                <v-col cols="4">
                                    <v-img
                                    :src="require('@/assets/'+item.picture[0].pictureName)"
                                    height="90"
                                    width="80"
                                    ></v-img>
                                </v-col>
                                <v-col cols="3" class="pr-0" >
                                     <v-list-item-content>
                                        <v-list-item-subtitle>남은 기간</v-list-item-subtitle>
                                        <v-list-item-title class="pt-2">최고가</v-list-item-title>
                                        <v-list-item-title class="pt-2">My가격</v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                                <v-col cols="4" class="pl-0">
                                    <v-list-item-content>
                                        <v-list-item-subtitle >D{{item.d_day}}</v-list-item-subtitle>
                                        <v-list-item-title class="pt-2">{{item.topprice}}원</v-list-item-title>
                                        <v-list-item-title class="pt-2">{{item.auction[0].price}}원</v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                            </v-row>
                        </v-list-item>
                        <v-divider  
                        v-if="index < bidingList.length"
                        :key="index"
                        class="my-2"
                        ></v-divider>
                    </template>
                </v-list-item-group>
                    <h1 style="font-size:15px;" class="primary--text ma-5">결제 대기중</h1>
                <v-list-item-group
                active-class="primary--text"
                >
                    <template v-for="(item, index) in payList">
                        <v-list-item :key="item.picture.pi_num"   @click="getPayDetail({p_num: item.p_num})">
                            <v-row>
                                <v-col cols="4">
                                    <v-img
                                    :src="require('@/assets/'+item.picture[0].pictureName)"
                                    height="90"
                                    width="80"
                                    ></v-img>
                                </v-col>
                                <v-col cols="6"  >
                                    <v-list-item-content>
                                        <v-list-item-subtitle >D-day</v-list-item-subtitle>
                                        <v-list-item-title class="pt-2">{{item.auction[0].price}}원</v-list-item-title>
                                    </v-list-item-content>
                     
                                </v-col>
                                <v-col cols="2" >
                                    <v-list-item-icon style="font-size: 30px" class="green--text"><i class="fas fa-award"></i></v-list-item-icon>
                                </v-col>
                            </v-row>
                        </v-list-item>
                        <v-divider  
                        v-if="index < payList.length"
                        :key="index"
                        class="my-2"
                        ></v-divider>
                    </template>
                </v-list-item-group>
                <h1 style="font-size:15px;" class="primary--text ma-5">거래완료</h1>
                <v-list-item-group
                active-class="primary--text"
                >
                    <template v-for="(item, i) in bidList">
                        <v-list-item :key="item.picture.pi_num"  @click="getAucDetail({p_num: item.p_num})">
                            <v-row>
                                <v-col cols="4">
                                    <v-img
                                    :src="require('@/assets/'+item.picture[0].pictureName)"
                                    height="90"
                                    width="80"
                                    ></v-img>
                                </v-col>
                                <v-col cols="3" class="pr-0" >
                                     <v-list-item-content>
                                        <v-list-item-subtitle>남은 기간</v-list-item-subtitle>
                                        <v-list-item-title class="pt-2">최고가</v-list-item-title>
                                        <v-list-item-title class="pt-2">My가격</v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                                <v-col cols="4" class="pl-0">
                                    <v-list-item-content>
                                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
                                        <v-list-item-title class="pt-2">{{item.topprice}}원</v-list-item-title>
                                        <v-list-item-title class="pt-2">{{item.auction[0].price}}원</v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                            </v-row>
                        </v-list-item>
                        <v-divider  
                        v-if="i < bidList.length"
                        :key="i"
                        ></v-divider>
                    </template>
                </v-list-item-group>
                
            </v-list>
        </v-container>
    </v-app>

    
</template>
<script>
import {mapState, mapActions} from 'vuex'
export default {
    beforeCreate(){
        this.$store.dispatch('getAuctionList')
    
    


    },
    computed: {
        ...mapState( {bidingList: 'bidingList', bidList:'bidList', userInfo: 'userInfo', payList: 'payList'})
    },
    methods: {
        ...mapActions(['getAucDetail', 'getPayDetail']),
        
    },

}
</script>