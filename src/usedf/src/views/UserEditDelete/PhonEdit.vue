<template>
<v-app class="pa-2 ">
    <v-row >
        <v-col>
            <v-btn icon @click="Editback">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <h1  class="mt-5 " style="font-size: 17px; text-align: center">변경하실 전화번호를 입력해 주세요.</h1>
            <v-text-field
                required
                hint="예시)01011112222"
                v-model="phone"
            ></v-text-field>
            <div v-show="Pshow === false" class="text-center">
            <v-btn 
                class="mt-5 primary align-content-center "
                small 
                @click="sms({phone})"

                
                >인증문자받기</v-btn>
            </div>
            <div v-show="Pshow === true"  class="text-center pa-3" > 
            <v-row>
                <v-text-field
                    required
                    hint="타인에게 공유하지 마세요!"
                    class="mt-3"
                    v-model="certinum"
                >
                </v-text-field> 
                <v-btn 
                    class="mt-7 ml-3 primary--text" 
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
        ...mapActions(['sms', 'certification','Editback']),
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
<style>
.a {
     position: absolute;

}

</style>

