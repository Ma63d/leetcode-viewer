public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.equals("")){
            return 0;
        }
        str = str.trim();
        char[] chars = str.toCharArray();
        double result = 0;
        int i =0;
        boolean positive = true;
        if(chars[0] == '-'){
            positive = false;
            i++;
        }else if(chars[0] == '+'){
            i++;
        }
        while(i < chars.length){
            if(chars[i] >= '0' && chars[i] <= '9'){
                result *= 10;
                result += chars[i] - '0';
            }else {
                break;
            }
            i++;
        }
        result = result * (positive ? 1:-1);
        if(result > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(result < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }else{
            return (int)result;
        }
    }
}