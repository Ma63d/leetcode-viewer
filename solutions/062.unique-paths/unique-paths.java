public class Solution {
    public int uniquePaths(int m, int n) {
        if(n == 1|| m== 1) return 1;
        int x = m-1,y = n-1;
        double topResult = 1;
        double bottomResult = 1;
        for(int i = x+1;i < x+y+1;i++) topResult*=i;
        for(int i = 2;i < n;i++) bottomResult*=i;
        return (int)(topResult/bottomResult);
    }
}