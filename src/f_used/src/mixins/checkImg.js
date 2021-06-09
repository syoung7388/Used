export const checkImg = {
    methods:{
        getImg(link){
            console.log(link)
            try{
                var re_link = require(`../../../asset/${link}`) + "?"+new Date.getTime()
                console.log(re_link)
                return re_link
            }catch{
                return require("../../../asset/no.png")
            }
        }, 

        
    }
}
