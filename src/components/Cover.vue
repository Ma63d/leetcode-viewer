<template>
  <section class="cover">
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
          {{solved}} / {{total}} {{language === 'en' ? `problems` : `道题`}} ({{language === 'zh' ? `有` : ``}} {{locked}} {{language === 'en' ? `problems for a fee` : `题需要付费`}}).
          <br>
          {{language === 'en' ? `Click` : ``}} <router-link to="/source">{{language === 'en' ? `here` : `点此`}}</router-link> {{language === 'en' ? `to see every solution` : `查看每一个解题源码`}}.
          <br>
          <span class="light">Last updated: {{lastUpdatedTime}}</span>
        </div>
      </div>
    </div>
  </section>
</template>
<style lang="stylus">
  @import "../stylus/setting.styl"
  .cover
    padding 100px 60px
    .cover-inner
      margin 0 auto
      width 800px
      .cover-pic
        float left
        width 350px
        margin-right 0
        border-radius 10px
      .cover-description-title
        font-size 28px
        padding-top 20px
        padding-bottom 15px
      .cover-description-content
        font-size 18px
        line-height 1.5
      .light
        font-size 16px
</style>
<script>
  import state from '../store/state'
  import service from '../services/cover/index'
  export default {
    data () {
      return {
        name: process.env.author === null ? 'My' : `${process.env.author}'s`,
        language: process.env.language,
        total: '',
        solved: '',
        locked: '',
        lastUpdatedTime: ''
      }
    },
    activated () {
      if (state.resultJson === undefined) {
        this.fetchData()
        //if resultJson exits in state, that means we fetched before
      } else {
        return
      }
    },
    methods: {
      fetchData () {
        service.getResultJson().then((data) => {
          state.resultJson = data
          this.total = data.total
          this.solved = data.solved
          this.locked = data.locked
          this.lastUpdatedTime = data.lastUpdatedTime
        })
      }
    }
  }
</script>
