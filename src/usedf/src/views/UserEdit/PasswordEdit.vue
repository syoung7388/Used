<template>
<v-app class="pa-2">
    <v-row>
        <v-col>
            <v-btn icon @click="Editback">
                <i class="fas fa-angle-double-left" style="font-size: large;"></i>
            </v-btn>
            <h1  class="mt-5 " style="font-size: 17px; text-align: center">변경하실 비밀번호를 입력해 주세요.</h1>
            <v-text-field
            height=40
            v-model="password"
            :rules= "passwordRules"
            :type="p"
            label="비밀번호"
            hint="8~16자 (영문 대 소문자, 숫자, 특수문자 사용가능)"
            counter
            maxlength="16"
            ></v-text-field>
            <v-btn  
            class="primary mt-5"
            block
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
            p: 'Password',
            password: null,
            passwordRules:[
            v => v && v.length >= 8 || "최소 8자부터 입력가능"
            ]
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods: {    
        
        Edit(){
            this.userInfo.password = this.password
            this.$store.dispatch('EditOK')
        },
        ...mapActions(['Editback'])
    }

}
</script>
