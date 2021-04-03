<template>
<v-app>
        <v-container v-show="Eshow===false">
            <h1 class="mb-10 mt-5" style="font-size: 20px; text-align: center">{{userInfo.name}}님 안녕하세요</h1>
            <v-list two-line>
            <v-list-item @click="Edit" router :to="{name: 'EmailEdit'}" >
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">e-mail</v-list-item-title> 
                <v-list-item-subtitle>{{userInfo.username}}</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-icon>
                    <i class="fas fa-chevron-right"  style="font-size: large;"></i> 
                </v-list-item-icon>       
            </v-list-item>
            <v-divider></v-divider>
            </v-list>
            <v-list two-line>
            <v-list-item @click="Edit" router :to="{name: 'PasswordEdit'}">
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">password</v-list-item-title> 
                <v-list-item-subtitle>●●●●●●</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-icon>
                    <i class="fas fa-chevron-right"  style="font-size: large;"></i> 
                </v-list-item-icon>       
            </v-list-item>
            <v-divider></v-divider>
            </v-list>
            <v-list two-line>
            <v-list-item @click="Edit" router :to="{name: 'NameEdit'}">
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">닉네임</v-list-item-title> 
                <v-list-item-subtitle>{{userInfo.name}}</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-icon>
                    <i class="fas fa-chevron-right"  style="font-size: large;"></i> 
                </v-list-item-icon>       
            </v-list-item>
            <v-divider></v-divider>
        </v-list>
        <v-list two-line>
            <v-list-item @click="Edit" router :to="{name: 'PhonEdit'}">
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">전화번호</v-list-item-title> 
                <v-list-item-subtitle>{{userInfo.phone}}</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-icon>
                    <i class="fas fa-chevron-right"  style="font-size: large;"></i> 
                </v-list-item-icon>       
            </v-list-item>
            <v-divider></v-divider>
        </v-list>
        <v-list two-line>
            <v-list-item @click="Edit" router :to="{name: 'AddressEdit'}">
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">주소</v-list-item-title> 
                <v-list-item-subtitle>{{userInfo.address}}</v-list-item-subtitle>
                </v-list-item-content>
                <v-list-item-icon>
                    <i class="fas fa-chevron-right"  style="font-size: large;"></i> 
                </v-list-item-icon>       
            </v-list-item>
            <v-divider class="mb-5"></v-divider>
            <v-btn text @click="Edit" router :to="{name: 'UserDelete'}">
                <p style="font-size:8px;" class="grey--text" >계정삭제를 원하시면 클릭해주세요</p>
            </v-btn>
        </v-list>
        </v-container>
        <v-container v-show="Eshow === true">
            <router-view></router-view>
        </v-container>
</v-app>
</template>
<script>
import {mapActions, mapState} from 'vuex'
export default {
    data(){
        return{
            Eshow: false
        }
    },


    computed: {
        ...mapState(['userInfo'])
    },


    methods:{
        Edit(){
            this.Eshow =true
            this.$store.state.removeBar= true

        }



    }
}
</script>