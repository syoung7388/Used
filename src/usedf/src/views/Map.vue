<template>
    <v-app>

        <div id= "map" style="width:500px;height:400px;"></div>
        <v-btn @click="MapOK" >확인</v-btn>
    </v-app>
</template>
<script>
import { mapActions } from 'vuex'
export default {

    data(){
        return{
     

        }
    },
    mounted(){
        if(window.kakao && window.kakao.maps) {
          
            this.initMap()
        } else {
            const script = document.createElement('script')
            script.onload = () => kakao.maps.load(this.initMap)
            script.src = 'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=e4ae1156e9644814145b77eeb30b26b0&libraries=services'
            document.head.appendChild(script)
        }
    },
    methods: {
        initMap(){    
            var mapContainer = document.getElementById('map'),
            mapOption = {
                center: new kakao.maps.LatLng(35.918423, 128.285210),
                level: 3
            }
            var map = new kakao.maps.Map(mapContainer, mapOption)
            var marker = new kakao.maps.Marker()


            /// 지도 표시

            if(navigator.geolocation){
                navigator.geolocation.getCurrentPosition(function(position){
                    let lat = position.coords.latitude,
                        lon = position.coords.longitude;
                    var locPosition = new kakao.maps.LatLng(lat, lon)

                    localStorage.setItem('lat',lat)
                    localStorage.setItem('lon',lon)

    
                   
                       
                    marker.setPosition(locPosition)
                    marker.setMap(map)
                    map.setCenter(locPosition)
                })

            }else{
                var locPosition = new kakao.maps.LatLng(33.450701, 126.570667)               
                marker.setPosition(locPosition)
                marker.setMap(map)
                map.setCenter(locPosition)    
            }
            

        //위도 경도로 위치 표시


            var geocoder = new kakao.maps.services.Geocoder()

            var marker = new kakao.maps.Marker()

            
      
            kakao.maps.event.addListener(map, 'click', function(mouseEvent) {
                searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {

                        var Latlng = mouseEvent.latLng


                         localStorage.setItem('lat', Latlng.getLat())
                         localStorage.setItem('lon', Latlng.getLng())
                    


                        // 마커를 클릭한 위치에 표시합니다 
                        marker.setPosition(mouseEvent.latLng)
                        marker.setMap(map);
                        map.setCenter(mouseEvent.latLng)
                        //console.log(localStorage.getItem('lat'))
                        
                    }                
                    
                    
                });
            });
    
            function searchDetailAddrFromCoords(coords, callback) {
            // 좌표로 법정동 상세 주소 정보를 요청합니다
                geocoder.coord2Address(coords.getLng(), coords.getLat(), callback);
               
            }


        
        
        },
        ...mapActions(['MapOK'])
 
    } ///클릭한 위치 지도로 전환

   
}
</script>