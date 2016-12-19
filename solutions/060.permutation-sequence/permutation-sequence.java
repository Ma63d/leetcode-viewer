public class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();
        for(int i = 0;i < n;i++){
            result.append(i+1);
        }
        reOrder(result,k);
        return result.toString();
    }
    public void reOrder(StringBuilder result,int k){
        if(k == 1) return;
        int multiResult = 1;
        int multiTimes = 1;
        while(multiResult*(multiTimes+1) < k){
            multiTimes++;
            multiResult *= multiTimes;
        }
        int change = (k-1)/multiResult;
        result.insert(result.length()-multiTimes-1,result.charAt(result.length()-multiTimes-1+change));
        result.deleteCharAt(result.length()-multiTimes-1+change);
        reOrder(result,k-change*multiResult);
    }
}