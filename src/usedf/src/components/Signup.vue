<template>
        <v-form>
        <v-container>
            <v-row>
                <v-col>
                    <p>입력한 정보가 맞다면</p>
                    <p>아래의 확인 버튼을 눌러주세요.</p>
                    <v-text-field
                     required
                     :rules="emailRules"
                     label="e-mail"
                    ></v-text-field>
                    <v-text-field
                     required
                     :rules= "passwordRules"
                     :type="p"
                     label="비밀번호"
                     hint="8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요."
                     counter
                     maxlength="16"
                    ></v-text-field>
                    <v-text-field
                     required
                     :rules="nameRules"
                     label="닉네임"
                    ></v-text-field>
                </v-col>
            </v-row>
        
        </v-container>
        </v-form>
</template>
<script>

export default{
    data() {
        return {
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
                v => v&&v.length <= 16 || "최대 16자까지 입력가능"
            ],
            items: ['foo', 'bar', 'fizz', 'buzz'],            
                
        }
            
    
    },
}



</script>