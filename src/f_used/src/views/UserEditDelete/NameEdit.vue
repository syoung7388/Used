<template>
<v-app class="pa-2">
    <v-row>
        <v-col>
            <v-btn icon @click="E_Back">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <h1  class="mt-5 " style="font-size: 17px; text-align: center">변경하실 닉네임을 입력해 주세요.</h1>
            <v-text-field
            height=40
            v-model="name"
            required
            label="닉네임" 
            ></v-text-field> 
            <v-btn  
            class="primary mt-5"
            block
            @click="Edit"
            >확인</v-btn>
        </v-col>
    </v-row>
</v-app>
</template>
<script>
import { mapActions, mapState, mapMutations} from "vuex";
export default {
    beforeCreate(){
        this.$store.state.removeBar = true
    },
    data(){
        return{
            name: null,
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods: { 
        Edit(){
            this.userInfo.name = this.name
            this.$store.dispatch('EditOK')

        },
        ...mapActions(['E_Back'])
            
    }
}
</script>
