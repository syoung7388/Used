  
<template>
    <v-app>
        <div v-show="Sshow === false">
        <v-container class="text-center">
            <v-row align="center" class="pa-5">
                <v-col>
                    <h1 style="font-size: 20px; text-align: center" class="mb-4">전화번호를 인증해주세요</h1>
                    <v-text-field
                     required
                     hint="예시)01011112222"
                     v-model="phone"
                    ></v-text-field>
                    <div v-show="Pshow === false">
                   <v-btn 
                     class="mt-5 primary"
                     small 
                     @click="Sms({phone})"
                     
                     >인증문자받기</v-btn>
                    </div>
                    <div v-show="Pshow === true">
                     <v-btn 
                     class="mt-5"
                     disabled
                     small
                     >인증문자받기</v-btn>
                    </div>
                    <div v-show="Pshow === true">
                        <v-text-field
                        required
                        hint="타인에게 공유하지 마세요!"
                        class="mt-3"
                        v-model="certinum"
                        >
                        </v-text-field><v-btn class="ma-5 primary" small @click="Certification({certinum})">인증번호확인</v-btn>
                    </div>
                </v-col>
            </v-row>
        </v-container>

        </div>
        
        <div v-show="Sshow === true" >
            <Signup></Signup>

        </div>
        <div>{{fullAddress}}</div>


     
    
    </v-app>
</template>

<script>
import { mapActions, mapState } from 'vuex'

import Signup from './Signup.vue'
export default{
  components: { Signup },
    
  
    data() {
        return{
            phone: null,
            certinum: null,
            fullAddress: null
        }
    },
    computed: {
        ...mapState (["Pshow", "certi", "Sshow"])
    },
    methods: {
        ...mapActions(['Sms', 'Certification']),
    },
}
</script>