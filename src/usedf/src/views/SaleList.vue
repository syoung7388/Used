<template>
    <v-app>
        <v-list subheader>
            <v-subheader>Recent chat</v-subheader>

            <v-list-item
                v-for="list in B"
                :key="list.p_num"
            > 
            <v-text-field v-text="list.pictureList"></v-text-field>
        
         
   
           
            </v-list-item>
            
        </v-list>
    </v-app>
</template>

<script>
import Vue from 'vue'
import{mapState} from 'vuex'
export default {
    data(){
        return{
            B: [],
            
          
        }

    },

    computed: {
        ...mapState({
            saleList: 'saleList'})
    },
    created() {
        let a= this.saleList
        for(let i=0; i < a.length; i++){
            let b= a[i].pictureList

            for(let index=0; index< b.length; i++){
         
            }
            Vue.set(a.pictureList, b)  
        }
        this.B= a         
    }
}
</script>