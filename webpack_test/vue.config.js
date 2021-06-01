
const path= require('path');
const { webpack } = require('webpack');


module.exports = {
  outputDir: path.resolve(__dirname, '../src/main/resources/static'),

  devServer: { 
    port: 9200,
    proxy: 'http://192.168.1.46:9200'
  },
  transpileDependencies: [
    'vuetify'
  ],




  

};
