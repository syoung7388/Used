<template>
    <v-app>
        <v-container >
            <v-row justify="center">
                <v-col cols="5">
                    <p style="font-size: 15px" class="grey--text">{{readyOK}}</p>
                </v-col>
            </v-row>
            <div v-for=" (item, int) in message" :key="int">
                <v-row justify="end" v-if="item.m_username === userInfo.username">
                    <v-col cols="8">
                        <v-card color="skyblue white--text">
                            <p class="ma-1">{{item.content}}</p>
                        </v-card>
                        <p class="grey--text" style="font-size: 10px; text-align:right">{{item.time}}</p>
                    </v-col>
                </v-row>
                <v-row justify="start" v-else>
                    <v-col cols="8">
                        <v-card>
                            <p class="ma-1">{{item.content}}</p>
                        </v-card>
                        <p class="grey--text" style="font-size: 10px; text-align:left">{{item.time}}</p>
                    </v-col>
                </v-row>
            </div>
            <v-bottom-navigation
            fixed
            height="80">
                <v-row align="center">
                    <v-col cols="9" class="my-1">
                        <v-textarea rows="2" solo flat v-model="sendmsg"></v-textarea>
                    </v-col>
                    <v-col cols="3" class="mb-5 ">
                        <v-btn class="primary" small
                        @click="SendMsg({
                        m_username: userInfo.username,
                        content : sendmsg,
                        ch_num : $route.params.num
                        })"
                        ><span class="ma-2  white--text" >전송</span></v-btn>
                    </v-col>
                </v-row>

            </v-bottom-navigation>
            <v-overlay :value="overlay" >
                <v-card color="white">
                    <v-card-text class="black--text">전송오류</v-card-text>
                </v-card>
            </v-overlay>
        </v-container>
    </v-app>
    
</template>
<script>
import { mapState } from 'vuex'
export default {

    data(){
        return{
            readyOK: null,
            sendmsg: null


        }
    },
    beforeCreate(){
        console.log(this.$route.params.num)
        this.$socket.emit('createRoom', {
            seller: this.$route.params.seller,
            buyer: this.$route.params.buyer,
            num :this.$route.params.num
        })
    },
    methods: {
        SendMsg(payload){
            this.$socket.emit('sendMsg', payload , ()=>{
                console.log("aa")
                this.$store.dispatch('Message', payload)
                this.sendmsg = ''
            })


            
        }
    },
    created (){
        this.$socket.on('getMsg', (data)=>{
            if(data !== null){
                console.log(data)
      
            }
        })
    },
    computed: {
        ...mapState(['userInfo', 'message', 'chatInfo', 'overlay', ])
    }
}
</script>