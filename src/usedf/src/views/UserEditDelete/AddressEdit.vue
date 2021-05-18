<template>
<v-app class="pa-2">
    <v-container  v-show="Ashow=== false">
        <v-row>
            <v-btn icon @click="Editback">
                <i class="fas fa-angle-double-left" style="font-size: large;"></i>
            </v-btn>
            <h1  class="mt-5 " style="font-size: 16px; text-align:center">주소를 검색하시고 확인 버튼을 눌러주세요</h1>
            <v-text-field
            label="address"
            auto-grow
            rows="2"
            height=50
            v-model="address"
            ></v-text-field>
            <v-btn 
            small 
            class="primary--text ml-5 mt-9"
            @click="GoAddress"
            outlined          
            >검색</v-btn>
        </v-row>
        <v-row>
            <v-btn  
            class="primary mt-5"
            block
            @click="Edit"
            >확인</v-btn>
        </v-row>
    </v-container>
    <v-container v-show="Ashow=== true">
        <Address @Address= "Aresult"></Address>
    </v-container>
    
</v-app>
</template>
<script>
import { mapActions, mapState} from 'vuex'
import Address from '@/components/Address.vue'

export default{
    data(){
        return{
            address: null,
            Ashow: false
   
        }

    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods: {
        Edit(){
        this.userInfo.address = this.address
        this.$store.dispatch('EditOK')
        },
        ...mapActions(['Editback']),

//////////////////////////////////////////////////////-주소Components
        GoAddress(){
            this.Ashow= true
        },
        Aresult(address){
            this.address= address
            this.Ashow = !this.Ashow
        }
    },
    components: {
        Address
    },

}

</script>
