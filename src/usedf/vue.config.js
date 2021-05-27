const path= require('path')

module.exports = { 
  
  configureWebpack: {
    resolve: {
        alias: {
            '@': path.join(__dirname, 'src/')
        }
    }
  },

  outputDir: "../src/main/resources/static",  
  indexPath: "../static/index.html",  
  devServer: { 
    //proxy: "http://172.30.1.33:8080/"
    proxy:"http://192.168.50.124:8080"  
  },  
};