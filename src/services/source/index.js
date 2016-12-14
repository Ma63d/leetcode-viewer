import api from '../index.js'
export default {
  getResultJson () {
    return api.get('result.json')
  },
  getDbJson (path) {
    return api.get(path)
  }
}
