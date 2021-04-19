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


            var geocoder = new kakao.maps.services.Geocoder();
            geocoder.addressSearch(e.address, function(result, status){
                if(status === kakao.maps.services.Status.OK){
                    var coords= new kakao.maps.LatLng(result[0].y, result[0].x)
                    console.log(coords)
                    localStorage.setItem('lat', result[0].y)
                    localStorage.setItem('lon', result[0].x)
        
                }

            })
            

            }
        },

    },
     mounted(){
        if(window.kakao && window.kakao.maps) {
          
            //this.initMap()
        } else {
            const script = document.createElement('script')
            script.onload = () => kakao.maps.load(this.initMap)
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e4ae1156e9644814145b77eeb30b26b0&libraries=services'
            document.head.appendChild(script)
        }
    },

}
</script>