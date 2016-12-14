<template>
  <header class="top-nav-container">
    <nav class="top-nav">
      <a href="./" class="vertical-center nav-logo">
        <img src="../../assets/logo.png" class="logo vertical-center-content" alt="">
        <span class="brand vertical-center-content">Leetcode Solutions</span>
      </a>
      <ul class="nav-link-container">
        <li class="nav-link-item"><router-link class="nav-link" to="/cover">{{language === 'en' ? `Guide` : `介绍`}}</router-link></li>
        <li class="nav-link-item"><router-link class="nav-link" to="/source">{{language === 'en' ? `Source Code` : `源码`}}</router-link></li>
        <li class="nav-link-item" v-if="gitRepoUrl !== null"><a class="nav-link" target="_blank" :href="gitRepoUrl"><img src="../../assets/github.jpeg" class="github-logo">git repos</a></li>
      </ul>
    </nav>
  </header>
</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .top-nav-container
    position fixed
    width 100%
    top 0
    background #fff
    z-index 1
    box-shadow 0 0 4px rgba(0,0,0,0.25)
  .top-nav
    height $header-height
    padding $herder-padding-ver 100px $herder-padding-ver 60px
  .nav-logo
    display inline-block
    .logo
      margin-right 6px
  .logo
    width 40px
    height 40px
  .brand
    font-size 1.5em
    color $dark
    font-family $logo-font
    font-weight 500
  /**
    fixme! 留作以后的slogan样式
  */
  /*.slogan
    font-size 1.3em
    color $light
    font-family $logo-font
    font-weight 500*/
  .nav-link-container
    float right
    list-style-type none
    margin 0
    padding 0
  .nav-link-item
    display inline-block
    margin 0 .6em
  .nav-link
    height $header-height
    line-height $header-height
    text-decoration none
    color $medium
    padding-bottom 3px
    &:hover, &.router-link-active
      border-bottom 3px solid $green
  .github-logo
    width 30px
    vertical-align -3px
</style>
<script>
  export default{
    data () {
      return {
        gitRepoUrl: process.env.gitRepo,
        language: process.env.language
      }
    }
  }
</script>
