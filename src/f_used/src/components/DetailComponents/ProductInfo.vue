<template>
     <v-card flat class="px-3 py-5">
        <v-simple-table>
            <template>
                <tbody>
                    <tr class="text-center">
                        <td style="font-size: 17px">종류</td>
                        <td style="font-size: 17px">{{proInfo.kind}}</td>
                    </tr>
                    <tr class="text-center">
                        <td style="font-size: 17px">업종</td>
                        <td style="font-size: 17px">{{proInfo.industry}}</td>
                    </tr>
                    <tr class="text-center">
                        <td style="font-size: 17px">브랜드</td>
                        <td style="font-size: 17px">{{proInfo.brand}}</td>
                    </tr>
                    <tr class="text-center">
                        <td style="font-size: 17px">연식</td>
                        <td style="font-size: 17px">{{proInfo.year}}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
    </v-card>
</template>

<script>
import {mapState} from 'vuex'

export default {
    computed: {
        ...mapState(['proInfo'])
    }
}
</script>