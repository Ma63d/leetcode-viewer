<template>
  <div>
    <aside class="sidebar" :class="{show:asideShow}">
      <nav>
        <div class="search-container">
          <input type="text" class="search" v-model="keywords" @focus="focus" @blur="blur"  :class="[inputing?'active':'']" />
          <ul class="no-list-style" v-show="searchResult.length > 0 && inputing">
            <li class="result-item" v-for="result in searchResult">
              <router-link :to="'/source/'+result.id" >{{result.id}} . {{result.title}}</router-link>
            </li>
          </ul>
        </div>
        <ul class="nav-link-container">
          <li class="nav-link-item"><router-link class="nav-link" to="/cover">{{language === 'en' ? `Guide` : `介绍`}}</router-link></li>
          <li class="nav-link-item"><router-link class="nav-link" to="/source">{{language === 'en' ? `Source Code` : `源码`}}</router-link></li>
          <li class="nav-link-item" v-if="gitRepoUrl !== null"><a class="nav-link" target="_blank" :href="gitRepoUrl"><img src="../../assets/github.jpeg" class="github-logo">git repos</a></li>
        </ul>
        <ul class="question-links-container">
          <li class="question-link" v-for="(value, key) in problems"><router-link :to="'/source/'+key" exact>{{key}}.{{problems[key]['title']}}</router-link></li>
        </ul>
      </nav>
    </aside>
    <div class="mask" @click="asideShow = false">
    </div>
  </div>


</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .no-list-style
    list-style none
    padding 0
  .sidebar
    text-align left
    position fixed
    left 0
    top $header-total-height
    bottom 0
    z-index 10
    padding 2em 0 50px 65px
    width 260px
    margin-right 20px
    overflow-x hidden
    overflow-y auto
    .search-container
      display none
    .nav-link-container
      display none
    @media screen and (max-width: 840px)
      &
        left auto
        right -270px
        margin-right 0
        padding 10px 30px 20px
        background $grey
        top $header-total-height-small - 1px
        bottom 0
        width 200px
        box-shadow 0 0 4px rgba(0,0,0,0.25)
        transition right 0.3s ease
        .search-container
          display block
          float none
        .nav-link-container
          display block
          float none
          .nav-link-item
            display block
            margin 0
            line-height 30px
            a
              &:hover, &.router-link-active
                border-bottom 2px solid $green
      &.show
        right 0
      .question-links-container
        list-style-type none
        margin 0
        line-height 1.8em
        padding-left 1em
        .question-link
          line-height 1em
          font-size 14px
          padding-bottom 1px
          width 200px
          overflow hidden
          text-overflow ellipsis
          white-space nowrap
          &:hover, &.router-link-active
            border-bottom 2px solid $green
    .question-links-container
      padding-left 0
      margin 0
      .question-link
        list-style-type none
        line-height 1.8em
        a
          color $light
          &:hover, &.router-link-active
            color $green
  .mask
    position fixed
    z-index 1
    left 0
    right 0
    top 0
    bottom 0
    background transparent
    @media screen and (min-width: 841px)
      &
        display none
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
        keywords: '',
        asideShow: false
      }
    },
    created: function () {
      eventHub.$on('toggle', this.toggle)
    },
    beforeDestroy: function () {
      eventHub.$off('toggle', this.toggle)
    },
    props: {
      problems: {
        type: Object,
        required: true
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
        this.asideShow = !this.asideShow
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
