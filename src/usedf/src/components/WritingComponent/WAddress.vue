<template>
    <v-app class="pa-5">
        <v-btn icon @click="Back">
            <i class="fas fa-angle-double-left" style="font-size: large;"></i>
        </v-btn>
        <DaumPostcode
        style="height: 450px"
        :on-complete= handleAddress
        ></DaumPostcode>
        <v-btn
        class="primary mt-3"
        @click="WritingOK({
            fullAddress
        })"
        >확인</v-btn>
    </v-app>
    
</template>
<script>

import DaumPostcode from 'vuejs-daum-postcode'
import{mapActions} from 'vuex'
export default {
  
    data(){
        return{
         

            fullAddress: null,
            extraAddress: '',
            bname: null,
            buildingName: null,
            address: {},
            title: null,
        }
    } ,
    components: {
        DaumPostcode
    },
     methods: {
        handleAddress(e){


            this.fullAddress = e.address
            if (e.addressType === 'R') {
            if (e.bname !== '') {
                this.extraAddress += e.bname
            }
            if (e.buildingName !== '') {
                this.extraAddress += (this.extraAddress !== '' ? `, ${e.buildingName}` : e.buildingName)
            }
            this.fullAddress += (this.extraAddress !== '' ? ` (${this.extraAddress})` : '')

            }
        },

        ...mapActions(['WritingOK']),
        Back(){
            this.$store.state.Writingshow = true
        }
    }

}
</script>