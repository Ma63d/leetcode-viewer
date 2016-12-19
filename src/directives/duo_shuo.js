// import _ from "lodash"
export default {
  inserted (el, binding) {
    let boundFunc = function () {
      duoShuoInit(el, binding.value, boundFunc)
    }
    window.addEventListener('scroll', boundFunc)
  },
  update (el, {value, oldValue}) {
    if (value.id !== oldValue.id || value.title !== oldValue.title) {
      duoShuoInit(el, value)
    }
  },
  unbind (el) {
    el.innerHTML = ``
  }
}

function duoShuoInit (el, value, boundFunction) {
  console.log(value)
  el.innerHTML = ``
  window.duoshuoQuery.sso = {
    login: '/#/source/' + value.postId,
    logout: window.location.href
  }
  let dom = document.createElement('div')
  dom.setAttribute('data-thread-key', value.id)
  dom.setAttribute('data-title', value.title)
  dom.setAttribute('data-url', window.location.origin + window.location.pathname + '#/source/' + value.postId)
  window.DUOSHUO.EmbedThread(dom)
  el.appendChild(dom)
  if (boundFunction !== undefined) {
    window.removeEventListener('scroll', boundFunction)
  }
}
