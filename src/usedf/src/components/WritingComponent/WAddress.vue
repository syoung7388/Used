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
            address: {},
            title: null,
            data:[],

         

        }
    },

    mounted(){
        const script = document.createElement('script')
        script.src = "https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"
        document.head.appendChild(script)

        
        script.onload = function(){
            
            var PostcodContainer = document.getElementById('daum_postcode')
            new daum.Postcode({

            oncomplete: function (e){
                console.log(e)
                alert("handle")
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

                    console.log(fullAddress)


                    localStorage.setItem('addr', fullAddress)
                    
                    
                
                    fullAddress= ''
                    extraAddress= ''

                    
                    if(e.address !== ''){

                        var geocoder = new kakao.maps.services.Geocoder()// 문제 
                        geocoder.addressSearch(e.address, function(result, status){
                        if(status === kakao.maps.services.Status.OK){


                            console(result)
                    
                            localStorage.setItem('lat', result[0].y)
                            localStorage.setItem('lon', result[0].x) 
                            
                            // console.log(coords)
                            //console.log(localStorage.getItem('lon'))
                            // console.log(localStorage.getItem('lat'))
                
                            }

                        })

                    }
                 }


                document.body.scrollTop = currentScroll;


            },

            onresize : function(size) {
            PostcodContainer.style.height = 700+'px';
            PostcodContainer.style.width = 400+'px';
            },

            
            
        }).embed(PostcodContainer)

        }
        

        
    },

    
}
</script>