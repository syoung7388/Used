<template>
        <v-form id="form">
        <v-container v-show="Ashow=== false" class="pt-15 pr-5 pl-10" >
            <v-row align="center">
                <v-col>
                    <h1 style="font-size: 20px; text-align: center">입력한 정보가 맞다면</h1>
                    <h1 style="font-size: 20px; text-align: center">아래의 확인 버튼을 눌러주세요.</h1>
                    <v-text-field
                     v-model="email"
                     height=90
                     required
                     :rules="emailRules"
                     label="e-mail"
                    ></v-text-field>
                    <v-text-field
                     height=40
                     v-model="password"
                     required
                     :rules= "passwordRules"
                     :type="p"
                     label="비밀번호"
                     hint="8~16자 (영문 대 소문자, 숫자, 특수문자 사용가능)"
                     counter
                     maxlength="16"
                    ></v-text-field>
                    <v-text-field
                     height=40
                     v-model="username"
                     required
                     :rules="nameRules"
                     label="닉네임" 
                    ></v-text-field> 
                     <!-- 중복확인 버튼 -->
                </v-col>
            </v-row>
            <v-row>
                <v-text-field
                    height=40
                    required
                    label="주소"
                    class="ml-3"
                    v-model="address"
                ></v-text-field>
                <v-btn @click="Asearch" class=" ml-2 mr-3 mt-7" small>검색하기</v-btn>    
            </v-row>
            <div class="text-center pt-15 pr-5 pl-1">
                <v-btn @click="signup({
                    address,
                    email,
                    username,
                    password,
                    phone  
                })"
                block
                x-large
                class="primary"
                >확인</v-btn>
            </div>
        </v-container>
        <v-container v-show="Ashow=== true">
            <Address @Address= "Faddress"></Address>
        </v-container>
    </v-form>

</template>
<script>
import Address from './Address.vue'
import { mapActions, mapState } from 'vuex'

export default{
    components: { Address },
    data() {
        return {
            address: null,
            password: null,
            username: null,
            email: null,
            Ashow: false,
            email: '',
            name: '',
            p: 'Password',
            nameRules:[
                v => !!v || "필수입력란"
            ],
            emailRules:[
                v => !!v || "필수입력란",
                v => /.+@.+/.test(v) || "유효하지 않은 이메일"
            ],
            passwordRules:[
                v => !!v || "필수입력란",
                v => v && v.length >= 8 || "최소 8자부터 입력가능"
            ],
            items: ['foo', 'bar', 'fizz', 'buzz'],            
                
        }
    },
    methods: {
        Asearch(){
            this.Ashow = !this.Ashow
        },
        Faddress(address){
            this.address = address
            this.Ashow= !this.Ashow
        },
        ...mapActions(['signup']),
        

    },
    computed: {
        ...mapState(['phone'])
    }


}
</script>
<style>

.form{
    width: 100%;
    height: 100%;

}

</style>