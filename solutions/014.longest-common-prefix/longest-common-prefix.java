public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String result = "";
        for(int i = 0;i < strs[0].length();i++){
            char x = strs[0].charAt(i);
            for(int j = 1;j < strs.length;j++){
                if(strs[j].length() == i){
                    return result;
                }
                if(strs[j].charAt(i) != x){
                    return result;
                }
            }
            result += x;
        }
        return result;
    }
}