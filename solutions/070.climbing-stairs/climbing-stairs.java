public class Solution {
    public int climbStairs(int n) {
        int[] result = new int[n+1];
        result[0] = 1;
        result[1] = 1;
        return _resolve(result,n);
    }
    public int _resolve(int[] result,int n){
        if(result[n] == 0 ) result[n] = _resolve(result,n-1)+_resolve(result,n-2);
        return result[n];
    }
}