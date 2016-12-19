public class Solution {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        char[] chars = s.toCharArray();
        int len = chars.length;
        int maxLength = 1;
        int maxIndex = 0;
        //定义矩阵isPalindrome,isPalindrome[i][j]表示s[i]..s[j]组成的字符串是否是最长回文
        boolean[][] isPalindrome = new boolean[len][len];

        for(int i = 0; i < len;i++){
            isPalindrome[i][i] = true;
        }
        for(int i =0;i < len -1;i++){
            if(chars[i] == chars[i+1]){
                isPalindrome[i][i+1] = true;
                maxLength = 2;
                maxIndex = i;
            }
        }
        //从iP[0][2]开始沿斜向遍历到ip[len-1-2][len-1]
        //又从iP[0][3]开始沿斜向遍历到ip[len-1-3][len-1]
        for(int j = 2; j < len;j++){
            for(int i = 0;i < len - j;i++){
                if(isPalindrome[i+1][i+j-1]){
                    if(chars[i] == chars[i+j]){
                        isPalindrome[i][i+j] = true;
                        if(j+1 > maxLength){
                            maxLength = j+1;
                            maxIndex = i;
                        }
                    }
                }
            }
        }
        return s.substring(maxIndex,maxIndex + maxLength);
    }
}