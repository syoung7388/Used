<template>
    <v-app>
        <v-container class="pa-0">
            <v-card>
                <v-app-bar
                    color="white"
                    flat
                    absolute
                >

                    <v-btn icon>
                        <i class="fas fa-map-marker-alt" style="font-size: x-large;"></i>            
                    </v-btn>
                    <span style= "font-size:15px" black--text>대구 신천동</span>

                    <v-spacer></v-spacer>

                    <v-btn icon>
                        <i class="far fa-heart" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn icon>
                        <i class="far fa-bell" style="font-size: x-large;"></i>            
                    </v-btn>
                    <v-btn icon router :to="{name:'MyPage'}" @click="RemoveBar"> 
                        <i class="far fa-user" style="font-size: x-large;"></i>            
                    </v-btn>
                    <template v-slot:extension>
                        <v-tabs
                            align-with-title
                            fixed-tabs
                        >
                            
                            <v-tabs-slider primary></v-tabs-slider>
                                <v-tab class="ml-0" style="font-size:17px;">인기매물</v-tab>
                                <v-tab style="font-size:17px;">카테고리</v-tab>
                                                
                        </v-tabs>
                    </template>
                </v-app-bar>
            </v-card>
        </v-container>
        <router-view/>
    </v-app>

    
</template>
<script>
import { mapActions} from 'vuex'

export default{
    data(){
        return{

        }
    },
    methods: {
        ...mapActions(['RemoveBar'])
    }
}
</script>
