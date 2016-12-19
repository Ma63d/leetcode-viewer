<template>
  <article class="posts duoshuo" id="duoshuo-comment" v-ds="{id: articleId, title: articleTitle, postId: postId}" v-if="scriptLoaded">
  </article>
</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .duoshuo
    #ds-thread #ds-reset li.ds-tab a:hover
      background-color: white;

    #ds-thread #ds-reset li.ds-tab a.ds-current
      border: 1px solid transparent;
      background-color: white;

    #ds-reset .ds-highlight
      color: $green !important
    #ds-thread #ds-reset .ds-sort a.ds-current, #ds-thread #ds-reset .ds-sort a:active
      color: $green !important
    #ds-thread #ds-reset .ds-sort a
      color $light
      &:hover
        color: #333
    #ds-thread #ds-reset .ds-comment-actions a
      color $light
      &:hover
        color: #333
    #ds-thread #ds-reset .ds-textarea-wrapper
      background #fff
    #ds-reset .ds-gradient-bg
      background #fff
    #ds-thread #ds-reset .ds-post-options
      border-bottom-color: #ccc;
    #ds-thread #ds-reset .ds-post-button
      background-color #fff
      background-image none
      border-bottom-color: #ccc;
    #ds-reset
      img
        max-width 50px
    #ds-thread #ds-reset #ds-bubble a
      color: $green
    #ds-thread #ds-reset .ds-comment-body a:hover
      color: #555;
    #ds-thread #ds-reset a.ds-comment-context
      color $green
    #ds-reset #ds-ctx .ds-ctx-entry .ds-ctx-head a
      color: $green
      &:hover
        color: #555
</style>
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
      console.log(process.env.duoShuoShortName)
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
