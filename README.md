# leetcode-viewer

> 用无后台架构(backend-free)的Vue单页应用来分享、呈现你的leetcode解题源码吧!

[线上Demo在此](https://ma63d.github.io/#/source/1)

只需要几行命令就可以立马搭建出一个完整的leetcode解题源码单页应用,完全无需后台,上传至github pages或你自己的服务器,即可一秒完整呈现你的leetcode源码.

![](./doc/pic1.png)
![](./doc/pic2.png)

## 本项目需结合[leetcode-spider](https://github.com/Ma63d/leetcode-spider)使用

[leetcode-spider](https://github.com/Ma63d/leetcode-spider)是我用JS写的leetcode解题源码爬虫, 自动将你的leetcode解题源码爬取下来,生成本地代码、题目文件.并生成本项目运行时所需的部分JSON文件.

**所以使用前请先爬取你自己的leetcode源码**


## usage 使用方法

``` bash
# 先clone/fork本项目 然后进入本项目所在文件夹

git clone https://github.com/Ma63d/leetcode-spider.git 
cd leetcode-spider

#安装npm依赖

npm i

# 然后按照lc-spider的使用方法 先爬下来你的leetcode解题源码 详见[leetcode-spider](https://github.com/Ma63d/leetcode-spider)使用介绍

lc-spider

# 打包 生成应用

npm run build

# generate源码相关信息

npm run generate

# ok了 现在 这就是一个可以放在任何一个静态服务器上的单页应用了 你可以把他push 到github pages 或者放到你自己的服务器上

```


