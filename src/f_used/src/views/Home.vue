<template>
    <v-app>
        <v-container class="pa-0" v-show="map_show === false">
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
        <v-container v-show="map_show === true" class="pa-0">
            <MapComponent ref="getmap" @mapOK="MapOK"></MapComponent>
        </v-container>
        <router-view/>
    </v-app>

    
</template>
<script>

import TopList from '@/components/HomeComponents/TopList.vue'
import IndustrySort from '@/components/HomeComponents/IndustrySort.vue'
import KindSort from '@/components/HomeComponents/KindSort.vue'
import MapComponent from '@/components/MapComponent'
import { mapActions, mapMutations, mapState } from 'vuex'
export default{
    beforeCreate(){
        this.$store.state.removeBar = false    
    },

    created(){
        const script =document.createElement('script')
        script.src = 'https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=bonob9bu31&submodules=geocoder'
        script.type = "text/javascript"
        document.head.appendChild(script)
    },
    data(){
        return{
            check: 0, 
            map_show: false

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
        GetMap(){
            this.$store.state.removeBar = true
            this.map_show = true
            this.$refs.getmap.initmap()
           
        },
        MapOK(){
            console.log(this.$route.name)
            this.$store.dispatch('getTopList')
            .then(()=>{
                this.map_show = false
            })
        }
        // ...mapMutations(['GetMap'])

    },
    computed:{
        ...mapState(['removeBar', 'Roles'])
    },


    components: {
        TopList,
        IndustrySort,
        KindSort,
        MapComponent
    },

    mounted(){
        // console.log(this.$store.state.Role)

    }


}
</script>
