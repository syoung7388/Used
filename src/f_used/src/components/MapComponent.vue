<template>
    <v-app>
        <v-container class="ss">
            <v-card color="#FAF5EB">
                <h1 style="font-size: 13px; text-align:center;" class="pa-2">좌표 클릭 후 아래의 확인 버튼을 눌러주세요!</h1>
            </v-card>
            <div id= "map" style="width:100%; height:90%;"></div>
            <v-btn @click="OK" color="#FAF5EB" dense block>확인</v-btn>
        </v-container>
    </v-app>
</template>
<script>
import { mapActions, mapState } from 'vuex'
export default {

    computed:{
        ...mapState(['map'])
    },

    
    data(){
        return{
            //map: {},

        }

    },
    methods:{
        initmap(){

  
                var mapOption = {
                center: new naver.maps.LatLng(localStorage.getItem("lat"), localStorage.getItem("lon")),
                zoom: 10
                }
                this.$store.state.map = new naver.maps.Map('map', mapOption)
                var marker = new naver.maps.Marker({
                    position: new naver.maps.LatLng(localStorage.getItem("lat"), localStorage.getItem("lon")),
                    map: this.$store.state.map
                })

                // setTimeout( function() {
                //     window.dispatchEvent(new Event('resize'));
                // }, 600);
                naver.maps.Event.addListener(this.$store.state.map, 'touchstart',(e)=>{
                    marker.setPosition(e.latlng)
                    var latlng = e.latlng
                    localStorage.setItem("lat", latlng.y)
                    localStorage.setItem("lon", latlng.x)
                    console.log(localStorage.getItem("lat"))
                })
 

        },
        OK(){
            this.$emit('mapOK')
        },
        Marker(){


        }
    }
}
</script>
<style scoped>
.ss{
    height: 100%;
}
</style>