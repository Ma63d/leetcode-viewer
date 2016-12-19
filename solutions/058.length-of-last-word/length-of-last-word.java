public class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int max = 0;
        boolean start = false;
        for(int i = s.length() -1;i > -1;i--){
            if(s.charAt(i) != ' '){
                start = true;
                len++;
                if(len > max) max = len;
            }else if(start){
                return max;
            }
        }
        return max;
    }
}