
const path= require('path')

module.exports = {
  outputDir: path.resolve(__dirname, 'public'),
  indexPath: "../static/index.html",

  devServer: {
    port: 80,
    proxy:'http://15.164.78.95:9200',
    

  },


  transpileDependencies: [
    'vuetify'
  ]
};
