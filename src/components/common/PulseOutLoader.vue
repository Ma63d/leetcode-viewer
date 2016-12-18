<template>
  <div class="line-scale-pulse-out-rapid" v-cloak>
    <div :style="{height:height+'px',width:width+'px',margin:margin+'px'}" v-for="n in 5"></div>
  </div>
</template>
<style lang="stylus" scoped>
  @import "../../stylus/loading.styl"
  @import '../../stylus/setting.styl'
  @keyframes line-scale-pulse-out-rapid
    0%
      -webkit-transform: scaley(1);
      transform: scaley(1);

    80%
      -webkit-transform: scaley(0.3);
      transform: scaley(0.3);

    90%
      -webkit-transform: scaley(1);
      transform: scaley(1);

  .line-scale-pulse-out-rapid
    div
      background-color: $green
      border-radius: 2px;
      animation-fill-mode: both;
      display: inline-block;
      animation: line-scale-pulse-out-rapid 0.9s 0s infinite cubic-bezier(.11, .49, .38, .78);
  .line-scale-pulse-out-rapid > div:nth-child(2)
  .line-scale-pulse-out-rapid > div:nth-child(4)
    animation-delay: 0.25s !important;
  .line-scale-pulse-out-rapid > div:nth-child(1)
  .line-scale-pulse-out-rapid > div:nth-child(5)
    animation-delay: 0.5s !important;

</style>
<script>
  export default {
    props: {
      // the width of each histogram
      width: {
        type: Number,
        default: 2
      },
      // the height of each histogram
      height: {
        type: Number,
        default: 20
      },
      // the margin between each histogram
      margin: {
        type: Number,
        default: 1
      }
    }
  }
</script>
