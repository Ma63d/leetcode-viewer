/**
 * Created by chuck7 on 16/9/20.
 */
import marked from 'marked'
import highlight from 'highlight.js/lib/highlight'
const languages = ['cpp', 'java', 'c', 'cs', 'js', 'py', 'rb', 'swift', 'go']
highlight.registerLanguage('cpp', require('highlight.js/lib/languages/cpp'))
highlight.registerLanguage('java', require('highlight.js/lib/languages/java'))
highlight.registerLanguage('c', require('highlight.js/lib/languages/cpp'))
highlight.registerLanguage('cs', require('highlight.js/lib/languages/cs'))
highlight.registerLanguage('js', require('highlight.js/lib/languages/javascript'))
highlight.registerLanguage('py', require('highlight.js/lib/languages/python'))
highlight.registerLanguage('rb', require('highlight.js/lib/languages/ruby'))
highlight.registerLanguage('swift', require('highlight.js/lib/languages/swift'))
highlight.registerLanguage('go', require('highlight.js/lib/languages/go'))

highlight.configure({
  classPrefix: ''     // don't append class prefix
})
marked.setOptions({
  renderer: new marked.Renderer(),
  gfm: true,
  pedantic: false,
  sanitize: false,
  tables: true,
  breaks: true,
  smartLists: true,
  smartypants: true,
  highlight: function (code, lang) {
    if (!~languages.indexOf(lang)) {
      return highlight.highlightAuto(code).value
    }
    return highlight.highlight(lang, code).value
  }
})
export function markdown (str) {
  return marked(str)
}
