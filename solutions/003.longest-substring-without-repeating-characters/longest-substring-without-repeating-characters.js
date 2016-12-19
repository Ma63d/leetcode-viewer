/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
        var LLS = [],map = {},max = 1;
        if(s.length < 2){
            return s.length;
        }
        LLS[0] = 1;
        map[s[0]] = 0;

        for(var i = 1;i < s.length;i++){
            LLS[i] = ((map[s[i]] === undefined)?-1:map[s[i]]) >= i-LLS[i-1] ? (i - map[s[i]]):LLS[i-1]+1
            map[s[i]] = i;
            if(LLS[i] > max){
                max = LLS[i];
            }
        }
        return max;
    };