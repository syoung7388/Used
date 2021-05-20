<template>
    <v-app>
        <v-container >
            <v-row justify="start">
                <v-col cols="3" class="pb-0">
                    <v-btn style="font-size: large;" icon @click="Back" fixed>
                        <i class="fas fa-arrow-left" style="font-size: large;"></i>
                    </v-btn>
                </v-col>
            </v-row>
            <v-row justify="center">
                <v-col cols="5" class="pb-0">
                    <p style="font-size: 15px" class="grey--text">{{readyOK}}</p>
                </v-col>
            </v-row>
            <div v-for=" (item, index) in nowmsg" :key="index">
                <v-row justify="end" v-if="item.m_username === userInfo.username">
                    <v-col cols="8">
                        <v-card color="skyblue white--text" max-width="600">
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
            <v-card height="80" flat class="ma-4"></v-card>
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
                        ch_num : $route.params.num,
                        time: time
                 
                        })"
                        ><span class="ma-2  white--text" >전송</span></v-btn>
                    </v-col>
                </v-row>

            </v-bottom-navigation>
            <v-overlay :value="overlay">
                <v-card color="white">
                    <v-card-text class="black--text">전송오류</v-card-text>
                </v-card>
            </v-overlay>
        </v-container>
         <NullError name="메세지가"></NullError>
    </v-app>
    
</template>
<script>
import dayjs from 'dayjs'
import { mapState } from 'vuex'
import NullError from '@/components/NullError.vue'
export default {

    data(){
        return{
            readyOK: null,
            sendmsg: null,
            nowmsg: [], 
            time: dayjs().format("YYYY-MM-DD HH:mm:ss"),
            test: 0,


        }
    },
    beforeCreate(){
        console.log(this.$route.params.num)
        this.$socket.emit('createRoom', {
            seller: this.$route.params.seller,
            buyer: this.$route.params.buyer,
            ch_num :this.$route.params.num
        })

        
        
    },
    methods: {
        SendMsg(payload){
            this.$store.dispatch('Message', payload)
            .then(()=>{
                if(this.$store.state.Storage.getItem("err") === 'false'){
              
                    this.$socket.emit('sendMsg', payload)
                    this.sendmsg = ''
                }else{
                    this.$store.state.msg_err = false
                    this.sendmsg = ''
                }
            })
        }, 
        Back(){
            this.$store.state.removeBar = true
            this.$router.go(-1)
        },
        AA(data){
            this.nowmsg.push(data)

        }
    },
    mounted(){

        this.$socket.on('getMsg', (data)=>{
            console.log(data)
            this.nowmsg.push(data)
            this.sendmsg = ''
   
        })


    },
    created(){
        console.log(this.message)
        this.nowmsg = this.message
   
    },
    computed: {
        ...mapState(['userInfo', 'message', 'chatInfo', 'overlay' ]),
        // GetMessage(){
        //     this.$socket.on('getMsg', (data)=>{
        //         console.log(data)
        //         this.message.push(data)
        //         this.sendmsg = ''
        //         // this.AA(data)

        //         // this.nowmsg.push(data)
        //         // this.$socket.emit('MsgEnd', "end")
        //     })
        //     return this.message
        // },

        
        
    },  
    beforeDestroy() {
        this.$socket.off('getMsg')
    },

    components: {
      NullError


    }
}
</script>