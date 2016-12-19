public class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        if(chars.length < 2 || numRows == 1){
            return s;
        }
        if(chars.length <= numRows){
            return s;
        }
        int mod = 2 * numRows -2;
        String[] arr = new String[numRows];
        for(int i = 0;i < numRows;i++){
            arr[i] = "";
        }
        for(int j = 0;j < chars.length;j += mod){
            for(int i = 0;i < numRows && j+i < chars.length;i++){
                if(i == 0){
                    arr[i] += chars[j];
                }else if(i == numRows-1){
                    arr[i] += chars[j+i];
                }else{
                    arr[i] += chars[j+i] + ((mod-i+j < chars.length)?chars[mod-i+j]+"":"");
                }
            }
        }
        String result = "";
        for(int i = 0;i < numRows;i++){
            result+=arr[i];
        }
        return result;
    }
}