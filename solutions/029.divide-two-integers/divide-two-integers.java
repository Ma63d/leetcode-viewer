public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1 || divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if(divisor == 1){
            return dividend;
        }
        int positive = 1;
        long dividendLong = dividend,divisorLong = divisor;
        if(dividend < 0 && divisor > 0){
            positive = -1;
            dividendLong = - dividendLong;
        }else if(dividend > 0 && divisor < 0){
            positive = -1;
            divisorLong = - divisorLong;
        }else if(dividend < 0 && divisor < 0){
            dividendLong = -dividendLong;
            divisorLong = -divisorLong;
        }
        int result = ownDevide(dividendLong,divisorLong);
        return positive * result;
    }
    private int ownDevide(long dividend, long divisor){
        long initialDivisor = divisor;
        if(dividend < divisor){
            return 0;
        }
        int result = 1;
        while(divisor << 1 < dividend && divisor << 1 > 0){
                divisor = divisor << 1;
                result = result << 1;
        }
        return result + ownDevide(dividend - divisor,initialDivisor);
    }
}