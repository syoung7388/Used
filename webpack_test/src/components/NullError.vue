<template>
    <v-list v-show="nullerr === true">
        <v-list-item-title style="text-align: center; font-size: 17px" class="text--black">현재 진행중인 {{this.name}} 없습니다.</v-list-item-title>
    </v-list>
</template>
<script>

import { mapState } from 'vuex'
export default {
    props:['name'],
    computed: {
        ...mapState(['nullerr'])
    }
}
</script>