<template>
    <v-app>
        <v-container class="px-0">
            <v-list three-line>
                <v-list-item-group active-class="primary--text">
                    <template v-for="(item, int) in industryList">
                        <v-list-item 
                        :key="item.p_num" 
                        @click="getDetail({
                            p_num: item.p_num
                        })">
                            <v-row>
                                <v-col cols="5" class="my-5 mx-0">
                                    <v-card
                                    max-width="90"
                                    max-height="90"
                                    >
                                        <v-img
                                        :src="require('@/assets/'+item.picture[0].pictureName)"
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
                        :key="int"
                        v-if="int< industryList.length"
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
        ...mapState(['industryList'])
    },
    methods: {
        ...mapActions(['getDetail'])
    }
}
</script>