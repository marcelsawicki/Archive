var path = require("path");
var webpack = require("webpack");
var HtmlWebpackPlugin = require('html-webpack-plugin');

var basePath = __dirname;

module.exports = {
  module: {
    rules: [
      {
        test: /\.(ts)$/,
        exclude: /node_modules/,
        use: [{
          loader: 'ts-loader'
        }]
      }
    ]
  },

  resolve: {
    extensions: ['.js', '.ts']
  },
  entry: {
    app: "./main.ts"
  },
  output: {
  path: path.join(basePath, "dist"),
    filename: "bundle.js"
  },
  devtool: 'source-map',

plugins:[
    //Generate index.html in /dist => https://github.com/ampedandwired/html-webpack-plugin
    new HtmlWebpackPlugin({
      filename: 'index.html', //Name of file in ./dist/
      template: 'index.html', //Name of template in ./src
      hash: true
    })
  ]
}