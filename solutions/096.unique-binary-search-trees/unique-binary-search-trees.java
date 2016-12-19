public class Solution {
    public int numTrees(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        for(int i = 1;i <= n;i++){
            int add = 0;
            for(int j = 1;j <= i;j++){
                add+= result[j-1]*result[i-j];
            }
            result[i] = add;
        }
        return result[n];
    }
}