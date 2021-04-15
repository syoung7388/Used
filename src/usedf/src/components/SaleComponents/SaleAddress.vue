<template>
    <DaumPostcode
      :on-complete= handleAddress
      ></DaumPostcode>


</template>
 
<script>
import DaumPostcode from 'vuejs-daum-postcode'

 
export default {
  data() {
    return{
      fullAddress: null,
      extraAddress: '',
      bname: null,
      buildingName: null,
      address: {}


    }
  },
  name: 'App',
  components: {
    DaumPostcode
  },
  methods: {
    handleAddress(e){
      console.log(e.address)
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
      this.$emit('Address', this.fullAddress);

    }
  }

}



</script>