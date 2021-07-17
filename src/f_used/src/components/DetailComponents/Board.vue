<template>
    <v-card class="px-4 py-5" flat>
        <v-simple-table>
            <template>
                <tbody>
                    <tr>
                        <td style="font-weight: bold; font-size: 16px">{{aucInfo.title}}</td>
                    </tr>
                    <tr>
                        <td  class="pt-5">{{aucInfo.content}}</td>
                    </tr>
                </tbody>
            </template>
        </v-simple-table>
    </v-card>   
</template>
<script>
import {mapState} from 'vuex'
export default {
    computed:{
        ...mapState(['aucInfo'])
    }
    
}
</script>