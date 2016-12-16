// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import Viewer from './Viewer.vue'
import CoverView from './components/Cover.vue'
import SourceView from './components/Source.vue'
import NotFoundView from './components/NotFound.vue'

import './stylus/common.styl'

const router = new VueRouter({
  //mode: 'history',
  //base: __dirname,
  routes: [
    { path: '/cover', component: CoverView },
    { path: '/source/:id?', component: SourceView },
    { path: '/404', component: NotFoundView },
    { path: '*', redirect: '/cover' }
  ]
})

/* eslint-disable no-new */
new Vue({
  router,
  components: { Viewer }
}).$mount('viewer')
