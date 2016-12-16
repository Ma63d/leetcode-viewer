<template>
  <div>
    <side-bar :problems="problems"></side-bar>
    <post :content="content" :question="question" :title="title" :post="post"></post>
  </div>
</template>
<style>

</style>
<script>
  import state from '../store/state'
  import service from '../services/source/index'
  import Post from './common/Post.vue'
  import SideBar from './common/SideBar.vue'
  import cssClassOfLangMap from '../utils/css_class_lang_map'

  export default{
    components: {
      Post,
      SideBar
    },
    data () {
      return {
        problems: {},
        content: '',
        question: '',
        title: '',
        post: ''
      }
    },
    activated () {
      this.fetchData()
    },
    watch: {
      // 如果路由有变化，会再次执行该方法
      '$route': 'fetchData'
    },
    methods: {
      fetchData () {
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
        Promise.all([service.getQuestionText(`${id}.${title}`), service.getDbJson(`${id}.${title}`)])
        .then(([question, source]) => {
          let titleWithoutDash = title.split('-').join(' ')
          this.title = `${pureId} . ${titleWithoutDash}`
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
