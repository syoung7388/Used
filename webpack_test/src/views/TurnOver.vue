<template>
    <TurnOverChart :height="600" ></TurnOverChart>
</template>
<script>
import TurnOverChart from '@/components/TurnOverChart.vue'
export default {
    beforeCreate(){
        this.$store.state.removeBar =false
    },
    data(){
        return{
          

        }
    },
    components: {
        TurnOverChart
    }
}
</script>