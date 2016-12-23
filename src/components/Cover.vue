<template>
  <section class="cover" >
    <side-bar :problems="problems"></side-bar>
    <div class="cover-inner">
      <img class="cover-pic" src="../assets/coding.png">
      <div class="cover-description">
        <div class="cover-description-title">
          {{name}}
          <br>
          Leetcode Solutions
        </div>
        <div class="cover-description-content">
          {{language === 'en' ? `This website presents all my accepted Leetcode solutions.`
          : `这个网页呈现了我全部的Leecode解题源码.`}}
          <br>
          {{language === 'en' ? `I've solved` : `我完成了 `}}
          <pulse-out-loader style="display: inline-block" v-show="loading"></pulse-out-loader> <span class="green" v-show="!loading">{{solved}}</span> / <span class="green" v-show="!loading">{{total}}</span><pulse-out-loader style="display: inline-block" v-show="loading"></pulse-out-loader>
          {{language === 'en' ? `problems` : `道题`}} ({{language === 'zh' ? `有` : ``}} {{locked}} {{language === 'en' ? `problems for a fee` : `题需要付费`}}).
          <br>
          {{language === 'en' ? `Click` : ``}} <router-link to="/source">{{language === 'en' ? `here` : `点此`}}</router-link> {{language === 'en' ? `to see every solution` : `查看每一个解题源码`}}.
          <br>
          <span class="light">Last updated: <pulse-out-loader style="display: inline-block" v-show="loading"></pulse-out-loader> <span class="green" v-show="!loading">{{lastUpdatedTime}}</span></span>
        </div>
      </div>
    </div>
  </section>
</template>
<style lang="stylus">
  @import "../stylus/setting.styl"
  .green
    color $green
  .cover
    padding 100px 0
    .sidebar
      display none
    .cover-inner
      margin 0 auto
      max-width 800px
      .cover-pic
        float left
        width 350px
        margin-right 0
        border-radius 10px
      .cover-description-title
        font-family $logo-font
        font-size 28px
        padding-top 20px
        padding-bottom 15px
      .cover-description-content
        font-size 18px
        line-height 1.5
      .light
        font-size 16px
    @media screen and (max-width:840px)
      &
        padding 0
        text-align center
        .cover-inner
          .cover-pic
            float none
        .sidebar
          display block
</style>
<script>
  import PulseOutLoader from './common/PulseOutLoader.vue'
  import SideBar from './common/SideBar.vue'
  import state from '../store/state'
  import service from '../services/cover/index'
  export default {
    components: {
      PulseOutLoader,
      SideBar
    },
    data () {
      return {
        name: process.env.author === null ? 'My' : `${process.env.author}'s`,
        language: process.env.language,
        total: '',
        solved: '',
        locked: '',
        lastUpdatedTime: '',
        loading: false,
        problems: {}
      }
    },
    activated () {
      if (state.solved === undefined) {
        this.fetchData()
      } else {
        //if `solved` exits in state, that means we fetched before
        this.total = state.total
        this.solved = state.solved
        this.locked = state.locked
        this.lastUpdatedTime = state.lastUpdatedTime
        this.problems = state.resultJson
      }
    },
    methods: {
      fetchData () {
        this.loading = true
        service.getResultJson().then((data) => {
          this.total = state.total = data.total
          this.solved = state.solved = data.solved
          this.locked = state.locked = data.locked
          this.lastUpdatedTime = state.lastUpdatedTime = data.lastUpdatedTime
          delete data.total
          delete data.solved
          delete data.locked
          delete data.lastUpdatedTime
          state.resultJson = data
          this.problems = state.resultJson
          this.loading = false
        })
      }
    }
  }
</script>
