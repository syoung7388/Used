<template>
    <v-card flat class="py-1"> 
        <div  v-for="(item, int) in offerInfo" :key="int">
            <v-row v-if="item.o_username !== null" align="center" justify="center">
                <v-col cols="3" >
                    <h1 style="font-size: 18px; text-align:center" >{{int+1}}등</h1>
                </v-col>
                <v-col cols="5" >
                    <h1 style="font-size: 18px; text-align:center" >{{item.price}}원</h1>
                </v-col>
                <v-col cols="4">
                    <p style="font-size: 18px; text-align:center" class="mt-3">{{item.o_username}}님</p>
                </v-col>
            </v-row>
            <v-row v-else justify="center" align="center">
                <v-col cols="10">
                    <h1 style="font-size: 15px; text-align: center" class="grey--text mt-5">현재 요청 대기중입니다</h1>
                </v-col>
            </v-row>
        </div>
    </v-card>
</template>
<script>
import {mapState} from 'vuex'
export default {
    computed:{
        ...mapState(['offerInfo'])
    }
    
}
</script>