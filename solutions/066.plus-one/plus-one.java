public class Solution {
    public int[] plusOne(int[] digits) {
        int up = 1;
        for(int i = digits.length-1;i > -1;i--){
            int sum = (digits[i]+up);
            up = sum/10;
            digits[i] = sum%10;
            if(up == 0){
                break;
            }else{
                if(i == 0){
                    int[] result = new int[digits.length+1];
                    for(int j = digits.length-1;j > -1;j--){
                        result[j+1] =digits[j]; 
                    }
                    result[0] = 1;
                    return result;
                }
            }
        }
        return digits;
    }
}