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
  </div>
</template>
<style lang="stylus">
  @import "./stylus/setting.styl"
  .main
    margin-top $header-total-height
    padding 0 65px

  .v-enter-active, .v-leave-active
    transition opacity .3s
  .v-enter, .v-leave-active
    opacity 0

</style>

<script>
import HeaderNav from './components/common/HeaderNav.vue'

export default {
  components: {
    HeaderNav
  }
}
</script>


