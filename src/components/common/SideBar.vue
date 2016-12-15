<template>
  <nav class="sidebar">
    <ul>
      <!--<li><router-link :to=""></router-link></li>-->
    </ul>
  </nav>
</template>
<style lang="stylus">
  @import "../../stylus/setting.styl"
  .sidebar
    position fixed
    left 0
    top $herder-total-height
    padding 40px 0 50px 60px
    overflow-x hidden
    overflow-y auto
</style>
<script>
  import state from '../../store/state.js'
  import service from '../../services/source/index.js'
  export default {
    data () {
      return {
        result:''
      }
    },
    methods:{

    }
  }
</script>
