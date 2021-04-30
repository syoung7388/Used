<template>
    <v-app>
        <v-container 
        class="px-0">
            <v-list three-line>
                <v-list-item-group v-model="selecteditem"  active-class="primary--text">
                    <template
                    v-for="(item, int) in topList"
                    >
                        <v-list-item
                        :key ="item.a_num"
                        @click="TopDetail(item.a_num)"
                        >
                            <v-row align="center">
                                <v-col cols="3" class="py-5">
                                    <v-card
                                    width="90"
                                    >
                                    <v-img
                                    :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                                    max-width="90"
                                    height="90" 
                                    aspect-ratio="2"
                                    ></v-img>
                                    </v-card>
                           
                                </v-col>
                                <v-col cols="9">
                                    <v-list-item-content>
                                        <v-list-item-title v-html="item.title" class="mb-3" style="font-weight: bold"></v-list-item-title>
                                        <v-list-item-title v-html="item.address.town" style="font-size: 12px"></v-list-item-title>
                                        <v-list-item-subtitle style="text-align: right" class="mr-3">D{{item.d_day}}</v-list-item-subtitle>
                                    </v-list-item-content>
                                </v-col>
                            </v-row>              
                        </v-list-item>
                        <v-divider
                        v-if="int < topList.length -1"
                        :key="int"
                        ></v-divider> 
                    </template>
                    <v-divider></v-divider>
                </v-list-item-group>            
            </v-list>
        </v-container>

    </v-app>
</template>
<script>
import{mapActions, mapState} from 'vuex'
export default {
    data(){
        return{
            selecteditem: 1,
            heart: false
        }
    },

    computed: {
        ...mapState(['topList'])
    },
    methods: {
        TopDetail(payload){
            this.$store.state.backType= "top"
            this.$store.dispatch('getDetail',{a_num: payload})
        }
    },

    
}
</script>