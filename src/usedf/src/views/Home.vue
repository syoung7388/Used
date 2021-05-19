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

                    <v-btn icon @click="GetMap">
                        <i class="fas fa-map-marker-alt" style="font-size: x-large;"></i>            
                    </v-btn>


                    <v-spacer></v-spacer>

                    <v-btn icon  @click="GetLikeList">
                        <i class="far fa-heart" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn icon @click="GetChatList">
                        <i class="far fa-comment-alt" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn 
                     icon 
                     @click="GetMyPage"
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
                                <v-tab style="font-size:17px;">업종별</v-tab>
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

            <v-virtual-scroll
            height="2000"
            item-height="20"
            ></v-virtual-scroll> 
        </v-container>
        <router-view/>
    </v-app>

    
</template>
<script>

import TopList from '@/components/HomeComponents/TopList.vue'
import IndustrySort from '@/components/HomeComponents/IndustrySort.vue'
import KindSort from '@/components/HomeComponents/KindSort.vue'
import { mapActions, mapMutations, mapState } from 'vuex'





export default{
    data(){
        return{
            check: 0

        }
    },
    methods: {

        GetMyPage(){
            this.$store.state.removeBar = true
            if(this.Roles.length === 0){
                this.$router.push({name: 'Auth'})
            }else{
                this.$router.push({name: 'MyPage'})
            }
        },
        GetLikeList(){
            this.$store.state.removeBar = true
            if(this.Roles.length === 0){
                this.$router.push({name: 'Auth'})
            }else{
               this.$store.dispatch('getLikeList')
            }
                
          
        },
        GetChatList(){
            if(this.Roles.length === 0){
                this.$store.state.removeBar=true
                this.$router.push({name: 'Auth'})
            }else{
               this.$store.dispatch('getChatList')
            }
        },

        ...mapMutations(['GetMap']),


    },
    computed:{
        ...mapState(['removeBar', 'Roles'])
    },

    components: {
        TopList,
        IndustrySort,
        KindSort
    },

    mounted(){
        console.log(this.$store.state.Role)
    }


}
</script>
