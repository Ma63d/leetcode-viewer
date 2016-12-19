public class Solution {
    public int minCut(String s) {
        int[][] matrix = formMatrix(s);
        if(matrix[0][s.length()-1] ==1) return 0;
        int[] minCut = new int[s.length()];
        for(int i = 1;i < s.length();i++){
            minCut[i] = i;
            if(matrix[0][i] == 1){
                minCut[i] = 0;
                continue;
            }else{
                for(int j = 1;j <= i;j++){
                    if(matrix[j][i] == 1){
                        minCut[i] = Math.min(minCut[i],minCut[j-1]+1);
                    }
                }
            }
        }
        return minCut[s.length()-1];
    }
    public int[][] formMatrix(String s){
        int[][] result = new int[s.length()][];
        for(int i = 0; i < s.length();i++){
            result[i] = new int[s.length()];
            result[i][i] = 1;
            for(int j = i-1;j > -1;j--){
                if(j == i - 1){
                    if(s.charAt(j) == s.charAt(i)) result[j][i] =1;
                }else{
                    if(result[j+1][i-1] ==1){
                        if(s.charAt(j) == s.charAt(i)) result[j][i] =1;
                    }
                }
            }
        }
        return result;
    }
}