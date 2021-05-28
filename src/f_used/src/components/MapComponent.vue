<template>
    <v-app>
        <v-container class="pa-0">
            <v-card color="#FAF5EB">
                <h1 style="font-size: 13px; text-align:center;" class="pa-2">좌표 클릭 후 아래의 확인 버튼을 눌러주세요!</h1>
            </v-card>
            <div id= "map" style="width:100%; height:90%;"></div>
            <v-btn @click="OK" color="#FAF5EB" dense block>확인</v-btn>
        </v-container>
    </v-app>
</template>
<script>
import { mapActions } from 'vuex'
export default {
    methods:{
        initmap(){
            var mapOption = {
            center: new naver.maps.LatLng(37.3595316, 127.1052133),
            zoom: 10
            }
            var map = new naver.maps.Map('map', mapOption)
            var marker = new naver.maps.Marker({
                position: new naver.maps.LatLng(37.3595316, 127.1052133),
                map: map
            })
            naver.maps.Event.addListener(map, 'touchstart',(e)=>{
                marker.setPosition(e.latlng)
                localStorage.setItem("lat", e._lat)
                localStorage.setItem("lon", e._lng)
                console.log(e.latlng)
            })
        },
        OK(){
            this.$emit('mapOK')
        }
    }
}
</script>