const VueLoaderPlugin = require('vue-loader/lib/plugin')
const path = require('path')

module.exports = {
    mode: 'production',
    devtool: 'eval',
    resolve: {
        modules: ['node_modules'],
        extensions: ['.js', '.vue', '.json'],
        alias:{
            '@':path.join(__dirname,'src'),
            'vue$': 'vue/dist/vue.esm.js'
        }
    },
    entry:{
        app: path.join(__dirname, 'src/main.js')


    },
    module: {
        rules: [

            {
                test: /\.(png|jpg|gif|svg)$/,
                loader: 'file-loader',
                options: {
                    name: 'assets/[contenthash].[ext]'

                }
 
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader'
            },
            {
                test: /\.css$/,
                loader: 'css-loader'
            },

            {
                test: /\.(jp(e*)g)$/,
                loader: 'url-loader',
                options: { 
                    name: 'assets/[contenthash].[ext]'
                }
            },
            {
                test: /\.sass$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    {
                      loader: 'sass-loader',
                      // Requires >= sass-loader@^9.0.0
                      options: {
                        // This is the path to your variables
                        additionalData: "@import '@/styles/variables.scss'"
                      },
                    },
                  ],

            }

        ]
    },
    plugins:[
        new VueLoaderPlugin()
    ],
    output:{
        filename: 'bal.js',
        path: path.join(__dirname, 'public/js'),
        publicPath: './public',
        filename:'[name].js'
    },

    optimization: {
        splitChunks: {
          chunks: 'all'
        }
    }

}