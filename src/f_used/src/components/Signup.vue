<template>
        <v-form id="form">
        <v-container v-show="addr_show=== false" class="pt-15 pr-5 pl-5" >
            <v-row align="center">
                <v-col>
                    <h1 style="font-size: 20px; text-align: center">입력한 정보가 맞다면</h1>
                    <h1 style="font-size: 20px; text-align: center">아래의 확인 버튼을 눌러주세요.</h1>
                    <h1 v-show="err_show === true" class="red--text mt-7" style="font-size: 15px; text-align: center">입력하신 정보를 다시 확인해 주세요.</h1>
                </v-col>
            </v-row>
            <v-row align="center" justify="center" class="mt-2">
                <v-col cols="6"  v-show="username_dup === true">
                    <h1 style="font-size: 11px;" class="primary--text">이미 가입된 e-mail이 있습니다</h1>
                </v-col>
                <v-col cols="6"  v-show="name_dup === true">
                    <h1 style="font-size: 11px;" class="primary--text">이미 가입된 닉네임이 있습니다</h1>
                </v-col>
            </v-row>
            <v-row align="center">
                <v-col>
                    <v-text-field
                     v-model="username"
                     height=40
                     required
                     label="e-mail"
                     class="mt-10"
                    ></v-text-field>
                    <v-text-field
                     height=40
                     v-model="password"
                     required
                     :type="p"
                     label="비밀번호"
                     hint="8~16자 (영문 대 소문자, 숫자, 특수문자 사용가능)"
                     counter
                     maxlength="16"
                    ></v-text-field>
                    <v-text-field
                     height=40
                     v-model="name"
                     required
                     label="닉네임" 
                    ></v-text-field> 
                </v-col>
            </v-row>
            <v-row>
                <v-text-field
                    height=40
                    required
                    label="주소"
                    class="ml-3"
                    v-model="address"
                    @click="Address"
                ></v-text-field>   
            </v-row>
            <div class="text-center pt-10 pr-5 pl-5">
                <v-btn @click="CheckSignup({
                    address,
                    username,
                    name,
                    password,
                    phone  
                })"
                block
                large
                class="primary"
                >확인</v-btn>
            </div>
        </v-container>
        <v-container v-show="addr_show=== true">
            <Address @Addr="Aresult" ref="childaddr"></Address>
        </v-container>

    </v-form>

</template>
<script>
import Address from './Address.vue'
import { mapActions, mapState } from 'vuex'
export default{
    components: { Address },
    data() {
        return {
            address: null,
            password: null,
            username: null,
            name: null,
            addr_show: false,
            p: 'Password',
            err_show: false
                
            
        }
    },
    methods: {
        Address(){
            this.$refs.childaddr.DaumPostCode()
            this.addr_show = true
        },
        Aresult(payload){
            this.address = payload.fullAddress
            this.addr_show= false
        },
        CheckSignup(payload){
            
            (/.+@.+/.test(payload.username))? 
            (payload.name != null)? 
            (payload.password != null && 7 < payload.password.length) ?
            (payload.address != null)?
            this.$store.dispatch('Signup', payload) 
            :this.err_show = true
            :this.err_show = true
            :this.err_show = true
            :this.err_show = true
            
        }
        
        
    },
    computed: {
        ...mapState(['phone', 'username_dup', 'name_dup'])
    },
    beforeCreate(){
        this.$store.state.username_dup = false 
        this.$store.state.name_dup = false
    },
}
</script>
<style>
.form{
    width: 100%;
    height: 100%;
}
</style>