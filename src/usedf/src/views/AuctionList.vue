<template>
    <v-app>
        <v-container>
            <v-list three-line>
                <h1 style="font-size:19px; text-align: center">{{userInfo.name}}님의 경매리스트</h1>
                <h1 style="font-size:15px;" class="primary--text mb-3">진행중</h1>
                <v-list-item-group
                active-class="primary--text"
                >
                    <template v-for="(item, index) in bidingList">
                        <v-list-item :key="index">
                            <v-row>
                                <v-col cols="5">
                                    <v-img
                                    :src="require('@/assets/'+item.picture[0].pictureName)"
                                    max-height="80"
                                    max-width="80"
                                    ></v-img>
                                </v-col>
                                <v-col cols="6">
                                    <v-list-item-content>
                                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
                                        <v-list-item-title>최고가:{{item.topprice}}원</v-list-item-title>
                                        <v-list-item-title>My가격: {{item.auction[0].price}}원</v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                            </v-row>


                        </v-list-item>
                    </template>
                </v-list-item-group>
                
            </v-list>
        </v-container>
    </v-app>

    
</template>
<script>
import {mapState, mapAction} from 'vuex'
export default {
    beforeCreate(){
        this.$store.dispatch('getAuctionList')
    },
    computed: {
        ...mapState(['bidingList', 'bidList', 'userInfo'])
    }
}
</script>