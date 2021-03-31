<template>
        <v-form>
        <v-container v-show="Ashow=== false" class="pt-15 pr-5 pl-5">
            <v-row>
                <v-col>
                    <h1 style="font-size: 20px; text-align: center">입력한 정보가 맞다면</h1>
                    <h1 style="font-size: 20px; text-align: center">아래의 확인 버튼을 눌러주세요.</h1>
                    <v-text-field
                     v-model="email"
                     class="mt-8"
                     required
                     :rules="emailRules"
                     label="e-mail"
                    ></v-text-field>
                    <v-text-field
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
                    required
                    label="주소"
                    class="ml-3"
                    v-model="address"
                ></v-text-field>
                <v-btn @click="Asearch" class="mt-5 ml-2 mr-3" small>검색하기</v-btn>    
            </v-row>
            <v-row>
                <v-btn @click="signup({
                    address,
                    email,
                    username,
                    password,
                    phone   
                })">확인</v-btn>
            </v-row>
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