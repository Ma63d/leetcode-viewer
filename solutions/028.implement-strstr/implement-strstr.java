public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()){
            return -1;
        }
        if(needle.length() < 1){
            return 0;
        }
        int[] next = initNext(needle);
        int i,j;
        for(i=0,j=0;i < haystack.length() && j < needle.length() ;i++,j++){
            if(haystack.charAt(i) == needle.charAt(j)) continue;
            j = next[j];
            while(j != -1){
                if(haystack.charAt(i) == needle.charAt(j)){
                    break;
                }
                j = next[j];
            }
        }
        return j == needle.length() ? i - needle.length(): -1;
        
    }
    private int[] initNext(String needle){
        int[] next = new int[needle.length()];
        next[0] = -1;
        if(needle.length() > 1){
            next[1] = 0;
            int last = 0;
            for(int i = 2;i < needle.length(); i++){
                while(last != -1 && needle.charAt(i-1) != needle.charAt(last) ){
                    last = next[last];
                }
                next[i] = last+1;
                last = next[i];
            }
        }
        return next;
    }
}