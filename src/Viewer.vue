<template>
  <div id="viewer">
    <header-nav></header-nav>
    <main class="main fix">
      <transition>
        <keep-alive>
          <router-view>
          </router-view>
        </keep-alive>
      </transition>
    </main>
    <footer class="copyright">
      powerd by <a href="https://github.com/Ma63d/leetcode-viewer" target="_blank">leetcode-viewer</a>
    </footer>
  </div>
</template>
<style lang="stylus">
  @import "./stylus/setting.styl"
  .main
    margin-top $header-total-height
    padding 2em 65px 0
    min-height 500px
    @media screen and (max-width:840px)
      &
        margin-top $header-total-height-small
        padding-left 1.4em
        padding-right 1.4em
  .v-enter-active
    transition opacity 1.2s
  .v-enter
    opacity 0

  .copyright
    color $light
    font-size 1em
    text-align center
    padding 0 20px 30px
    margin-top 30px
</style>

<script>
import HeaderNav from './components/common/HeaderNav.vue'

export default {
  components: {
    HeaderNav
  }
}
</script>


