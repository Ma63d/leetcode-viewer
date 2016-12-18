<template>
  <div>
    <side-bar :problems="problems"></side-bar>
    <post :content="content" :question="question" :title="title" :post="post"></post>
    <div class="posts tac loading-container" v-show="content == ''">
      <pulse-out-loader :height="100" :width="10" :margin="5" style="display: inline-block"></pulse-out-loader>
    </div>
    <duo-shuo v-if="enableDuoShuo && duoShuoRunning" :articleId="duoShuoArticleId" :articleTitle="duoShuoArticleTitle" :postId="postId"></duo-shuo>
  </div>
</template>
<style lang="stylus">
  .loading-container
    padding-top 200px
</style>
<script>
  import state from '../store/state'
  import service from '../services/source/index'
  import Post from './common/Post.vue'
  import SideBar from './common/SideBar.vue'
  import PulseOutLoader from './common/PulseOutLoader.vue'
  import DuoShuo from './common/DuoShuo.vue'
  import getHashCode from '../utils/hash_code'
  import cssClassOfLangMap from '../utils/css_class_lang_map'

  export default{
    components: {
      Post,
      SideBar,
      PulseOutLoader,
      DuoShuo
    },
    data () {
      return {
        problems: {},
        content: '',
        question: '',
        title: '',
        post: '',
        enableDuoShuo: process.env.duoShuoPlugin,
        duoShuoArticleId: '',
        postId: '',
        duoShuoArticleTitle: '',
        duoShuoRunning: false
      }
    },
    activated () {
      this.fetchData()
    },
    deactivated () {
      this.duoShuoRunning = false
    },
    watch: {
      // $route change , let's fetch data
      '$route': 'fetchData'
    },
    methods: {
      fetchData () {
        //fetch only when the path is of current page
        if (/^\/source/.test(this.$route.path)) {
          if (state.resultJson === undefined) {
            service.getResultJson().then((data) => {
              state.total = data.total
              state.solved = data.solved
              state.locked = data.locked
              state.lastUpdatedTime = data.lastUpdatedTime
              delete data.total
              delete data.solved
              delete data.locked
              delete data.lastUpdatedTime
              state.resultJson = data
              this.problems = data
              if (this.$route.params.id !== undefined) {
                if (this.problems[Number(this.$route.params.id)] === undefined) {
                  this.$router.replace('/404')
                } else {
                  this.fetchContent(this.problems[Number(this.$route.params.id)].id, this.problems[Number(this.$route.params.id)].title)
                }
              } else {
                for (let num in data) {
                  if (data.hasOwnProperty(num)) {
                    this.$router.replace(`/source/${num}`)
                    break
                  }
                }
              }
            }).catch(err => {
              console.error(err)
              console.error('cannot get result.json! ')
            })
          //if resultJson exits in state, that means we fetched before
          } else {
            this.problems = state.resultJson
            if (this.$route.params.id !== undefined) {
              if (this.problems[Number(this.$route.params.id)] === undefined) {
                this.$router.replace('/404')
              } else {
                this.fetchContent(this.problems[Number(this.$route.params.id)].id, this.problems[Number(this.$route.params.id)].title)
              }
            } else {
              for (let num in state.resultJson) {
                if (state.resultJson.hasOwnProperty(num)) {
                  this.$router.replace(`/source/${num}`)
                  break
                }
              }
            }
          }
        }
      },
      fetchContent (id, title) {
        this.postId = id + ''
        let pureId = id
        if (id < 10) {
          id = '00' + id
        } else if (id < 100) {
          id = '0' + id
        } else {
          id = '' + id
        }
        this.title = ``
        this.content = ``
        this.question = ``
        this.post = ``
        this.duoShuoRunning = true
        Promise.all([service.getQuestionText(`${id}.${title}`), service.getDbJson(`${id}.${title}`)])
        .then(([question, source]) => {
          let titleWithoutDash = title.split('-').join(' ')
          this.title = `${pureId} . ${titleWithoutDash}`
          this.duoShuoArticleTitle = this.title
          this.duoShuoArticleId = getHashCode(this.title) + ''
          this.duoShuoRunning = true
          this.question = question
          Object.keys(source).forEach((language) => {
            let cssClassOfLang = cssClassOfLangMap[language]
            this.content += `\`\`\`${cssClassOfLang}\n${source[language]}\n\`\`\`\n`
          })
        })
        service.getPostText(`${id}.${title}`).then(post => {
          this.post = post
        }).catch(err => {
          console.log(err)
        })
      }
    }
  }
</script>
