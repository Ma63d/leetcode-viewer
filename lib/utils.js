'use strict'
/**
 * Format id to 3-bit.
 *
 * @param {Number} id
 * @return {String}
 * @api public
 */
function formatId (id) {
  if (id < 10) {
    return '00' + id
  } else if (id < 100) {
    return '0' + id
  } else {
    return '' + id
  }
}
exports.formatId = formatId
