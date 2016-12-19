public class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0){
            return word2.length();
        }else if(word2.length() == 0){
            return word1.length();
        }
        int[][] lcs = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i <= word1.length();i++) lcs[i][0] = i;
        for(int i = 1;i <= word2.length();i++) lcs[0][i] = i;
        for(int i = 1;i <= word1.length();i++){
            for(int j = 1;j <= word2.length();j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1];
                }else{
                    lcs[i][j] = Math.min(Math.min(lcs[i-1][j],lcs[i][j-1]),lcs[i-1][j-1])+1;
                }
            }
        }
        return lcs[word1.length()][word2.length()];
    }
}