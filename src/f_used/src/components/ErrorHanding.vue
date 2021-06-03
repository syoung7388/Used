<template>
    <v-app>
        <v-overlay :value="overlay">
            <v-alert v-show="homeerr=== true ||err === true "   color="orange" type="warning" >오류가 발생하였습니다. 다시 한번 시도해 주세요</v-alert>
            <v-alert v-show="inserterr === true"  color="orange" type="warning">입력하신걸 확인해 주세요</v-alert>
            <v-alert v-show="askerr === true"  color="orange" type="warning">요청하신 결과가 없습니다.</v-alert>
        </v-overlay>
    </v-app>
</template>
<script>
import { mapState } from 'vuex'
export default {
    computed: {
        ...mapState(['homeerr', 'err', 'inserterr', 'overlay', 'askerr'])
    }
}
</script>