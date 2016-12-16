module.exports = {
  sourcePath: './static/',
  // 这一项会用在网页的介绍页面上
  // 显示为 {{author}} 's Leetcode solutions
  // 如果你不想显示你的名字,就保持null, 介绍页面上会显示 My Leetcode solutions
  author: 'Chuck Liu',
  // 如果你的leetcode源码已经存放在github上,那么此处可以填写为具体的项目地址
  // 否则,请保持null
  gitRepo: 'https://github.com/Ma63d/leetcode',
  //网页的语言 zh 中文 en 英文
  language: 'en',
  //是否在build的时候开启gzip 对静态文件进行压缩
  //如果这个网页是放在github pages之类的静态文件托管服务器上的话 那你可以开启
  //如果你是放在自己的Nginx服务器下, 一般Nginx都会开启gzip 那此处也就不用开启gzip了
  gzip: false
}
