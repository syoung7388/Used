<template>
  <v-container
    class="pa-2"
  >
    <v-btn icon @click="Editback">
      <i class="fas fa-angle-double-left" style="font-size: large;"></i>
    </v-btn>
    <h1 class="mt-5 " style="font-size: 17px; text-align:center">"{{userInfo.name}}"님 당신과 함께한 Used는</h1>
    <h1 class="mt-5 " style="font-size: 17px; text-align:center"> 행복했습니다. </h1>
    <h1 class="mt-5" style="font-size: 17px; text-align:center">앞으로 꽃길 걸으세요.</h1>


    <v-row class="mt-10" justify="center">
    <v-checkbox
    v-model="checkbox"
    :label="Box"
    ></v-checkbox>
    <v-btn @click="deleteOK" class="ml-6 mt-3" color="primary" text>확인</v-btn>
    </v-row>
  </v-container>
  
</template>
<script>
import {mapState, mapActions} from 'vuex'

export default{
    data(){
        return{
            Box: '약관의 동의',
            checkbox: true
        }
    },
    computed: {
        ...mapState(['userInfo'])
    },
    methods:{
        ...mapActions(['deleteOK','Editback'])
    }


}


</script>
