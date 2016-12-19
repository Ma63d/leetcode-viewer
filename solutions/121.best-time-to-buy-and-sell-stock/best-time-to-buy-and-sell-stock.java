public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int min = prices[0],max = min;
        int result = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > min){
                if(prices[i] > max){
                    max = prices[i];
                    result = Math.max(max -min,result);
                }
            }else if(prices[i] < min){
                min = max = prices[i];
            }
        }
        return result;
    }
}