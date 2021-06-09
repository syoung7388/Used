export const checkImg = {
    methods:{
        getImg(link){
            try{
                return "/picture/"+link
            }catch{
                return "/picture/no.png"

            }
        }, 

        
    }
}
