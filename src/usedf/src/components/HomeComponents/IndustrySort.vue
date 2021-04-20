<template>
    <v-app>
        <v-container v-show="I_list_show === false">
            <v-row>
                <v-col>
                    
                </v-col>
            </v-row>
            <v-row 
            v-for="(c, index) in cut"
            :key="index"
            >              
                <v-col
                cols="4"
                v-for="(list, i) in industries.slice(c, c+3)"
                :key="i"
                class="pa-0"             
                > 
                <v-card 
                flat 
                class="mt-2"
                @click="getIndustryList({
                    industry: list.name
                })"
                >
                    <v-card-title class="justify-center pa-0" >
                        <v-avatar size="60">
                        <v-img
                        :src="require('@/IndustryImg/'+list.img)"
                        style="text-align: center"
                        ></v-img>
                        </v-avatar>
                    </v-card-title>
                    <v-card-title class="justify-center pa-0">
                         <h1 style="font-size: 16px">{{list.name}}</h1>
                    </v-card-title>
                </v-card>
                </v-col>     
            </v-row>
        </v-container>
        <v-container v-show="I_list_show === true" class="px-0">
            <router-view/>
        </v-container>
    </v-app>
</template>
<script>

import {mapActions, mapState} from 'vuex'
export default {
    data(){
        return{
            industries: [
                {name: '한식', img: '0.jpg'},{name: '찜/탕', img: '1.jpg'},{name: '면요리', img: '2.jpg'},
                {name: '고기/구이', img: '3.jpg'},{name: '족발/ 보쌈', img: '4.jpg'}, {name: '치킨', img: '5.jpg'},  
                {name: '분식', img: '6.jpg'},{name: '중식', img: '7.jpg'},  {name: '동남아식', img: '8.jpg'},  
                {name: '회/초밥', img: '9.jpg'},{name: '일식/돈까스', img: '10.jpg'},{name: '피자/샐러드', img: '11.jpg'}, 
                {name: '호프/술집', img: '12.jpg'},{name: '카페/베이커리', img: '13.jpg'}, {name: '배달전문점', img: '14.jpg'}
            ],
            cut:[0,3,6,9,12]
        }
    },
    methods: {
        ...mapActions(['getIndustryList'])
    },
    computed:{
        ...mapState(['I_list_show'])
    },

}
</script>