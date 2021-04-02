<template>
    <v-app class="pa-3 ">
        <v-container v-show="edit===false">
            <v-row justify='end'>
                <v-btn
                text
                color="primary"
                medium
                @click="Edit"
                router :to="{name: 'UserEdit'}"
                
    
            >
            <i class="far fa-edit"  style="font-size: x-large;"></i>      
            </v-btn>

            </v-row>
            <v-row  align="center">
                <v-col>
                    <h1 class="mb-10 mt-5" style="font-size: 20px; text-align: center">
                    {{ userInfo.name }}님 안녕하세요
                    </h1>
                </v-col>
            </v-row>
            <v-row align="center">
                <v-col> 
                    <h1 style="font-size: 15px" class="mr-5 mb-3 primary--text" >이메일</h1>
                    <v-banner two-line width=320  height="70" style="font-size: 15px">
                        {{ userInfo.username }}
                    </v-banner>
                </v-col>
            </v-row>
            <v-row align="center" class="mb-5"> 
                    <v-col>
                    <h1 style="font-size: 15px" class="mr-5 primary--text">주소</h1>
                    <v-banner two-line width=320   height="70" style="font-size: 15px">
                        {{ userInfo.address }}
                    </v-banner>
                    </v-col>
            </v-row>
            <v-row align="center">
                <v-col>  
                <h1 style="font-size: 15px" class="mr-5 primary--text">전화번호</h1>
                <v-banner two-line width=320   height="70" style="font-size: 15px">
                    {{ userInfo.phone }}
                </v-banner>
                </v-col>
            </v-row>
        </v-container>
        <v-container v-show="edit ===true">
            <router-view></router-view>
        </v-container>
    





    </v-app>   
</template>
<script>
import { mapState } from 'vuex'



export default{

    data(){
        return{
            edit: false,
        


        }
    },
   computed: {
       ...mapState(['userInfo'])
   },
   methods: {
       Edit(){
           this.edit= true
       }
   }

}
</script>
<style>

</style>

