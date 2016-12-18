<template>
  <article class="posts" id="duoshuo-comment" v-ds="{id: articleId, title: articleTitle, postId: postId}" v-if="scriptLoaded">
  </article>
</template>

<script>
  import duoShuoDirective from '../../directives/duo_shuo'
  // this component is a wrapper of DuoShuo,which is a comment plugin
  export default {
    data () {
      return {
        scriptLoaded: false
      }
    },
    mounted () {
      window.duoshuoQuery = {short_name: process.env.duoShuoShortName}
      var ds = document.createElement('script')
      ds.type = 'text/javascript'
      ds.async = true
      ds.src = (document.location.protocol === 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.js'
      ds.charset = 'UTF-8'
      ds.onload = () => {
        this.scriptLoaded = true
      }
      ;(document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(ds)
    },
    props: {
      articleId: {
        type: String
      },
      articleTitle: {
        type: String
      },
      postId: {
        type: String
      }
    },
    directives: {
      ds: duoShuoDirective
    }
  }
</script>
