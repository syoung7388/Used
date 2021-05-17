<template>
    <p style="font-size: 15px">{{remaintime}}</p>
</template>
<script>
import dayjs from 'dayjs'
export default {
    props:['endtime', 'sort', 'o_num'],
    data(){
        return{

            // time: dayjs().format("YYYY-MM-DD HH:mm:ss"),
            remaintime: null,
            end: null, 
            remain: null

        }
    },
    methods:{
        timer(){
            
            var hour = Math.floor((this.remain % (1000 * 60 * 60 * 24)) / (1000*60*60))
            var miniutes = Math.floor((this.remain % (1000 * 60 * 60)) / (1000*60))
            this.remaintime = hour+":"+miniutes
            // console.log(this.remaintime)
            
        }

    },

    created(){
        //2021-05-17 12:13:00
        this.end = new Date("2021-05-17 12:14:00").getTime()
        var nowtime = new Date().getTime()
        this.remain = this.end - nowtime
        console.log(this.o_num)
        this.timer()

        var interval = setInterval(()=>{
            var nowtime = new Date().getTime()
            this.remain = this.end - nowtime
            if(this.remain > 0){
                this.timer()
            }else{
                if(this.sort === 'sale'){
                    this.$store.dispatch('CheckPay',{o_num: this.o_num})
                }else{
                    console.log('pay_end')
                }

                clearInterval(interval)
            }

        }, 1000*60)
    }
    
}
</script>