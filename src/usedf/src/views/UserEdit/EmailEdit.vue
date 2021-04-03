<template>
<v-app class="pa-5">
    <v-row>
        <v-col>
            <h1  class="mt-5 " style="font-size: 20px; text-align: center">변경하실 email을 입력하세요</h1>
            <v-text-field
            v-model="username"
            height=40
            required
            :rules="emailRules"
            label="이메일"
            class="mt-10"
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
import { mapState, mapActions } from "vuex"
export default {
    
    data(){
        return{
            username: null,

            emailRules:[
                v => /.+@.+/.test(v) || "유효하지 않은 이메일"
            ],         
        }
        
    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods: {
        Edit(){
            this.userInfo.username = this.username
            this.$store.dispatch('EditOK')

        }
    }

}
</script>