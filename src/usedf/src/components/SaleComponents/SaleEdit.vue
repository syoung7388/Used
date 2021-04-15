<template>
    <v-app>
        <v-container class="pa-3" v-show="address_show === false">
            <!-- <div >
                <h1 class="red--text" style="font-size: 15px;">
                    입력하신걸 확인해 주세요!
                </h1>
            </div> -->
            <v-row justify="start">
                <v-col 
                cols="5"
                sm="6"
                class="d-flex"
                >
                    <v-select
                        v-model="productInfo.industry"
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
                        v-model="productInfo.kind"
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
                    v-model="productInfo.title"
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
                    v-model="productInfo.content"
                    outlined
                    rows="2"
                    >
                    </v-textarea>
                </v-col>          
            </v-row> 

            <v-row >
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
                    v-model="productInfo.brand"
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
                    v-model="productInfo.year"
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
                    v-model="productInfo.startprice"
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
                    v-model="productInfo.address"
                    outlined
                    rows="1"
                    dense
                    height="2"
                    @click="PAddress"
                    ></v-text-field>
                </v-col>
            </v-row>
            <h1 class="primary--text my-3" style="font-size: 15px;" >사진 등록은 필수입니다!</h1>
            <v-row align="center" class="pt-3">
                <v-col
                cols="2"
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
                v-for="(list, idx) in beforeImage"
                :key="idx"
                >   
                    <v-card
                    flat
                    >             
                        <v-img 
                        :src="require('@/assets/'+list.pictureName)"
                        max-height="60"
                        max-width="60"
                        >
                        </v-img>
                
                        <v-btn
                        absolute
                        fab
                        x-small
                        left
                        top
                        class="ml-7"
                        icon
                        @click="Beforedelete({idx})"
                        ><i class="far fa-times-circle" style="font-size: large"></i></v-btn>
                        </v-card>
                    </v-col> <!--여기까지 원래 이미지 수정삭제 하는곳 beforeImage -->

                    <v-col  v-for="(a,i) in showImage" :key="a.image" >
                    <v-card
                    flat
                    :key="i"
                    > 
                    
                        <v-img   
                        max-height="60"
                        max-width="60"
                        :src="a.image"
                        >
                        </v-img>
                        <v-btn
                        absolute
                        fab
                        x-small
                        left
                        top
                        class="ml-7"
                        icon
                        @click="Nowdelete({i})"
                        ><i class="far fa-times-circle" style="font-size: large"></i></v-btn>            
                    </v-card>
                    </v-col>             
            </v-row>
            <v-btn  
            class="primary mt-8"
            block
            @click="SaleEditOK({
                industry: productInfo.industry,
                kind: productInfo.kind,
                title: productInfo.title,
                brand: productInfo.brand,
                year: productInfo.year,
                startprice: productInfo.startprice,
                address: productInfo.address,
                picture: files


            })"
            >확인</v-btn>
        </v-container>
        <v-container v-show="address_show === true"> 
            <SaleAddress @Address="ResultAddress"></SaleAddress>
        </v-container>
    </v-app>
    
</template>
<script>
import { mapActions, mapState } from 'vuex';
import SaleAddress from '../SaleComponents/SaleAddress.vue';
export default{
  components: { SaleAddress },
    data() {
        
        return {

            industry:null,
            kind: null,
            title: null,
            content: null,
            brand: null,
            year: null,
            startprice: null,
            username: null,
            
            showImage:[],// 일단 보여주기식 이미지
            files: [], //신규파일전체
          
            writingInfo:{},


            yearOptions:[], 
            select: null,
            industries: ['한식', '찜/탕','면요리','고기/구이','족발/ 보쌈','치킨','분식','중식','동남아식','회/초밥','일식/돈까스','피자/샐러드','호프/술집','카페/베이커리','배달전문점'],
            kinds: ['작업대','커피머신','그릴기','냉동 절육기','제빙기','오븐기','튀김기','기름 정제기','씽크대','소독기','가스렌지','냉장고/쇼케이스','보온통','에어컨','회전국솥','절단기','벽선단','기타'],




        }

    },
    mounted() {
       
        




        // 연도 선택 옵션 리스트 설정
        let year = new Date().getFullYear();
        for (let i = 1970; i <= year; i++) {
        this.yearOptions.push(i);        
        }
       
    },
///////////////////////////////////////////////////////////연도 선택
    methods: {
        ClickImageUpload(){
            this.$refs.imageInput.click();     
        },
        
            
        ChangeImages(i){ 
            
            const file = i.target.files[0]
            this.files.push(file)

            let image = URL.createObjectURL(file)

            
            this.showImage.push({image: image})
         
        },
        Beforedelete(idx){
            console.log(idx)
            this.beforeImage.splice(idx, 1)
            //console.log(this.beforeImage)
        },
        Nowdelete(i){
            this.files.splice(i, 1)    
            this.showImage.splice(i, 1)
            //console.log( this.showImage)
            //console.log(this.files)
        },
        PAddress(){
            this.$store.state.address_show= true
        },
        ResultAddress(address){

            this.$store.state.address_show= false
            this.$store.state.productInfo.address = address

        },
        ...mapActions(['SaleEditOK'])
        
       
    },
    computed: {
        ...mapState({productInfo:'productInfo', beforeImage: 'beforeImage', address_show: 'address_show'})
    },
    created(){
    }
}
</script>