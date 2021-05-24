module.exports = {  
  outputDir: "../src/main/resources/static",  
  indexPath: "../static/index.html",  
  devServer: { 
    proxy: "http://192.168.50.124:8080"  
  },  
};