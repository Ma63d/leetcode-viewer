public class Solution {
    //噗哈哈哈 竟然真的这么简单
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length;i++){
            if(prices[i] > prices[i-1]) profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}