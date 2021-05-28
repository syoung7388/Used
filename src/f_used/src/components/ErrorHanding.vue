<template>
    <v-overlay :value="overlay">
        <v-alert v-show="homeerr=== true ||err === true "   color="orange" densetype="error">오류가 발생하였습니다. 다시 한번 시도해 주세요</v-alert>
        <v-alert v-show="inserterr === true"  color="orange" dense type="error">입력하신걸 확인해 주세요</v-alert>
         <v-alert v-show="askerr === true"  color="orange" dense type="error">요청하신 결과가 없습니다.</v-alert>
    </v-overlay>
</template>
<script>
import { mapState } from 'vuex'
export default {
    computed: {
        ...mapState(['homeerr', 'err', 'inserterr', 'overlay', 'askerr'])
    }
}
</script>