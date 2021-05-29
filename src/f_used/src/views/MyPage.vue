<template>
<v-app>
        <v-container  v-show="Eshow === false">
            <v-btn icon @click="RouterBack({name: 'Home'})">
                <i class="fas fa-arrow-left" style="font-size: large;"></i>
            </v-btn>
            <h1 class="mb-10 mt-2" style="font-size: 20px; text-align: center">{{userInfo.name}}님 안녕하세요</h1>
            <v-list two-line>
            <v-list-item>
                <v-list-item-content>
                <v-list-item-title class="primary--text mb-3">e-mail</v-list-item-title> 
                <v-list-item-subtitle>{{userInfo.username}}</v-list-item-subtitle>
                </v-list-item-content>   
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
        <v-list three-line>
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
        </v-list>
         <v-row justify="center">
                <v-col cols="4">
                    <v-btn outlined small color="grey" @click="Logout"> 
                        <span class="black--text">로그아웃</span>
                    </v-btn>
                </v-col>
            </v-row>
            <v-row justify="center">
                <v-col cols="8">
                    <v-btn text @click="Edit" router :to="{name: 'UserDelete'}">
                        <p style="font-size:10px;" class="grey--text" >계정삭제를 원하시면 클릭해주세요</p>
                    </v-btn>
                </v-col>
            </v-row>
        </v-container>
        <v-container v-show="Eshow === true">
            <router-view></router-view>
        </v-container>

</v-app>
</template>
<script>
import {mapActions, mapState,mapMutations} from 'vuex'
export default {
    beforeCreate(){
        this.$store.state.removeBar =true
    },
    data(){
        return{
            
        }
    },


    computed: {
        ...mapState(['userInfo', 'Eshow'])
    },


    methods:{
        Edit(){
            this.$store.state.Eshow = true
        },
        ...mapActions(['Logout', 'RouterBack'])



    }
}
</script>