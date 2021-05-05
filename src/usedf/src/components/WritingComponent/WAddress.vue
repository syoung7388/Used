<template>
<v-app class="pl-1">
    <div id="daum_post"  style="position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;"></div>
    <div id="map_a" hidden></div>

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
            address: null,
            title: null,
            data:[],
            town: null

         

        }
    },

    mounted(){
        const script = document.createElement('script')
        script.src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
        document.head.appendChild(script)

        const scr = document.createElement('script')   
        scr.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e4ae1156e9644814145b77eeb30b26b0&libraries=services'
        document.head.appendChild(scr)

        
        script.onload = ()=>{
            
            var PostcodContainer = document.getElementById('daum_post')
            new daum.Postcode({

            oncomplete: (e)=>{
                //console.log(e)
            
                var fullAddress = e.address
                var extraAddress = ''

                //console.log(this.fullAddress)
                if (e.addressType === 'R') {
                    if (e.bname !== '') {
                        extraAddress += e.bname
                    }
                    if (e.buildingName !== '') {
                        extraAddress += (extraAddress !== '' ? `, ${e.buildingName}` : e.buildingName)
                    }
                    fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '')

                    //console.log(fullAddress)
                    var town = null
                    if(e.bname === ''){
                        town = e.bname1
                    }else{
                        town = e.bname
                    }

                    
                    this.$emit('Addr', {fulladdress: fullAddress , town: town})

                    
                
                    fullAddress= ''
                    extraAddress= ''

                    if(e.address !== ''){
                        var mapContainer = document.getElementById('map')


                        var geocoder = new kakao.maps.services.Geocoder()
                        geocoder.addressSearch(e.address, function(result, status){
                        if(status === kakao.maps.services.Status.OK){


                            console.log(result)
                    
                            localStorage.setItem('lat', result[0].y)
                            localStorage.setItem('lon', result[0].x) 
                            
                            // console.log(coords)
                            console.log(localStorage.getItem('lon'))
                            // console.log(localStorage.getItem('lat'))

                            }

                        })

                    }

            
                }


               

            },

            onresize : function(size) {
            PostcodContainer.style.height = 700+'px';
            PostcodContainer.style.width = 400+'px';
            },

            
            
        }).embed(PostcodContainer)


        scr.onload =() =>kakao.maps.load(this.L)
        }
        

        
    },


    methods: {
        L(){
            var mapContainer = document.getElementById('map_a'),
            mapOption = {
                center: new kakao.maps.LatLng(35.918423, 128.285210),
                level: 3
            }
            var map = new kakao.maps.Map(mapContainer, mapOption)

        }
    }

    
}
</script>