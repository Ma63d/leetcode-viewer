<template>
  <aside class="sidebar">
    <nav>
      <ul class="question-links-container">
        <li class="question-link" v-for="(value, key) in problems"><router-link :to="'/source/'+key">{{key}}.{{problems[key]['title']}}</router-link></li>
      </ul>
    </nav>
  </aside>

</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .sidebar
    position fixed
    left 0
    top $header-total-height
    bottom 0
    padding 40px 0 50px 65px
    width 260px
    margin-right 20px
    overflow-x hidden
    overflow-y auto
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

</style>
<script>
  //import state from '../../store/state.js'
  //import service from '../../services/source/index.js'
  export default {
    props: {
      problems: {
        type: Object,
        required: true
      }
    }
  }
</script>
