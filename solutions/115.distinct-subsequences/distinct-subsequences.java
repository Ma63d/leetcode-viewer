public class Solution {
    public int numDistinct(String s, String t) {
         if(s.length() == t.length()) return s.equals(t)?1:0;
         if(s.length() < t.length()) return 0;
         if(s.length() > t.length()){
             int[][] dp = new int[t.length()+1][];
             dp[0] = new int[s.length()+1];
             for(int i = 0;i < s.length()+1;i++) dp[0][i] = 1;
             for(int i = 1; i < t.length()+1;i++){
                 dp[i] = new int[s.length()+1];
                 dp[i][i] = dp[i-1][i-1] * (s.charAt(i-1) == t.charAt(i-1)?1:0) ;
                 for(int j = i+1;j < s.length()+1;j++){
                    int curResult = dp[i][j-1];
                    if(s.charAt(j-1) == t.charAt(i-1)){
                        curResult += dp[i-1][j-1];     
                    }    
                    dp[i][j] = curResult;
                 }
             }
             return dp[t.length()][s.length()];
         }
         return 1;
    }
}