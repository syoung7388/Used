<template>
    <v-app>
        <v-container >
            <v-row justify="start" class="pb-13">
                <v-col cols="3" class="pb-0">
                    <v-btn style="font-size: large; z-index: 1" icon @click="Back" fixed  >
                        <i class="fas fa-arrow-left" style="font-size: large;"></i>
                    </v-btn>
                </v-col>
            </v-row>
            <div v-for=" (item, index) in nowmsg" :key="index">
                <v-row justify="end" v-if="item.m_username === userInfo.username">
                    <v-col cols="8">
                        <div style="float: right">
                        <v-card color="skyblue white--text" style="z-index: 0" max-width="400">
                            <p class="pa-2" style="font-size:14px">{{item.content}}</p>
                        </v-card>
                        <p class="grey--text" style="font-size: 10px; text-align:right">{{item.time}}</p>
                        </div>
                    </v-col>
                </v-row>
                <v-row justify="start" v-else>
                    <v-col cols="8">
                        <div style="float: left">
                            <v-card style=" z-index: 0; align-content: left" max-width="400" >
                                <p class="pa-2" style="font-size:14px">{{item.content}}</p>
                            </v-card>
                            <p class="grey--text" style="font-size: 10px; text-align:left">{{item.time}}</p>
                        </div>
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
                        ch_num : $route.params.ch_num,
                        time: time
                 
                        })"
                        ><span class="ma-2  white--text" >전송</span></v-btn>
                    </v-col>
                </v-row>

            </v-bottom-navigation>
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
            time: dayjs().format("YYYY-MM-DD HH:mm:ss"),
            test: 0,
            nowmsg:[]


        }
    },
    beforeCreate(){
        this.$socket.emit('createRoom', {
            seller: this.$route.params.seller,
            buyer: this.$route.params.buyer,
            ch_num :this.$route.params.ch_num
        })

        
        
    },
    methods: {
        SendMsg(payload){
            this.$store.dispatch('Message', payload)
            .then(()=>{
                if(this.$store.state.Storage.getItem("err") === 'false'){
                    this.$socket.emit('sendMsg', payload)
                }
            })
        }, 
        Back(){
            if(this.$store.state.Storage.getItem("back") === "detail"){
                this.$store.dispatch('getPayDetail',{a_num: this.aucInfo.a_num})
                .then(()=>{
                    state.Storage.removeItem("back")
                })                
            }else{
                this.$store.state.removeBar = true
                this.$router.go(-1)
            }

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

            console.log(this.nowmsg)
        })


    },
    created(){
        
        if(this.message !== undefined){
            console.log(this.message)    
            this.nowmsg = this.message
        }else{
            console.log("aaa")
            this.nowmsg = [{null:"null"}]
            
        }
        //console.log(this.message)
   
    },
    computed: {
        ...mapState(['userInfo', 'message', 'chatInfo', 'overlay' ,'aucInfo']),
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