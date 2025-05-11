/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    var stack = [];
    var n = 0;

    for (var i=0; i<s.length; i++) {
        var c = s.charAt(i);
        switch(c) {
            case '(':
            case '[':
            case '{':
                stack[n++] = c;
                break;
            case ')':
                if(n==0 || stack[--n] != '(') return false;
                break;
            case ']':
                if(n==0 || stack[--n] != '[') return false;
                break;
            case '}':
                if(n==0 || stack[--n] != '{') return false;
                break;
            default:
                return false;
        }
    }
    return n === 0;
};