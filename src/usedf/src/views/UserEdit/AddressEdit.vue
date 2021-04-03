<template>
<v-app class="pa-5">
    <v-container  v-show="Ashow=== false">
        <v-row>
            <v-text-field
            label="address"
            auto-grow
            rows="2"
            height=50
            v-model="address"
            ></v-text-field>
            <v-btn 
            small 
            class="primary--text mt-7 "
            @click="GoAddress"
            outlined          
            >검색</v-btn>
        </v-row>
        <v-row>
            <v-btn  
            class="primary mt-5"
            block
            x-large
            @click="EditOK({ 
                address
            })"
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
    methods: {
        ...mapActions(['EditOK']),

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
