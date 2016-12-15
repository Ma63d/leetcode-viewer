import api from '../index.js'
export default {
  getResultJson () {
    return api.get('result.json')
  },
  getDbJson (dirPath) {
    return api.get(`${dirPath}/db.json`)
  },
  getQuestionText (dirPath) {
    return api.get(`${dirPath}/question.md`, false)
  },
  getPostText (dirPath) {
    return api.get(`${dirPath}/post.md`, false)
  }
}
