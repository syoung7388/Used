<template>
    <v-container class="pa-0">
        <v-simple-table>
            <tbody>
                <tr v-for="i in 9" :key="i" >
                    <td style="font-weight: bold; font-size:17px">{{kinds[i]}}</td>
                    <td style="font-weight: bold; font-size:17px">{{kinds[i+1]}}</td>
                </tr>
            </tbody>
        </v-simple-table>

    </v-container>
</template>
<script>

export default {
    data(){
        return{
            kinds: ['작업대','커피머신','그릴기','냉동 절육기','제빙기','오븐기','튀김기','기름 정제기','씽크대','소독기','가스렌지','냉장고/쇼케이스','보온통','에어컨','회전국솥','절단기','벽선단','기타'],
        }
    }
    
}
</script>