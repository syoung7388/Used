const VueLoaderPlugin = require('vue-loader/lib/plugin')
const path = require('path')
const { webpack } = require('webpack')
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;

module.exports = {
    mode: 'production',
    devtool: 'eval',
    resolve: {
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
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/
                
                
            },
            {
                test: /\.sass$/,
                use: [
                    'vue-style-loader',
                    'css-loader',

                  ],

            }

        ]
    },
    plugins:[
        new VueLoaderPlugin(),
        new BundleAnalyzerPlugin()

        
    ],
    output:{
        path: path.join(__dirname, 'dist'),
        filename:'app.js'
    },

    devServer: {
        historyApiFallback: true,
        noInfo: true,
        overlay: true
    },
    performance: {
        hints: false,
        maxEntrypointSize: 512000,
        maxAssetSize: 512000
    }

    // optimization: {
    //     splitChunks:{
    //         commons: {
    //             test: /[\\/]view[\\/]/,
    //             name: 'vendors',
    //             chunks: 'all'
    //         }
    //     }
    // }

}