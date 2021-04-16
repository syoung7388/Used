<template>
    <v-app class="pa-5">
        <DaumPostcode
        style="height: 610px"
        :on-complete= handleAddress
        ></DaumPostcode>
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
            this.$emit('Address', this.fullAddress);

            }
        },
    }

}
</script>