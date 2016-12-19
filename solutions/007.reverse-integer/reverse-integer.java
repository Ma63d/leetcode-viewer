public class Solution {
    public int reverse(int x) {
        if(x < 0){
            return -numToStr(-x);
        }
        if(x < 10){
            return x;
        }
        return numToStr(x);
    }
    public int numToStr(long x){
        String s = x+"";
        s = new StringBuilder(s).reverse().toString();
        int result;
        try{
            result =  Integer.parseInt(s);
        }catch(Exception e){
            return 0;
        }
        return result;
    }
}