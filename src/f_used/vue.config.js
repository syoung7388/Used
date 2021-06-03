
const path= require('path')

module.exports = {
  outputDir: path.resolve(__dirname, 'public'),
  indexPath: "../static/index.html",

  devServer: { 
    port: 8080,
    proxy: 'http://localhost:9200'

  },


  transpileDependencies: [
    'vuetify'
  ]
};
