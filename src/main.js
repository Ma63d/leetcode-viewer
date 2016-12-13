// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

import Viewer from './Viewer.vue'
import DescriptionView from './components/Description.vue'
import SourceView from './components/Source.vue'
import NotFoundView from './components/NotFound.vue'

import './stylus/common.styl'

const router = new VueRouter({
  //mode: 'history',
  //base: __dirname,
  routes: [
    { path: '/description', component: DescriptionView },
    { path: '/source/:id?', component: SourceView },
    { path: '/404', component: NotFoundView },
    { path: '*', redirect: '/description' }
  ]
})

/* eslint-disable no-new */
new Vue({
  router,
  components: { Viewer }
}).$mount('viewer')

