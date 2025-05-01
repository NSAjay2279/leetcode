/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function(x) {
  var str = x.toString()
  var str2 = ""
  for(var i=str.length-1; i>-1; i--) {
    str2 += str[i]
  }

  for(var i=str.length-1; i>-1; i--) {
    if (str[i] === str2[i]) {
      continue
    }
    else {
      return false
    }
  }
  return true
};