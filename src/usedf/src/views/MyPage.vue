<template>
    <v-app>
        <v-subheader class="mb-10">
           {{uInfo.name}}님 안녕하세요
        </v-subheader>
        <v-text-field
            hide-details="auto"
        ></v-text-field>


    </v-app>   
</template>
<script>
import {mapState} from 'vuex'

export default{
    computed: {
        ...mapState(['userInfo'])
    },

    data() {
        return{
            uInfo: $store.state.userInfo
        }

    }
}
</script>

