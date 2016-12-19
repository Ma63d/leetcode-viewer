public class Solution {
    //这题真尼玛恶心
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length()==1){
            return 1;
        }
        char[] chars = s.toCharArray();
        int[] waysOfI = new int[chars.length+1];
        waysOfI[0] = 1;
        waysOfI[1] = 1;
        for(int i = 1;i < chars.length;i++){
            int cur = chars[i] - '0';
            int last = chars[i-1] - '0';
            if(cur == 0 ){
                if (last == 1 || last == 2){
                    waysOfI[i+1] = waysOfI[i-1];
                    continue;
                }else{
                    return 0;
                }
            }
            if((cur < 10 && last == 1 )||(cur < 7 && last == 2)){
                waysOfI[i+1] = waysOfI[i]+waysOfI[i-1];
            }else{
                waysOfI[i+1] = waysOfI[i];
            }
        }
        return waysOfI[chars.length];
    }
}