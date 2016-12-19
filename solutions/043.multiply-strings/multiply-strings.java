public class Solution {
    // public String multiply(String num1, String num2) {
    //     StringBuilder result = new StringBuilder("0");
    //     int num1Len = num1.length(),num2Len = num2.length();
    //     for(int i = 0; i < num1Len;i++){
    //         for(int j = 0;j < num2Len;j++){
    //             int m = num1.charAt(num1Len-1-i) - '0',n = num2.charAt(num2Len-1-j) - '0';
    //             if(m == 0 || n ==0) continue;
    //             int curResult = m * n;
    //             _sum(result,curResult,i+j);
    //         }
    //     }
    //     return result.toString();
    // }
    // private void _sum(StringBuilder curResult,int toSum,int position){
    //     if(curResult.length() <= position){
    //         for(int i = curResult.length();i <= position;i++){
    //             if(i == position){
    //                 curResult.insert(0,toSum);
    //             }else{
    //                 curResult.insert(0,0); 
    //             }
    //         }
    //     }else{
    //         String toSumString = ""  + toSum;
    //         for(int i = 0;i < toSumString.length();i++){
    //             int toSumNumI = toSumString.charAt(toSumString.length() - 1 - i) - '0';
    //             if(curResult.length() > position + i){
    //                 int curResultNumAtI = curResult.charAt(curResult.length() - position - i -1) - '0';
    //                 int sumResult = curResultNumAtI + toSumNumI;
    //                 if(sumResult < 10){
    //                     curResult.setCharAt(curResult.length() - position - i -1,(char)(sumResult+'0'));
    //                 }else{
    //                     curResult.setCharAt(curResult.length() - position - i -1,(char)(sumResult - 10+'0'));
    //                     _sum(curResult,1,position+i+1);
    //                 }
    //             }else{
    //                 _sum(curResult,toSumNumI,position + i);
    //             }
    //         }
    //     }
    // }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length(),m = num2.length();
        int[] result = new int[m+n];
        for(int i = n -1 ; i > -1; i--){
            for(int j = m-1;j > -1;j--){
                int x = num1.charAt(i) - '0',y = num2.charAt(j) - '0';
                int sum = x*y + result[(n-1-i)+(m-1-j)];
                result[(n-1-i)+(m-1-j)] = sum % 10;
                result[(n-1-i)+(m-1-j)+1] += sum/10 ;
            }
        }
        StringBuilder ret = new StringBuilder();
        for(int i = 0; i < n+m-1;i++){
            ret.insert(0,result[i]);
        }
        if(result[n+m-1] != 0){
            ret.insert(0,result[n+m-1]);
        }
        return ret.toString();
    }
}