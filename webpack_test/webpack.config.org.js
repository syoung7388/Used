const VueLoaderPlugin = require('vue-loader/lib/plugin')
const path = require('path')

module.exports = {
    mode: 'production',
    devtool: 'hidden-source-map',
    resolve: {
        extensions: ['*', '.js', '.vue', '.json'],
        alias: {
            '@': path.join(__dirname, 'src'),
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
                loader:'file-loader',
                options: {
                    name: 'assets/[name].[ext]?[hash]'
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
                    name: 'assets/[name].[ext]?[hash]'
                }
            }
        ]
    },
    plugins:[
        new VueLoaderPlugin()
    ],
    output:{
        path: path.join(__dirname, './dist'),
        filename: '[name].js',
    
    }
}