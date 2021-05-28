<template>
    <v-app>
        <v-container class="px-0">
            <v-row justify="start">
                <v-col cols="3" class="pb-0">
                    <v-btn style="font-size: large;" icon @click="Back">
                        <i class="fas fa-arrow-left" style="font-size: large;"></i>
                    </v-btn>
                </v-col>
            </v-row>
            <NullError name="채팅방이"></NullError>
            <template v-for=" (item, index) in chatList" >
                <v-list-item one-line :key="item.ch_num" @click="getChatDetail({ch_num : item.ch_num})">
                    <v-list-item-content>
                        <v-row justify="start" align="center">
                            <v-col cols="3">
                                <v-list-item-icon class="grey--text"><i class="far fa-user-circle" style="font-size:30px"></i></v-list-item-icon>
                            </v-col>
                            <v-col cols="8" v-if="userInfo.username === item.buyer" class="pa-0">
                                <v-list-item-title>{{item.seller}}님</v-list-item-title>
                            </v-col>
                            <v-col cols="8" v-else  class="pa-0">
                                <v-list-item-title>{{item.buyer}}님</v-list-item-title>
                            </v-col>
                        </v-row>
                    </v-list-item-content>
                </v-list-item>
                <v-divider
                v-if="index < chatList.length-1"
                :key="index"
                ></v-divider>
            </template>
        </v-container>
    </v-app>
</template>
<script>
import {mapState, mapActions, mapMutations} from 'vuex'
import NullError from '@/components/NullError.vue'
export default {
    beforeCreate(){
        this.$store.state.removeBar = true    
    },
    computed: {
        ...mapState(['chatList', 'userInfo'])
    },
    methods: {
        ...mapActions(['getChatDetail']),
        ...mapMutations(['Back'])

    },
    components:{
        NullError
    }
    
}
</script>