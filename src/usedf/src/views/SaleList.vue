<template>
    <v-tabs
      show-arrows
      height="200"
    >

      <v-tab v-for="(item,index) in saleList" :key="index" >
        <v-card width="120">
          <v-img
          :src="require('@/assets/'+item.product[0].picture[0].pictureName)"
          max-width="120"
          height="100" 
          aspect-ratio="2"
          ></v-img>
          <v-row>
            <v-col cols="6">
              <h1>{{item.topprice}}</h1>
            </v-col>
          </v-row>
        </v-card>
        
      </v-tab>
    </v-tabs>

</template>
<script>
import Vue from 'vue'
import{mapActions, mapState} from 'vuex'
export default {
    data(){
        return{   
            selecteditem:1,
             
           
        }
    },
    beforeCreate(){
        this.$store.dispatch('getSaleList')
    },
    computed: {
        ...mapState({
            saleList: 'saleList',
            soldList: 'soldList',
            userInfo: 'userInfo',
            list_show: 'list_show',
            })
    },
    methods: {
        ...mapActions(['getSaleDetail'])
    }
 
}
</script>
<style>
</style>