<template>
    <v-app class="pa-0">
        <v-container v-show="Ashow=== false" class="pa-0">
            <v-btn icon @click="E_Back">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <v-row class="py-2" align="center" justify="center">
                <v-col cols="12">
                    <h1  style="font-size: 17px; text-align: center" class="my-10">주소를 선택 후 확인 버튼을 눌러주세요</h1>
                    <v-text-field
                    :placeholder= userInfo.address
                    v-model="address"
                    rows="1"
                    dense
                    @click="GoAddress"
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-btn  
                class="primary mt-5 my-2"
                block
                @click="Edit"
                >확인</v-btn>
            </v-row>
        </v-container>
        <div v-show="Ashow === true" class="pa-0">
            <Address @Addr="Aresult" ref="childaddr"></Address>
        </div>
    </v-app>
</template>
<script>
import { mapActions, mapState, mapMutations} from 'vuex'
import Address from '@/components/Address.vue'

export default{


    beforeCreate(){
        this.$store.state.removeBar = true
    },

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
        console.log(this.userInfo.address)
        this.$store.dispatch('EditOK')
        },
        ...mapActions(['E_Back']),
  

        GoAddress(){
            console.log(this.userInfo)
            this.$refs.childaddr.DaumPostCode()
            this.Ashow= true
        },
        Aresult(payload){
            console.log(payload)
            this.address= payload.fullAddress
            this.Ashow = false
        }
        
    },
    components: {
        Address
    },

}

</script>
