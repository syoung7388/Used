<template>
<v-app class="pl-1">
    <div id="daum_postcode"  style="position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;"></div>


</v-app>
</template>


<script>
export default {


    data(){
        return{
            fullAddress: null,
            extraAddress: '',
            bname: null,
            buildingName: null,
            address: null,
            title: null,
            data:[],
            town: null

         

        }
    },

    mounted(){
        const script = document.createElement('script')
        script.src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
        document.head.appendChild(script)


        
        script.onload = ()=>{
            
            var PostcodContainer = document.getElementById('daum_postcode')
            new daum.Postcode({

            oncomplete: (e)=>{
                //console.log(e)
            
                var fullAddress = e.address
                var extraAddress = ''

                //console.log(this.fullAddress)
                if (e.addressType === 'R') {
                    if (e.bname !== '') {
                        extraAddress += e.bname
                    }
                    if (e.buildingName !== '') {
                        extraAddress += (extraAddress !== '' ? `, ${e.buildingName}` : e.buildingName)
                    }
                    fullAddress += (extraAddress !== '' ? ` (${extraAddress})` : '')

                    //console.log(fullAddress)
                    var town = null
                    if(e.bname === ''){
                        town = e.bname1
                    }else{
                        town = e.bname
                    }

                    
                    this.$emit('Addr', {fulladdress: fullAddress})

                    
                
                    fullAddress= ''
                    extraAddress= ''
                }

                },
                onresize:(size)=>{
                    PostcodContainer.style.height = 800+'px'
                    PostcodContainer.style.width = 400+'px'
                },
                width: '100%',
                height: '100%'
            }).embed(PostcodContainer)
        }



        
    },


    
}
</script>