<template>
    <v-app>
        <v-container 
        class="px-0" 
    
        >

            <v-row class="pt-2" justify="center">
                <v-col cols="5"  v-for="(item, int) in topList" :key="int" class="py-1">
                    <v-card 
                    width="170"
                    flat
                    @click="getDetail({a_num: item.a_num})"
                    >
                        <v-img
                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                        max-width="170"
                        height="100" 
                        aspect-ratio="2"
                        >
                        <p style="text-align: right" class="white--text mr-3" v-if="item.d_day === 0">D-day</p>
                        <p style="text-align: right" class="white--text mr-3" v-else>D{{item.d_day}}</p>
                        </v-img>
                        <v-card-text style="font-weight: bold ; text-align: left"  class="pa-1 black--text" >{{item.product[0].kind}}</v-card-text>
                        <v-card-text  class="pa-1" >
                            <v-row  class="pa-2">
                                <v-col cols="5" class="pa-1">
                                    <p style="text-align: left" class="black--text">{{item.address.town}}</p>
                                </v-col>
                                <v-col cols="7" class="pa-1">
                                    <p style="text-align: right; font-weight:bolder;" class="black--text">{{item.startprice | comma}}원</p>
                                </v-col>
                            </v-row>
                        </v-card-text>
                    </v-card>
                </v-col>                
            </v-row>

            <infinite-loading  @infinite="plusList" spinner="circles"></infinite-loading >
        </v-container>
  
   
    </v-app>
</template>
<script>
import InfiniteLoading from 'vue-infinite-loading';
import{mapActions, mapState} from 'vuex'
import axios from 'axios'


export default {
    data(){
        return{
            selecteditem: 1,
            heart: false
          
            
            
        }
        
    },
    filters:{
            comma(price){
            var num = new Number(price)
            return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
        }

                
    },


    methods: {

        async plusList($state){
            
            //console.log("+후")
            if(this.$store.state.toppagination.allpage === this.$store.state.toppage){
                $state.complete()            
            }else{

                var lat = localStorage.getItem("lat")
                var lon = localStorage.getItem("lon")
                this.$store.state.toppage += 1
                var page = this.$store.state.toppage
                axios
                .get(`http://localhost:9200/api/all/top?page=${page}&lat=${lat}&lon=${lon}`)
                .then(Res => {
                    setTimeout(()=>{
                        var list = Res.data.toplist     
                        for(var i =0; i<list.length; i++){
                            this.$store.state.topList.push(list[i])
                        }
                     
                        $state.loaded();
                    }, 1000)

                })
                
            }

        },
        ...mapActions(['getDetail']),

   
        

        
     
    },
    components: {
        InfiniteLoading
    },
    computed: {
        ...mapState(['topList'])
    }

    
}
</script>