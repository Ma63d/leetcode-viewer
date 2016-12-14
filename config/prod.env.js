var buildConf = require('../build.conf')
var merge = require('webpack-merge')

module.exports = merge(quotesWrap(buildConf), {
  NODE_ENV: '"production"'
})

//在使用webpack.DefinePlugin时候,真正注入代码当中的是字符串里的内容
//例如 '"production"' 注入的是 "production"
//所以需要用如下函数先将注入内容包装好
function quotesWrap(obj){
  Object.keys(obj).forEach(prop => {
    if(typeof obj[prop] === 'string') obj[prop] = `'${obj[prop]}'`
  })
  return obj
}
