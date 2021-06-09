<template>
    <v-app class="pa-0">
        <v-container v-show="edit_show === false" class="pa-0">
            <v-carousel            
            height="300"
            >
                <v-carousel-item
                v-for="(item, i) in beforeImage"
                :key="i"
                :src="getImg(item.pictureName)"
                reverse-transition="fade-transition"
                transition="fade-transition"
                max-height= "300"
                hide-delimiter-background
                >
                <v-menu 
                offset-y
                absolute
                >
                    <template v-slot:activator="{ on, attrs }">
                        <v-row class="pt-1">
                            <v-col cols="10">
                                <v-btn 
                                style="font-size: large;" 
                                icon 
                                @click="Back"
                                >
                                    <i class="fas fa-arrow-left" style="font-size: large;"></i>
                                </v-btn>
                            </v-col>
                            
                            <v-col cols="2">
                                <v-btn style="font-size: large;" icon v-bind="attrs" v-on="on">
                                    <i class="fas fa-ellipsis-v"></i>
                                </v-btn>
                            </v-col> 
                           
                        </v-row>
                    </template>
                    <v-list>
                        <v-list-item  class="mx-3" dense>
                            <v-list-item-title style="font-size: 15px" @click="Edit">수정</v-list-item-title>
                        </v-list-item >
                        <v-divider></v-divider>
                        <v-list-item class="mx-3" dense > 
                            <v-list-item-title style="font-size: 15px" @click="SaleDelete({a_num: aucInfo.a_num})">삭제</v-list-item-title>
                        </v-list-item>
                    </v-list>
                    </v-menu>
                </v-carousel-item>
            </v-carousel>

            <v-row class="ma-0" justify="start" align="center">
                <v-col cols="3" class="ma-0">
                    <v-list-item-title style="font-size: 12px; ">마감기간</v-list-item-title>
                    <v-list-item-subtitle v-html="aucInfo.enddate" style="font-size: 12px;"></v-list-item-subtitle>
                </v-col>
                <v-col cols="3" v-show="aucInfo.sale === 0">
                </v-col>
                <v-col cols="4" class="py-0" v-show="aucInfo.sale === 0">
                    <v-select
                    :items="item"
                    label="기간연장"
                    v-model="day"
                    dense
                    class="mt-7"
                    ></v-select>
                </v-col>
                <v-col cols="1"  v-show="aucInfo.sale === 0">
                    <v-btn 
                    x-small
                    color="primary"
                    text
                    @click="delay({a_num: aucInfo.a_num, day: day, enddate: aucInfo.enddate})"
                    >
                        확인
                    </v-btn>
                </v-col> 
            
            </v-row>
            <v-divider></v-divider>
                <v-tabs
                align-with-title
                fixed-tabs
                primary
                height= "45"
        
                >
                    <v-tabs-slider></v-tabs-slider>
                    <v-tab class="ml-0" style="font-size: 15px;" v-show="aucInfo.sale=== 0">경매순위</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">게시물</v-tab>
                    <v-tab class="ml-0" style="font-size: 15px;">제품정보</v-tab>
                    <v-tab-item  v-if="aucInfo.sale === 0">
                        <v-card flat class="pa-5"> 
                            <div  v-for="(item, int) in offerInfo" :key="int">
                                <v-row v-if="item.o_username !== null" align="center" justify="center">
                                    <v-col cols="2" >
                                        <h1 style="font-size: 15px;" >{{int+1}}등</h1>
                                    </v-col>
                                    <v-col cols="4" >
                                        <h1 style="font-size: 15px;" >{{item.price}}원</h1>
                                    </v-col>
                                    <v-col cols="3">
                                        <p style="font-size: 15px;" class="mt-3">{{item.o_username}}</p>
                                    </v-col>
                                    <v-col cols="3">
                                        <v-btn v-show="item.skip === 1" color="red" text>스킵</v-btn>
                                         <v-btn text color="primary"
                                         @click="SelectOffer({
                                            a_num: item.a_num,
                                            o_num: item.o_num
                                         })"
                                         v-show="item.skip === 0"
                                         >낙찰</v-btn>
                                    </v-col>
                                </v-row>
                                <v-row v-else>
                                    <v-col>
                                        <h1 style="font-size: 15px; text-align: center" class="grey--text">현재 요청 대기중입니다.</h1>
                                    </v-col>
                                </v-row>
                            </div>
                        </v-card>
                    </v-tab-item>                      
                    <v-tab-item>
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
                    </v-tab-item>
                    <v-tab-item>
                        <v-card flat class="px-5 py-5" >
                            <v-simple-table>
                                <template  >
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
                    </v-tab-item>                
                </v-tabs>
          
        </v-container>
        <v-container v-show="edit_show === true">
            <Edit ref="edit"></Edit>
        </v-container>
    </v-app>
</template>

<script>
import {mapState, mapActions , mapMutations} from 'vuex'
import Edit from '@/components/Edit.vue'
import {checkImg} from '@/mixins/checkImg.js'

export default {
    mixins: [checkImg],
    beforeCreate(){
        this.$store.state.removeBar =true
    },

    data(){
        return{
            day: 0,
            item: [1,2, 3, 4, 5, 6, 7, 8, 9, 10],
 

        }
    },
    computed: {
        ...mapState([ 'aucInfo','likeInfo', 'proInfo', 'offerInfo', 'addrInfo' ,'userInfo', 'edit_show', 'RemoveBar', 'beforeImage'])
    },
    methods: {
        Edit(){
            this.$refs.edit.Origin()
            this.$store.state.edit_show = true
        },
        Back(){
            this.$store.dispatch('getSaleList', {sale: this.aucInfo.sale})
        },
        delay(payload){
            var date = new Date(payload.enddate)
            this.$store.dispatch('Delay', {a_num: payload.a_num, day:payload.day, enddate: payload.enddate}).then(()=>{
            this.day = ''
            })

        },
        ...mapActions(['SaleDelete', 'SelectOffer'])
    },
    components: {
        Edit
    }
    
}
</script>

