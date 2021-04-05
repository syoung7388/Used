<template>
    <v-app>
        <v-container class="pa-5">
            <v-row justify="start">
                <v-col 
                cols="5"
                sm="6"
                class="d-flex"
                >
                    <v-select
                        v-model="industry"
                        :items="industries"
                        single-line
                        dense
                    ></v-select>
                </v-col>
                <v-col
                cols="5"
                sm="6"
                class="d-flex"
            
                >
                    <v-select
                        v-model="device"
                        :items="devices"
                        single-line
                        dense
                    ></v-select>
                </v-col>
            </v-row>
            <v-row>
                <v-col
                
                cols="2">
                    <h1 style="font-size: 15px">제목</h1>
                
                </v-col>
                <v-col
                cols="10"
                >
                    <v-text-field
                        outlined
                        rows="1"
                        dense
                        ></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col
                cols="2"
                >
                    <h1 style="font-size: 15px">내용</h1>
                </v-col>
                <v-col
                cols="10" 
                >           
                    <v-textarea
                    outlined
                    auto-grow
                    value= "고객님 자세한 설명은 빠른 판매에 도움이 됩니다."                  
                    >
                    </v-textarea>
                </v-col>          
            </v-row> 
            <v-row>
                <v-col
                cols="2"
                >
                    <h1 style="font-size: 15px">연식</h1>
                </v-col>
                <v-col
                cols="10" 
                >
                    <v-date-picker
                       v-model="date"
                       type="year"
                       lang="en"
                       format="yyyy"

                    ></v-date-picker>


                </v-col>          
            </v-row>
        </v-container>
    </v-app>


</template>

<script>
import Datepicker from 'vue2-datepicker'
export default{
    data() {
        
        return {
            date:'',
            select: null,
            device: null,
            industry: null,
            industries: [
                '한식', 
                '찜/탕',
                '면요리',
                '고기/구이',
                '족발/ 보쌈',
                '치킨',
                '분식',
                '중식',
                '동남아식',
                '회/초밥',
                '일식/돈까스',
                '피자/샐러드',
                '호프/술집',
                '카페/베이커리',
                '배달전문점'

            ],

            devices: [
                '작업대',
                '커피머신',
                '그릴기',
                '냉동 절육기',
                '제빙기',
                '오븐기',
                '튀김기',
                '기름 정제기',
                '씽크대',
                '소독기',
                '가스렌지',
                '냉장고/쇼케이스',
                '보온통',
                '에어컨',
                '회전국솥',
                '절단기',
                '벽선단',
                '기타'
            ],
//////////////////////////////////////////////////////////////////제품 선택 내생각엔 따로 빼는것도 좋은 방법인듯
        

        }

    },
    components: {
        Datepicker
    }
    

}

</script>