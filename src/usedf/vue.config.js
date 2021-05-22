module.exports = {  
  outputDir: "../src/main/resources/static",  
  indexPath: "../static/index.html",  
  devServer: {  
    proxy: "http://172.30.1.55:8080"  
  },  
};