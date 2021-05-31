<template>
    <v-container class="pt-7">

            <v-row justify="center">

                <v-col cols="6" v-for="(item, i) in kinds" :key="i">                
                        <h1 style="font-size: 17px ; text-align: center; font-weight: bold" @click="getKindList({kind: item})" class="mb-2">{{item}}</h1>    
                    <v-divider></v-divider>
                </v-col>
            </v-row>
     
    </v-container>
</template>
<script>
import {mapActions, mapState} from 'vuex'

export default {



    data(){
        return{
             kinds: ['작업대','커피머신','그릴기','냉동 절육기','제빙기','오븐기','튀김기','기름 정제기','씽크대','소독기','가스렌지','냉장고/쇼케이스','보온통','에어컨','회전국솥','절단기','벽선단','기타'],

             
            
        }
    },
    methods: {
        ...mapActions(['getKindList']),
    },
    computed: {
    
    }    
}
</script>