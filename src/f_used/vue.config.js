
const path= require('path')

module.exports = {
  outputDir: path.resolve(__dirname, 'public'),
  indexPath: "../public/index.html",

  devServer: {
    port: 80,
    //proxy:'http://15.164.78.95:9200',
    proxy:'http://3.34.22.100:9200',

  },


  // transpileDependencies: [
  //   'vuetify'
  // ]
};
