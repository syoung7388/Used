
const path= require('path');
const { webpack } = require('webpack');


module.exports = {
  outputDir: path.resolve(__dirname, 'public'),
  indexPath: "../static/index.html",

  devServer: { 
    port: 8080,
    proxy: 'http://192.168.1.46:9200'
    // proxy:'http://172.30.1.12:9200'
    // proxy: "http://172.30.1.60:9200"
    //proxy:"http://192.168.50.124:9200"  
  },
  transpileDependencies: [
    'vuetify'
  ],


  

};
