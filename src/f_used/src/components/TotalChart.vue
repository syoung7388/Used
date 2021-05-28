

<script>
import { mapState } from 'vuex'
import {Bar} from 'vue-chartjs'
export default {

    extends: Bar,
    data(){
        return{
            datacollection:{
                labels: this.$store.state.month,
                datasets:[{
                    label: '월별 판매액',
                    data: this.$store.state.total,
                    backgroundColor: 'rgba(54, 162, 235, 0.5)'
                }]
            },

            options: {
                
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true,
                            fontSize : 13,
                
                        },
                        gridLines: {
                            display: true,
                        }
                    }],
                    xAxes: [ {
                        gridLines: {
                            display: false,
                        }
                    }]
                },
                legend: {
                    display: true
                },
                responsive: false, // 그래프 넓이
                maintainAspectRatio: false
            }
        }
    },
    


    computed: {
        ...mapState(['total', 'month'])

    },
    mounted(){
        this.renderChart(this.datacollection, this.options)
    },


 





}
</script>