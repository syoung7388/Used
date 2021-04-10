<template>
    <v-app>
        <v-list subheader>
            <v-subheader>Recent chat</v-subheader>

            <v-list-item
                v-for="list in saleList"
                :key="list.p_num"
            >
  
                <v-list-item-title v-text="list.title"></v-list-item-title>
                <v-divider></v-divider>
              
            </v-list-item>
        </v-list>
    </v-app>
</template>

<script>
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

    
}
</script>