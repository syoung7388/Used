<template>
<v-app >
    <div id="daum_postcode"  style="position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;" ></div>
</v-app>




</template>
<script>
export default {


    data(){
        return{
            fullAddress: null,
            extraAddress: '',
            bname: null,
            buildingName: null,
            address: {},
            title: null,
            data:[],

        }
    },

    mounted(){
        const script = document.createElement('script')
        script.src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
        document.head.appendChild(script)
        
        script.onload = function(){
            var PostcodContainer = document.getElementById('daum_postcode')
            new daum.Postcode({

                oncomplete: function(data){
                    this.data = data
                    console.log(this.data)

                   

                }

            }).embed(PostcodContainer)
        }

        
    },
    methods:{
        // initLayerPosition(){
        //     var width = 300
        //     var height = 300
        //     PostcodContainer.style.

        // },
        handleResult(){
            console.log("주소 나쁜새끼")
            
            
            var e = this.data
            console.log(this.data)
            this.fullAddress = e.address
            console.log(this.fullAddress)
            if (e.addressType === 'R') {
                if (e.bname !== '') {
                    this.extraAddress += e.bname
                }
                if (e.buildingName !== '') {
                    this.extraAddress += (this.extraAddress !== '' ? `, ${e.buildingName}` : e.buildingName)
                }
                this.fullAddress += (this.extraAddress !== '' ? ` (${this.extraAddress})` : '')
                console.log(this.fullAddress)
                this.$emit('Address', this.fullAddress);
                this.fullAddress= null
                this.extraAddress= null

                if(e.address !== null){


                    var geocoder = new kakao.maps.services.Geocoder();
                    geocoder.addressSearch(e.address, function(result, status){
                    if(status === kakao.maps.services.Status.OK){
                        var coords= new kakao.maps.LatLng(result[0].y, result[0].x)
                    // console.log(coords)
                        localStorage.setItem('lat', result[0].y)
                        localStorage.setItem('lon', result[0].x)
                        // console.log(localStorage.getItem('lon'))
                        // console.log(localStorage.getItem('lat'))
            
                    }

                })

                }
                

            }
        },


    }



    
}
</script>