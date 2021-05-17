<script>
import { Bar } from 'vue-chartjs'
export default {

    extends: Bar,
    data(){
        return{
            datacollection:{
                labels: this.$store.state.t_month,
                datasets:[{
                    label: '월별 매출액',
                    data: this.$store.state.t_amount,
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
                maintainAspectRatio: false,
            }
        }
    },
    


    computed: {


    },
    mounted(){
        this.renderChart(this.datacollection, this.options)
    },


 





}
</script>