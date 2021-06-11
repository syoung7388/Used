const VueLoaderPlugin = require('vue-loader/lib/plugin')
const path = require('path')
const { webpack } = require('webpack')
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin;
const HtmlWebpackPlugin = require('vue-html-webpack-plugin');
const loader = require('sass-loader');

module.exports = {
    mode: 'production',
    devtool: '#source-map',
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
                    name: 'vue_picture/[name].[ext]'

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
                    name: 'vue_picture/[name].[ext]'
                }
            },

            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/
                
                
            },
            // {
            //     test: /\.sass$/,
            //     use: [
            //         'vue-style-loader',
            //         'css-loader',

            //       ],

            // }

            {
                test: /\.s(c|a)ss$/,
                use: [
                    'vue-style-loader',
                    'css-loader',
                    {
                        loader: 'sass-loader',
                        options: {
                            implementation: require('sass'),
                            sassOptions:{
                                fiber: require('fibers'),
                                indentedSyntax: true
                            }
                
                        }
                    }

                ]
            }

        ]
    },
    plugins:[
        new VueLoaderPlugin(),
        new BundleAnalyzerPlugin(),
        new HtmlWebpackPlugin({
            vue:true
        })

        
    ],
    output:{
        path: path.join(__dirname, '/public'),
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

}