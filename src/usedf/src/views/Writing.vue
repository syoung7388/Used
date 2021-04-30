
<template>
    <v-app>
        <v-container class="pa-5" v-show=" Writingshow=== true">
            <div v-show="WritingError === true">
                <h1 class="red--text" style="font-size: 15px;">
                    입력하신걸 확인해 주세요!
                </h1>
            </div>
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
                        v-model="kind"
                        :items="kinds"
                        single-line
                        dense
                    ></v-select>
                </v-col>
            </v-row>
            <v-row>
                <v-col
                class="py-0"
                
                cols="3">
                    <h1 style="font-size: 15px">제목</h1>
                
                </v-col>
                <v-col
                cols="9"
                 class="py-0"
                >
                    <v-text-field
                    v-model="title"
                    outlined
                    rows="1"
                    dense
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">내용</h1>
                </v-col>
                <v-col
                cols="9"
                class="py-0" 
                >           
                    <v-textarea
                    v-model="content"
                    outlined
                    rows="2"
                        
                    >
                    </v-textarea>
                </v-col>          
                <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">브랜드</h1>               
                </v-col>
                <v-col
                cols="9"
                class="py-0" 
                >
                    <v-text-field
                    v-model="brand"
                    outlined
                    rows="1"
                    dense
                    height="2"
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row>
                <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">연식</h1>
                </v-col>
                <v-col
                cols="5"
                class="py-0"  
                >
                    <v-select       
                    :items="yearOptions"
                    single-line
                    dense
                    class="mt-0"
                    v-model="year"
                    ></v-select>
                </v-col>          
            </v-row>
            <v-row >
                <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">시작가격</h1>               
                </v-col>
                <v-col
                cols="9"
                class="py-0"
                >
                    <v-text-field
                    v-model="startprice"
                    outlined
                    rows="1"
                    dense
                    height="2"
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row >
                <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">주소</h1>               
                </v-col>
                <v-col
                cols="9"
                class="py-0"
                >
                    <v-text-field
                    v-model="address"
                    outlined
                    rows="1"
                    dense
                    height="2"
                    @click="Address"
                    ></v-text-field><!--  -->
                </v-col>
            </v-row>
            <v-row>
                 <v-col
                cols="3"
                class="py-0" 
                >
                    <h1 style="font-size: 15px">마감기한</h1>               
                </v-col>
                
                <v-col cols="7"  class="py-0">
                    <v-select
                    :items="item"
                    label="최대 10일"
                    v-model="day"
                    dense
                     class="mt-0"
                    ></v-select>
                
                </v-col> 

            </v-row >

            <h1 class="primary--text my-5" style="font-size: 16px;" >사진 등록은 필수입니다!</h1>
            <v-row align="center">
                <v-col
                cols="3"
                >
                    <input ref="imageInput" type="file"  @change="ChangeImages" hidden >
                    <v-btn
                    @click="ClickImageUpload"
                    icon
                    color="grey"
                    >
                        <i class="far fa-plus-square" style="font-size: 30px;"></i>
                    </v-btn>
                </v-col>
                    <v-col
                    cols="3" 
                    v-for="(list, idx) in showImage"
                    :key="idx"
                    >               
                        <v-img 
                        v-if="showImage" 
                        :src="list.image"
                        max-height="60"
                        max-width="60"
                        ></v-img>  

                    </v-col>         
            </v-row>
             <v-btn  
            class="primary mt-5"
            block
            @click="Writing({
                
                title,
                content,
                industry,
                kind ,
                brand,
                year,
                startprice,
                files,
                address,
                day,
                town

            })"
            >다음</v-btn>
            <v-virtual-scroll
            height="300"
            item-height="20"
            ></v-virtual-scroll>     
        </v-container>
        <div v-show=" Writingshow=== false" >
            <WAddress  @Addr ="result_Addr" ></WAddress> 
        </div>
    </v-app>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import  WAddress from '@/components/WritingComponent/WAddress.vue'
export default{
    data() {
        
        return {

            industry: null,
            kind: null,
            title: null,
            content: null,
            brand: null,
            year: null,
            startprice: null,
            username: null,
            file: null,
            address: null,
            town: null,
            showImage:[],
            files:[],


            writingInfo:{},
            day: null,
            Writingshow: true,



            yearOptions:[], 
            select: null,
            industries: ['한식', '찜/탕','면요리','고기/구이','족발/ 보쌈','치킨','분식','중식','동남아식','회/초밥','일식/돈까스','피자/샐러드','호프/술집','카페/베이커리','배달전문점'],
            kinds: ['작업대','커피머신','그릴기','냉동 절육기','제빙기','오븐기','튀김기','기름 정제기','씽크대','소독기','가스렌지','냉장고/쇼케이스','보온통','에어컨','회전국솥','절단기','벽선단','기타'],
            item: [1,2, 3, 4, 5, 6, 7, 8, 9, 10],

            date: new Date().toISOString().substr(0, 10),
            menu: false,
            modal2: false,
            time : null
        

        }

    },
    mounted() {
        // 연도 선택 옵션 리스트 설정
        let year = new Date().getFullYear();
        for (let i = 1970; i <= year; i++) {
        this.yearOptions.push(i);
        
    
        }





    },

    methods: {
        ClickImageUpload(){
            this.$refs.imageInput.click();     
        },
        
            
        ChangeImages(i){ 
            
            const file = i.target.files[0]
            this.files.push(file)
            console.info(this.files)
            let image = URL.createObjectURL(file)
            this.showImage.push({image})
        },
 
        result_Addr(payload){
            console.log(payload)
            this.Writingshow= true  
            this.address =payload.fulladdress
            this.town = payload.town
      
        },
        Address(){
            this.Writingshow= false
            
        },
    

        ...mapActions(['Writing']),


    },
    computed: {
        ...mapState(['userInfo','ImageList', 'WritingError'])
    },
    created(){
        this.username= this.userInfo.username
    
      
    },
    components: {
        WAddress
    }
    
    

}

</script>