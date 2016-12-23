<template>
  <article  class="posts">
    <h1 v-if="title !== ''">{{title}}</h1>
    <div v-html="compiledQuestion" class="question" v-if="question !== ''"></div>
    <div v-html="compiledPost" v-if="post !== ''"></div>
    <div v-html="compiledContent" v-if="content !== ''"></div>
  </article>
</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .posts
    max-width 700px
    margin 0 auto
    h1
      margin 0 0 1em
    @media screen and (max-width: 840px)
      &
        margin-left 0
    @media screen and (max-width: 1400px) and (min-width:841px)
      &
       margin-left 280px
  .question
    margin 2em 0
    padding-left 20px
    border-left 4px solid $green
    font-weight 600
    p
      margin 0.5em 0
</style>
<script>
import {markdown} from '../../utils/markdown'
export default{
  props: {
    content: {
      type: String
    },
    question: {
      type: String
    },
    title: {
      type: String
    },
    post: {
      type: String
    }
  },
  computed: {
    compiledContent: function () {
      return markdown(this.content)
    },
    compiledQuestion: function () {
      return markdown(this.question)
    },
    compiledPost () {
      return markdown(this.post)
    }
  }
}
</script>
