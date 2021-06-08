<template>
    <p style="font-size: 13px; text-align:center" class="mt-2 primary--text">{{remaintime}}</p>
</template>
<script>
import { mapState } from 'vuex'
export default {
    props:['endtime', 'o_num', 'sale'],
    data(){
        return{

            remaintime: null,
            end: null, 
            remainnum: null,
            interval: ''

        }
    },
    computed: {
        


    },
    methods:{
        timer(remainnum){    
            var hour = Math.floor((remainnum % (1000 * 60 * 60 * 24)) / (1000*60*60))
            var miniutes = Math.floor((remainnum % (1000 * 60 * 60)) / (1000*60))
            if(hour < 10){
                hour = "0"+hour
            }
            if(miniutes < 10){
                miniutes = "0"+miniutes
            }
            this.remaintime = hour+":"+miniutes
          
        },
        TimerFilter(remainnum){
            if(remainnum > 0){
                this.timer(remainnum)
            }else{
                clearInterval(this.interval)
                this.remaintime = "기간완료"
                console.log(this.o_num)
                this.$store.dispatch('CheckSkip',{o_num: this.o_num})
                
            }
            if(this.remain> 0){
                this.timer()
            }
        },
    },

    created(){
        if(this.sale === 1){
        
            this.end = new Date(this.endtime).getTime()
            var nowtime = new Date().getTime()
            var remainnum = this.end - nowtime
            this.TimerFilter(remainnum)
     
            if(remainnum> 0){
                this.interval = setInterval(()=>{
                    var nowtime = new Date().getTime()
                    var remainnum = this.end - nowtime
                    // console.log(remainnum)
                    this.TimerFilter(remainnum)
                
                }, 1000)
            }else{
                clearInterval(this.interval)
            }

        }

    }
    
}
</script>