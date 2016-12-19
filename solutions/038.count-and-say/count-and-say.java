public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for(int i = 1;i < n;i++){
            String temp = "";
            char last = result.charAt(0);int count = 1;
            for(int j = 1;j <= result.length();j++){
                if(j == result.length() ){
                    temp += count;temp += last;
                    continue;
                }
                if(result.charAt(j) !=last){
                    temp += count;temp += last;
                    last = result.charAt(j);
                    count = 1;
                }else{
                    count++;
                }
            }
            result = temp;
        }
        return result;
    }
}