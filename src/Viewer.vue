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
    padding 0 65px
    min-height 500px
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


