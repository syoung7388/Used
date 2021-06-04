<template>
    <v-app>
        <h1 style="font-size: 20px; text-align:center" class="py-3">경매진행 절차 구분 방법? a_sale(sale) / o_select(select) / o_skip(skip)</h1>
        <p style="font-size: 15px; text-align:center" class="grey--text pb-1">경매 절차를 구분 하는 칼럼으로 a_sale, o_select,o_skip를 사용하고 있습니다. 자세한 내용은 아래를 확인 부탁 드립니다. </p>
        <v-row justify="start" align="center">
            <v-col cols="3">
                <h1 style="font-size: 20px" class="pb-2 primary--text">1. 경매 등록</h1>
                <v-expansion-panels flat>
                    <v-expansion-panel>
                        <v-expansion-panel-header style="text-align:center">
                            구현 기능 보기
                        </v-expansion-panel-header>
                        <v-expansion-panel-content>
                            <v-card width="230" height="420">
                                <v-img
                                :src="require('@/assets/AucImg/insert.gif')"
                                max-height="420"
                                >
                                </v-img>    
                            </v-card>
                        </v-expansion-panel-content>
                    </v-expansion-panel>    
                </v-expansion-panels>   
            </v-col>
            <v-col cols="9">
                <v-row class="pa-0">
                    <v-col cols="6">
                        <p>프론트 소스</p>
                        <v-card width="1000" height="300">
                            <v-card-title  style="font-size: 15px" class="pb-0">1.FormaData</v-card-title>
                            <v-card-text class="black--text pb-0" >
                                    "for(let i=0; i< payload.files.length; i++){ <br>
                                        formData.append('img',payload.files[i])<br>
                                    }"<br>
                                <p style="font-size: 11px;"> 
                                ▶ key/value형식으로 데이터를 전송하기 위해 FormaData를 사용했습니다.
                                    FormData는 이미지 파일을 여러장 보낼때 수 있다는 장점이 있습니다.
                                    FormData로 값을 넘겨주면 서버에서 List형태로 받습니다. 
                                </p>     
                            </v-card-text>
                            <v-card-title  style="font-size: 15px" class="py-0">2.axios 통신</v-card-title>
                            <v-card-text class="black--text">
                                    axios<br>
                                    .post(state.http+'/api/auction' , formData, config)<br>
                                <p style="font-size: 11px;"> 
                                    ▶ 코드의 중복성을 줄이기 위해 state의 http변수에 "http://localhost:9200"을 저장했습니다.
                                </p>
                            </v-card-text>
                        </v-card>
                    </v-col >
                    <v-col cols="6">
                        <p>백엔드 소스</p>
                        <v-card width="1000" height="300">
                            <v-img
                            :src="require('@/assets/AucImg/insert_b.png')"
                            max-height="300"
                            >
                            </v-img>    
                        </v-card>

                    </v-col>
                </v-row>
    

            </v-col>
        </v-row>
    </v-app>
    
    
</template>
<script>
export default {
    data(){
        return{
            auc_img:[{name: '경매등록', img: 'insert.gif', content: '경매 등록 테이블인 "auction"에서 a_sale을 변경합니다. 처음 등록시 a_sale = 0이 됩니다.', front: 'insert_f.png', back: 'insert_b.png'}],
    
        }
        
        // {name: '경매 참여',img: 'bid.gif', content: '경매 등록 테이블인 "auction"에서 a_sale을 변경합니다. 처음 등록시 a_sale = 0이 됩니다.'}, 
        //     {name: '입찰 선정', img: 'select.gif', content: '경매 등록 테이블인 "auction"에서 a_sale을 변경합니다. 처음 등록시 a_sale = 0이 됩니다.'}, 
        //     {name: '결제', img: 'pay.gif', content: '경매 등록 테이블인 "auction"에서 a_sale을 변경합니다. 처음 등록시 a_sale = 0이 됩니다.'},
        //     {name: '스킵', img: 'skip.gif', content: '경매 등록 테이블인 "auction"에서 a_sale을 변경합니다. 처음 등록시 a_sale = 0이 됩니다.'}]        }
    }
    
}
</script>