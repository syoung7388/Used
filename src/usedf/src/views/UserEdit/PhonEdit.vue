<template>
<v-app class="pa-5 text-center">
    <v-row >
        <v-col>
            <v-alert
                dense
                text
                type="error"
                x-small
                :value="certiError"
            >
            인증번호가 틀립니다!
            </v-alert>
            <v-alert
                dense
                text
                type="error"
                x-small
                :value="phoneError"
            >
             휴대폰 번호를 확인해주세요
            </v-alert>
            <h1  class="mt-5 " style="font-size: 20px; text-align: center">변경하실 전화번호를 입력하세요</h1>
            <v-text-field
                required
                hint="예시)01011112222"
                v-model="phone"
            ></v-text-field>
            <div v-show="Pshow === false">
            <v-btn 
                class="mt-5 primary"
                small 
                @click="sms({phone})"
                
                >인증문자받기</v-btn>
            </div>
            <div v-show="Pshow === true">
            <v-row>
            <v-text-field
                required
                hint="타인에게 공유하지 마세요!"
                class="mt-3"
                v-model="certinum"
            >
            </v-text-field> 
            <v-btn 
                class="ma-5 primary--text" 
                small 
                @click="certification({certinum})"
                outlined
            >확인</v-btn>
            </v-row>
            <v-btn  
                class="primary mt-5"
                block
                @click="Edit"
            >저장</v-btn>
            </div>
        </v-col>
    </v-row>
</v-app>
</template>
<script>
import { mapState, mapActions } from "vuex"
export default {
    
    data(){
        return{
            phone: null,
            certinum: null,

          
        }
        
    },
    methods: {
        ...mapActions(['sms', 'certification']),
        Edit(){
            this.userInfo.phone = this.phone
            this.$store.dispatch('EditOK')

        }
    },
    computed: {
        ...mapState(["Pshow", "certi",'phoneError','certiError','userInfo'])
    }

}
</script>

