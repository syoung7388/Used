<template>
    <v-app>
        <v-container 
        class="px-0" >
            <v-row justify="center" class="pt-2">
                <v-col cols="5"  v-for="(item, int) in topList" :key="int" class="py-1">
                    <v-card 
                    width="170"
                    flat
                    >
                        <v-img
                        :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
                        max-width="170"
                        height="100" 
                        aspect-ratio="2"
                        > 
                        <p style="text-align: right" class="white--text mr-3">D{{item.d_day}}</p>
                        </v-img>
                        <v-card-text style="font-weight: bold ; text-align: left"  class="pa-1 black--text" >{{item.product[0].kind}}</v-card-text>
                        <v-card-text  class="pa-1" >
                            <v-row  class="pa-2">
                                <v-col cols="5" class="pa-1">
                                    <p style="text-align: left" class="black--text">{{item.address.town}}</p>
                                </v-col>
                                <v-col cols="7" class="pa-1">
                                    <p style="text-align: right; font-weight:bolder;" class="black--text">{{item.startprice}}원</p>
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


    methods: {
        TopDetail(payload){
            this.$store.state.backType= "top"
            this.$store.dispatch('getDetail',{a_num: payload})
        },
        plusList($state){
            
            console.log("+후")
            if(this.$store.state.topList[0].count !== this.$store.state.topList.length){
                var lat = localStorage.getItem("lat")
                var lon = localStorage.getItem("lon")
                var limit = this.$store.state.toplimit
                axios
                .get(`http://localhost:9200/api/auction/top?limit=${limit}&lat=${lat}&lon=${lon}`)
                .then(Res => {
                    setTimeout(()=>{    
                        console.log(Res.data)
                        for(var i =0; i<Res.data.length; i++){
                            this.$store.state.topList.push(Res.data[i])
                        }
                        this.$store.state.toplimit += 6
                        $state.loaded();
                    }, 1000)

                })
                    
                
            }else{
                $state.complete()
            }

            

        },
        
     
    },
    components: {
        InfiniteLoading
    },
    computed: {
        ...mapState(['topList'])
    }

    
}
</script>