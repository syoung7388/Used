<template>
    <v-app >
        <v-container class="px-0">

            <v-row class="pt-1">
                <v-col cols="12">
                    <v-btn 
                    style="font-size: large;" 
                    icon 
                    @click="Back"    
                    >
                        <i class="fas fa-arrow-left grey--text" style="font-size: large;"></i>
                    </v-btn>
                </v-col>
            </v-row>
            <v-list three-line>
                <v-list-item-group active-class="primary--text">
                    <template v-for="(item, int) in likeList">
                        <v-list-item 
                        :key="item.a_num" 
                        @click="getLikeDetail({a_num: item.a_num})">
                            <v-row align="center">
                                <v-col cols="3" class="my-5">
                                    <v-card
                                    width="80"
                                    >
                                        <v-img
                                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                        max-width="80"
                                         height="90" 
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                    <v-list-item-content class="ml-4">
                                        <v-list-item-title v-html="item.title" class="mb-3" style="font-weight: bold"></v-list-item-title>
                                        <v-list-item-title v-html="item.address.town" style="font-size: 12px"></v-list-item-title>
                                    </v-list-item-content>
                                </v-col>
                                <v-col cols="3" align-self="start" class="mt-8">
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day === 0">D-day</v-list-item-title >
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day < 0">D{{item.d_day}}</v-list-item-title >
                                    <v-list-item-title  style="text-align: center; font-size: 15px" class="primary--text ml-2" v-show="item.d_day > 0">경매종료</v-list-item-title >                          
                                </v-col>   

                            </v-row>
                        </v-list-item>
                        <v-divider
                        :key="int"
                        v-if="int< likeList.length"
                        ></v-divider>
                    </template>
                </v-list-item-group>
            </v-list>

        </v-container>   
    </v-app> 
</template>
<script>
import {mapActions, mapState} from 'vuex'
export default {
    data(){
        return{

        }
    },
    computed: {
        ...mapState({likeList: 'likeList'})
    },
    methods: {

        Back(){
            this.$store.state.removeBar = false
            this.$router.push({name: 'Home'})
        }, 
        ...mapActions(['getLikeDetail'])
    }
}
</script>