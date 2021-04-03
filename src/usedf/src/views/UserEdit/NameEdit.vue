<template>
<v-app class="pa-5">
    <v-row>
        <v-col>
            <h1  class="mt-5 " style="font-size: 20px; text-align: center">변경하실 닉네임을 입력하세요</h1>
            <v-text-field
            height=40
            v-model="name"
            required
            label="닉네임" 
            ></v-text-field> 
            <v-btn  
            class="primary mt-5"
            block
            x-large
            @click="Edit"
            >확인</v-btn>
        </v-col>
    </v-row>
</v-app>
</template>
<script>
import {  mapState} from "vuex";
export default {
    data(){
        return{
            name: null,
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods: { 
        Edit(){
            this.userInfo.name = this.name
            this.$store.dispatch('EditOK')

        }
            
    }
}
</script>
