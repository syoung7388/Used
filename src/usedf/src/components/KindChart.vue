

<script>
import { mapState } from 'vuex'
import {Pie} from 'vue-chartjs'


export default {

    extends: Pie,
    data(){
        return{
            datacollection:{
                labels: this.$store.state.bidkind,
                datasets:[{
                    data: this.$store.state.bidrate,
                    hoverBorderWidth: 10,
                    backgroundColor: [ 'rgba(255, 99, 132, 0.2)',
                                        'rgba(54, 162, 235, 0.2)',
                                        'rgba(255, 206, 86, 0.2)',
                                        'rgba(75, 192, 192, 0.2)',
                                        'rgba(153, 102, 255, 0.2)',
                                        'rgba(255, 159, 64, 0.2)'
                    ],
                }]
            },

            options: {
                 hoverBorderWidth: 20
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