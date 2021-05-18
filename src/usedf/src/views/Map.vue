<template>
    <v-app>
        <v-card color="#FAF5EB">
            <h1 style="font-size: 13px; text-align: center;" class="pa-2">좌표 클릭 후 아래의 확인 버튼을 눌러주세요!</h1>
        </v-card>
        <div id= "map" style="width:100%;height:670px;"></div>
        <v-btn @click="getTopList" color="#FAF5EB">확인</v-btn>
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

            
      
            kakao.maps.event.addListener(map, 'click', (mouseEvent)=> {
                searchDetailAddrFromCoords(mouseEvent.latLng, function(result, status) {
                    if (status === kakao.maps.services.Status.OK) {

                        var Latlng = mouseEvent.latLng


                         localStorage.setItem('lat', Latlng.getLat())
                         localStorage.setItem('lon', Latlng.getLng())
                        // 마커를 클릭한 위치에 표시합니다 
                        marker.setPosition(mouseEvent.latLng)
                        marker.setMap(map);
                        map.setCenter(mouseEvent.latLng)
                     
                        
                    }else{
                        console.log("KakaoMap 오류")
                    }              
                });
            });
        
        },
        ...mapActions(['getTopList'])
 
    } ///클릭한 위치 지도로 전환

   
}
</script>