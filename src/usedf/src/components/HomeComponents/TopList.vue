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
                        :key ="item.p_num"
                        >
                            <v-row>
                                <v-col cols="5" class="pa-5">
                                    <v-card
                                    max-width="90"
                                    max-height="90"          
                                    >
                                        <v-img
                                        :src="require('@/assets/'+item.picture[0].pictureName)"
                                        max-height="90"
                                        max-width="90"
                                        ></v-img>
                                    </v-card>
                                </v-col>
                                <v-col cols="6">
                                    <v-list-item-content>
                                        <v-list-item-title v-html="item.title"></v-list-item-title>
                                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
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
import{mapState} from 'vuex'
export default {
    data(){
        return{
            selecteditem: 1
        }
    },

    computed: {
        ...mapState(['topList'])
    }
    
}
</script>