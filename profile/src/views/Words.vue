<template>
  <v-app>
    <h1 style="font-size: 30px; text-align:center" class="grey--text mt-15">기술언어</h1>
    <v-row  align="start" justify="center" class="mt-15" >
      <v-cols cols="5" v-for="(item, index) in words_list" :key="index" class="px-10">
        <v-card width="150" height="200">
          <v-img
            :src="require('@/assets/WordsImg/'+item.img)"
            style="text-align: center"
          >
          </v-img>
          <v-card-text>
            <h1 style="font-size: 20px; text-align:center">{{item.name}}</h1>
          </v-card-text>
        </v-card>
      </v-cols>
    </v-row>
  </v-app>
</template>
<script>
export default {
  data(){
    return{
      words_list: [
        {name: "Java",img: "java.png"}, {name: "Vue",img: "vue.png"}, {name: "JavaScript",img: "javascript.png"}, {name: 'Spring', img:'spring.jpg'}, {name: 'MySql', img:'mysql.png'}
      ]
    }
  }
}
</script>

