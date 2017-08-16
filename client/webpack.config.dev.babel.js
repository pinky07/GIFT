import webpack from 'webpack';
import path from 'path';
import HtmlWebpackPlugin from 'html-webpack-plugin';

export default {
  devtool: "#source-map",
  bail: true,
  entry: [
    path.resolve(__dirname, 'src/index')
  ],
  target: 'web',
  output: {
    path: path.join(__dirname, '../server/src/main/resources/static'),
    publicPath: '',
    filename: 'bundle.js'
  },
  devServer: {
    contentBase: path.resolve(__dirname, 'src')
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({
      debug: true
    }),
    new HtmlWebpackPlugin({
      hash: true,
      filename: 'index.html',
      template: path.resolve(__dirname, 'src/index.html')
    }),
    new webpack.NoEmitOnErrorsPlugin()
  ],
  module: {
    rules: [
      {
        use: ['react-hot-loader', 'babel-loader'],
        test: /\.(jsx|js)$/,
        exclude: /node_modules/
      },
      {
        use: ['style-loader', 'css-loader'],
        test: /\.css$/
      },
      {
        use: ['style-loader', 'css-loader', 'sass-loader'],
        test: /\.scss$/
      },
      {
        loader: 'url-loader',
        test: /\.svg$/,
        options: { limit: 65000, mimetype: 'image/svg+xml', name: 'public/fonts/[name].[ext]' }
      },
      {
        loader: 'url-loader',
        test: /\.woff$/,
        options: { limit: 65000, mimetype: 'application/font-woff', name: 'public/fonts/[name].[ext]' }

      },
      {
        loader: 'url-loader',
        test: /\.woff2$/,
        options: { limit: 65000, mimetype: 'application/font-woff2', name: 'public/fonts/[name].[ext]' }
      },
      {
        loader: 'url-loader',
        test: /\.[ot]tf$/,
        options: { limit: 65000, mimetype: 'application/octet-stream', name: 'public/fonts/[name].[ext]' }
      },
      {
        loader: 'url-loader',
        test: /\.eot$/,
        options: { limit: 65000, mimetype: 'application/vnd.ms-fontobject', name: 'public/fonts/[name].[ext]' }
      }
    ]
  }
};