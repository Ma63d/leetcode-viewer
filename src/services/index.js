/* 封装get，post，delete请求 */
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
    headers = new window.Headers(headers)
    var query = []
    Object.keys(param).forEach((item) => {
      query.push(`${item}=${encodeURIComponent(param[item])}`)
    })
    var params = query.length ? '?' + query.join('&') : ''  // fixme
    url = host + url + params
    console.log(host, params)
    var init = {
      method: 'GET',
      headers: headers,
      cache: 'default'
    }
    if (isJson) {
      return window.fetch(url, init)
        .then(checkStatus)
        .then(parseJSON)
    } else {
      return window.fetch(url, init)
        .then(checkStatus)
        .then(parseText)
    }
  }
}

