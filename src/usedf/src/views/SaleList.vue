<template>
    <v-app class="pa-2"  > 
        <v-list three-line>
            <h1 style="font-size:19px; text-align: center" class="mb-5">{{userInfo.name}}님의 판매내역</h1>
            <h1 style="font-size:15px;" class="green--text mb-5">판매중</h1>
            <template 
            v-for="item in saleList"
            >
               
                <v-list-item :key="item.p_num"> 
                  
                        <v-row>
                            <v-col cols="5">
                                <v-img 
                                :src="require('@/assets/'+item.pictureList[0])"
                                max-height="90"
                                max-width="90"
                                ></v-img>
                            </v-col>
                            <v-col cols="6">
                            <v-list-item-content>
                                <v-list-item-title v-html="item.title"></v-list-item-title>
                                <v-list-item-subtitle v-html="item.p_date"></v-list-item-subtitle>
                                <v-list-item-subtitle v-html="item.sale"></v-list-item-subtitle>
                            </v-list-item-content>
                            </v-col>
                            
                        </v-row>
    

                </v-list-item>
                <!-- <v-divider
                v-if=" index < saleList.length - 1 && saleList.list.sale = true"
                :key="index"
                ></v-divider> -->
            </template>
            <template>
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
            saleList: 'saleList',
            userInfo: 'userInfo'
            })
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
<style>

</style>