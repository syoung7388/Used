<template>
<v-app class="pa-2 ">
    <v-row >
        <v-col>
            <v-btn icon @click="E_Back">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>

            <p v-show="certi_err === true" style="font-size: 15px; text-align:center" class="red--text">인증 번호가 틀립니다.</p>
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
                    @click="Sms({phone})"
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
            </v-row>
            <v-btn  
                class="primary mt-5"
                block
                @click="Edit({certinum: certinum})"
            >확인</v-btn>
            </div>
        </v-col>
    </v-row>
</v-app>
</template>
<script>
import { mapState, mapActions , mapMutations} from "vuex"
export default {
    beforeCreate(){
        this.$store.state.removeBar = true
        this.$store.state.certi_err = false
        this.$store.state.Pshow = false
    },
    
    data(){
        return{
            phone: null,
            certinum: null,

          
        }
        
    },
    methods: {
        ...mapActions(['Sms', 'Certification','E_Back']),
        Edit(payload){

              if(this.certi === payload.certinum){

                this.userInfo.phone = this.phone
                this.$store.dispatch('EditOK')
              }else{
                  this.$store.state.certi_err = true
                  this.$store.state.Pshow = true

              }


        },
    },
    computed: {
        ...mapState(["Pshow", "certi",'phoneError','certi_err','userInfo'])
    }

}
</script>
<style>
.a {
     position: absolute;

}

</style>

