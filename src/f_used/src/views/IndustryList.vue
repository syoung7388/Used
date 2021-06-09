<template>
    <v-app>
        <v-container class="px-0 py-0" >
            <v-card class="mb-15">
                <v-app-bar
                color="white"
                absolute
                height="60"
                >
                    <v-row justify="center" align="center" >
                        <v-col cols="1" >
                            <v-btn icon @click="Back">
                                <i class="fas fa-arrow-left" style="font-size: large; text-align: left;"></i>
                            </v-btn>
                        </v-col>
                        <v-col cols="10" class="mr-7">
                            <h1 style="text-align: center; font-size: 17px " class="primary--text">{{industry}}</h1>
                        </v-col>
                    </v-row>
                </v-app-bar>
            </v-card>
            <v-row justify="center" class="pt-9"> 
                <v-col cols="5"  v-for="(item, int) in industryList" :key="int" class="py-1 d-flex justify-center">
                    <v-card 
                    width="170"
                    flat
                    @click="getDetail({a_num: item.a_num})"
                    >
                        <v-img
                        :src="getImg(item.product[0].picture[0].pictureName)"
                        max-width="170"
                        height="100" 
                        aspect-ratio="2"
                        > 
                            <p style="text-align: right" class="white--text mr-3" v-show="item.d_day === 0">D-day</p>
                            <p style="text-align: right" class="white--text mr-3" v-show="item.d_day < 0">D{{item.d_day}}</p>
                            <p style="text-align: right" class="white--text mr-3" v-show="item.d_day > 0">D+{{item.d_day}}</p>
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
import {mapActions, mapState} from 'vuex'
import axios from 'axios'
import {checkImg} from '@/mixins/checkImg.js'
export default {
     mixins: [checkImg],

    data(){
        return{

        }
    },
    filters:{
            comma(price){
            var num = new Number(price)
            return num.toFixed(0).replace(/(\d)(?=(\d{3})+(?:\.\d+)?$)/g,"$1,")
        }

                
    },
    beforeCreate(){
        this.$store.state.removeBar =true
    },
    computed: {
        ...mapState(['industryList', 'industry'])
    },
    methods: {
        async plusList($state){
            
            console.log("+후")
            if(this.$store.state.indpagination.allpage === this.$store.state.industrypage){
                $state.complete()            
            }else{

                var lat = this.$store.state.Storage.getItem("lat")
                var lon = this.$store.state.Storage.getItem("lon")
                this.$store.state.industrypage += 1
                var page = this.$store.state.industrypage
                var industry = this.$store.state.industry
            
                axios
                .get(this.$store.state.http+`/api/all/industry?lat=${lat}&lon=${lon}&industry=${industry}&page=${page}`)
                .then(Res => {
                    setTimeout(()=>{
                        var list = Res.data.industrylist     
                        for(var i =0; i<list.length; i++){
                            this.$store.state.industryList.push(list[i])
                        }
                     
                        $state.loaded();
                    }, 1000)

                })
                
            }

        },
        ...mapActions(['getDetail']),
        Back(){
            this.$store.state.industrypage = 0
            this.$router.push({name:'Home'})

             
        }
    },
    components: {
        InfiniteLoading
    },
}
</script>