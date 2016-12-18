export default {
  update (el, binding) {
    console.log('updated')
    el.innerHTML = ``
    window.duoshuoQuery.sso = {
      login: '#/source/' + binding.value.postId,
      logout: window.location.origin + window.location.pathname + '#/source/' + binding.value.postId
    }
    let dom = document.createElement('div')
    dom.setAttribute('data-thread-key', binding.value.id)
    dom.setAttribute('data-title', binding.value.title)
    dom.setAttribute('data-url', window.location.origin + window.location.pathname + '#/source/' + binding.value.postId)
    window.DUOSHUO.EmbedThread(dom)
    el.appendChild(dom)
  }
}
