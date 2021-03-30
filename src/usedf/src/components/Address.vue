<template>
    <DaumPostcode
      :on-complete= handleAddress
      ></DaumPostcode>


</template>
 
<script>
import DaumPostcode from 'vuejs-daum-postcode'

 
var handleAddress = (data) => {
  let fullAddress = data.address
  let extraAddress = ''
  if (data.addressType === 'R') {
    if (data.bname !== '') {
      extraAddress += data.bname
    }
    if (data.buildingName !== '') {
      extraAddress += (extraAddress !== '' ? `, ${data.buildingName}` : data.buildingName)
    }
    fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '')
  }
 
  console.log(fullAddress) // e.g. '서울 성동구 왕십리로2길 20 (성수동1가)'
  this.$emit('address', fullAddress)
}

 
export default {
  data() {
    return{
      fullAddress: null,
      extraAddress: null,
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
    handleAddress
  }

}




</script>