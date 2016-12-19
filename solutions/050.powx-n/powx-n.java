public class Solution {
    public double myPow(double x, int n) {
        if(x == 0 || x == 1){
            return x;
        }
        if(x == -1){
            return (n%2 == 1)?x:1;
        }
        if(n < 0){
            if(n == Integer.MIN_VALUE) return myPow(1/x,-n-1)*1/x;
            return myPow(1/x,-n);
        }
        if(n == 0){
            return 1;
        }else if(n == 1){
            return x;
        }else{
            double x05n =myPow(x,n/2);
            return (n%2 == 1)?x05n*x05n*x:x05n*x05n;
        }
    }
}