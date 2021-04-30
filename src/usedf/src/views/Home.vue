<template>
    <v-app>
        <v-container class="pa-0">
            <v-card>
                <v-app-bar
                    color="white"
                    flat
                    absolute
                    height="70"
                >

                    <v-btn icon @click="getMap">
                        <i class="fas fa-map-marker-alt" style="font-size: x-large;"></i>            
                    </v-btn>
                    <span style= "font-size:17px" black--text>대구 신천동</span>

                    <v-spacer></v-spacer>

                    <v-btn icon  @click="getLikeList">
                        <i class="far fa-heart" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn icon>
                        <i class="far fa-bell" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn 
                     icon 
                     @click="RemoveBar" 
                     
                   > 
                        <i class="far fa-user" style="font-size: x-large;"></i>            
                    </v-btn>
                    <template v-slot:extension>
                        <v-tabs
                            align-with-title
                            fixed-tabs
                            height="50"
                        >
                            
                            <v-tabs-slider primary></v-tabs-slider>
                                <v-tab class="ml-0" style="font-size:17px;">인기매물</v-tab>
                                <v-tab style="font-size:17px;" @click="sort">업종별</v-tab>
                                <v-tab style="font-size:17px;">제품별</v-tab>
                                <v-tab-item>
                                    <TopList></TopList>
                                </v-tab-item>
                                <v-tab-item>
                                    <IndustrySort></IndustrySort>
                                </v-tab-item>
                                <v-tab-item>
                                    <KindSort></KindSort>
                                </v-tab-item>
                        </v-tabs>
                    </template>
                </v-app-bar>
            </v-card>
        </v-container>
        <router-view/>
    </v-app>

    
</template>
<script>

import TopList from '@/components/HomeComponents/TopList.vue'
import IndustrySort from '@/components/HomeComponents/IndustrySort.vue'
import KindSort from '@/components/HomeComponents/KindSort.vue'
import { mapActions, mapState } from 'vuex'




export default{
    data(){
        return{
            latitude: 0,
            longitude: 0

        

        }
    },
    methods: {
        RemoveBar(){
            this.$store.state.removeBar= true
            this.$router.push({name: 'MyPage'})
        },
        getMap(){
            this.$store.state.removeBar= true
            this.$router.push({name: 'Map'})
            
        },
        sort(){
            this.$store.state.I_list_show= false
        },
        ...mapActions(['getLikeList'])

    },
    components: {
        TopList,
        IndustrySort,
        KindSort
    },


}
</script>
