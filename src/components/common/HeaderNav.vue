<template>
  <header class="top-nav-container">
    <nav class="top-nav">
      <router-link class="vertical-center nav-logo" to="/source">
        <img src="../../assets/logo.png" class="logo vertical-center-content" alt="">
        <span class="brand vertical-center-content">Leetcode Solutions</span>
      </router-link>

      <ul class="nav-link-container">
        <li class="nav-link-item"><router-link class="nav-link" to="/cover">{{language === 'en' ? `Guide` : `介绍`}}</router-link></li>
        <li class="nav-link-item"><router-link class="nav-link" to="/source">{{language === 'en' ? `Source Code` : `源码`}}</router-link></li>
        <li class="nav-link-item" v-if="gitRepoUrl !== null"><a class="nav-link" target="_blank" :href="gitRepoUrl"><img src="../../assets/github.jpeg" class="github-logo">git repos</a></li>
      </ul>
      <img src="../../assets/menu.png" alt="" class="menu-button" @click="toggle">
      <div class="search-container top">
        <input type="text" class="search" v-model="keywords" @focus="focus" @blur="blur"  :class="[inputing?'active':'']" />
        <ul class="result-list" v-show="searchResult.length > 0 && inputing">
          <li class="result-item" v-for="result in searchResult">
            <router-link :to="'/source/'+result.id" >{{result.id}} . {{result.title}}</router-link>
          </li>
        </ul>
      </div>
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
    z-index 100
    box-shadow 0 0 4px rgba(0,0,0,0.25)
  .top-nav
    height $header-height
    padding $header-padding-vertical 100px $header-padding-vertical 60px
    @media screen and (max-width:840px)
      &
        padding $header-padding-vertical-small 1.4em $header-padding-vertical-small 1.4em
  .search-container
    float right
    position relative
    @media screen and (max-width:840px)
      &.top
        display none
    .search
      height 30px
      line-height 30px
      box-sizing border-box
      padding 0 15px 0 30px
      border 1px solid #e3e3e3
      color #2c3e50
      outline none
      border-radius 15px
      margin-right 10px
      margin-top 5px
      transition border-color 0.2s ease
      background #fff url(../../assets/search.png) 8px 5px no-repeat
      background-size 20px
      &.active
        border-color $green
    .result-list
      position absolute
      top 30px
      left 0
      list-style-type none
      background-color #fff
      border 1px solid #bbb
      border-radius 4px
      font-size 16px
      margin 10px 0 0
      padding 8px
      text-align left
    .result-item
      a
        color $medium
        &:hover
          color $green
    @media screen and (min-width: 720px)
      .top-nav
        .result-list
          width 300px
  .nav-logo
    display inline-block
    .logo
      margin-right 6px
    @media screen and (max-width: 840px)
      &
        margin-left 10px
  .logo
    width 40px
    height 40px
  .brand
    font-size 1.5em
    color $dark
    font-family $logo-font
    font-weight 500
  .menu-button
    float right
    width w = 24px
    height h = w
    margin-top (($header-height - h)/2)
    margin-right 10px
    @media screen and (min-width: 840px)
      &
        display none
  .nav-link-container
    float right
    list-style-type none
    margin 0
    padding 0
    @media screen and (max-width: 840px)
      &
        display none
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
  import _ from 'lodash'
  import state from '../../store/state'
  import eventHub from '../../store/event_hub.js'
  export default{
    data () {
      return {
        gitRepoUrl: process.env.gitRepo,
        language: process.env.language,
        inputing: false,
        searchResult: [],
        keywords: ''
      }
    },
    methods: {
      focus () {
        this.inputing = true
      },
      blur () {
        setTimeout(() => {
          this.inputing = false
        }, 200)
      },
      search: _.throttle(function () {
        if (state.resultJson === undefined) {
          return
        } else {
          if (Number(this.keywords) !== Number(this.keywords)) {
            this.searchResult = searchWithTitle(this.keywords, state.resultJson)
          } else {
            this.searchResult = searchWithNumber(Number(this.keywords), state.resultJson)
          }
        }
      }, 200),
      toggle () {
        eventHub.$emit('toggle')
      }
    },
    watch: {
      'keywords': function () {
        this.search()
      }
    }
  }
  function searchWithNumber (number, targetObj) {
    if (targetObj[number] !== undefined) {
      return [{id: targetObj[number].id, title: targetObj[number].title}]
    } else {
      return []
    }
  }
  function searchWithTitle (title, targetObj) {
    title = title.trim().toLowerCase().replace(/\s+/g, '-')
    let result = []
    for (let id in targetObj) {
      if (targetObj.hasOwnProperty(id)) {
        if (~targetObj[id].title.indexOf(title)) {
          result.push({id: targetObj[id].id, title: targetObj[id].title.replace(/-/g, ' ')})
          //only show 5 results
          if (result.length > 4) {
            return result
          }
        }
      }
    }
    return result
  }
</script>
