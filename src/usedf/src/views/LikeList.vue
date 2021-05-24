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
                            <v-row>
                                <v-col cols="5" class="my-5 mx-0">
                                    <v-card
                                    max-width="80"
                                    max-height="80"
                                    >
                                        <v-img
                                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                        max-width="80"
                                        max-height="80"
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                    <v-list-item-content>
                                       <v-list-item-title v-html="item.title" class="mb-3" style="font-weight: bold"></v-list-item-title>
                                        <v-list-item-title v-html="item.address.town" style="font-size: 12px"></v-list-item-title>
                                        <v-list-item-subtitle  style="text-align: right">D{{item.d_day}}</v-list-item-subtitle>
                                    </v-list-item-content>
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