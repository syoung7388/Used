<template>
<v-app>
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
 </v-app>
</template>

<script>
export default {
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

            // URL.revokeObjectURL(image)

 

        },
      }
}
</script>