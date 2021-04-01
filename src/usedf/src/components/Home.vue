<template>
    <v-app>

        <v-card>
            <v-app-bar
                color="white"
                flat
                absolute
            >

                <v-btn icon>
                    <i class="fas fa-map-marker-alt" style="font-size: large;"></i>            
                </v-btn>
                <span style= "font-size:12px">대구 신천동</span>

                <v-spacer></v-spacer>

                <v-btn icon>
                    <i class="far fa-heart" style="font-size: large;"></i>            
                </v-btn>
                <v-btn icon>
                    <i class="far fa-bell" style="font-size: large;"></i>            
                </v-btn>
                <v-btn icon>
                    <i class="far fa-user" style="font-size: large;"></i>            
                </v-btn>
                <template v-slot:extension>
                    <v-tabs
                        align-with-title
                        fixed-tabs   
                    >
                        
                        <v-tabs-slider color="blue" style=" display: inline-block;"></v-tabs-slider>
                            <v-tab>인기매물</v-tab>
                            <v-tab>카테고리</v-tab>
                                            
                    </v-tabs>
                </template>
            </v-app-bar>
        </v-card>


        <v-bottom-navigation
            absolute
            color="primary"
            grow
            height="70"
            :value="value"
        >
            <v-btn>
                <span style="opacity:0.5 font-weight:500;">홈</span>
                <i class="fas fa-home mb-2"  style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn>
            <span  style="opacity:0.5 font-weight:500;"> 글쓰기</span>
            <i class="far fa-edit mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>

            <v-btn>
            <span style="opacity:0.5 font-weight:500;" >판매 리스트</span>
            <i class="fas fa-file-invoice-dollar mb-2" style="font-size: x-large; opacity:0.5;" ></i>
            </v-btn>

            <v-btn>
                <span style="opacity:0.5 font-weight:500;">구매 리스트</span>
                <i class="fas fa-shopping-cart mb-2" style="font-size: x-large; opacity:0.5;"></i>
            </v-btn>
        </v-bottom-navigation>
    </v-app>
</template>
<script>
  export default {
    data() {
        return{
            
            value: 1,

        }
        
    }
  }
</script>

