/* global Headers:false, fetch:false */
function checkStatus (response) {
  if (response.status >= 200 && response.status < 300) {
    return response
  } else {
    var error = new Error(response.statusText)
    error.response = response
    return Promise.reject(error)
  }
}

function parseJSON (response) {
  return response.json()
}
function parseText (response) {
  return response.text()
}

export default {
  get (url, isJson = true, param = {}, headers = {}, host = process.env.sourcePath) {
    headers = new Headers(headers)
    var query = []
    Object.keys(param).forEach((item) => {
      query.push(`${item}=${encodeURIComponent(param[item])}`)
    })
    var params = query.length ? '?' + query.join('&') : ''  // fixme
    url = host + url + params
    var init = {
      method: 'GET',
      headers: headers,
      cache: 'default'
    }
    if (isJson) {
      return fetch(url, init)
        .then(checkStatus)
        .then(parseJSON)
    } else {
      return fetch(url, init)
        .then(checkStatus)
        .then(parseText)
    }
  }
}

