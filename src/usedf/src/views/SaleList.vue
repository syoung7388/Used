<template>
    <v-app class="pa-2"> 
        <v-list three-line>
            <h1 style="font-size:19px;" class="primary--text">판매내역</h1>
            <template v-for="(item, index)  in saleList" >
                <v-list-item :key="item.p_num">
                    <v-list-item-content>
                        <v-list-item-title v-html="item.title"></v-list-item-title>
                        <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
                    </v-list-item-content>
                </v-list-item>
                <v-divider
                v-if="index < saleList.length - 1"
                :key="index"
                ></v-divider>
            </template>
        </v-list>
        <v-divider></v-divider>

    </v-app>
    
</template>
<script>
import Vue from 'vue'
import{mapState} from 'vuex'
export default {
    data(){
        return{            
          
        }

    },

    computed: {
        ...mapState({
            saleList: 'saleList'})
    },
    // created() {
    //     let a= this.saleList
    //     for(let i=0; i < a.length; i++){
    //         let b= a[i].pictureList

    //         for(let index=0; index< b.length; i++){
         
    //         }
    //         Vue.set(a.pictureList, b)  
    //     }
    //     this.B= a         
    // }

}
</script>