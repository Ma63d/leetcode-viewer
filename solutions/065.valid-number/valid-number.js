/**
 * @param {string} s
 * @return {boolean}
 */
var isNumber = function(s) {
    var reg = /^(-|\+)?([0-9]+(\.[0-9]*)?|\.[0-9]+)(e(-|\+)?[0-9]+)?$/;
    s = s.trim();
    return reg.test(s);
};