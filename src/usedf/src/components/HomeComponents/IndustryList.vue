<template>
    <v-app>
        <v-container> 
        
 
            <v-card 
            v-for="(list, index) in industries"
            :key="index"
            max-width="100"
            >
            
           
               
                    <v-img
                    :src="require('@/IndustryImg/'+index+'.jpg')"
                    max-width="80"
                    max-height="80"
                    ></v-img>
                    <v-card-text v-html="list"></v-card-text>
            </v-card>
  
        
          
        
        </v-container>
    </v-app>
</template>
<script>
export default {
    data(){
        return{
            industries: ['한식', '찜/탕','면요리','고기/구이','족발/ 보쌈','치킨','분식','중식','동남아식','회/초밥','일식/돈까스','피자/샐러드','호프/술집','카페/베이커리','배달전문점'],
        }
    }    
}
</script>