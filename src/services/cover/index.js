import api from '../index.js'
export default {
  getResultJson () {
    return api.get('result.json')
  },
  getQuestion (path) {
    return api.get(`${path}/question.md`)
  }
}
