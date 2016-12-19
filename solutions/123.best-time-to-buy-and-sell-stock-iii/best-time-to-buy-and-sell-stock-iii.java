public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int maxPF = 0;
        int[] left2Right = new int[prices.length];
        int min = prices[0],max = min;
        left2Right[0] = 0;
        int maxProfitLeft2Right = 0;
        for(int i = 1;i < prices.length;i++){
            if(prices[i] > min){
                if(prices[i] > max){
                    max = prices[i];
                    maxProfitLeft2Right = Math.max(max -min,maxProfitLeft2Right);
                }
            }else if(prices[i] < min){
                min = max = prices[i];
            }
            left2Right[i] = maxProfitLeft2Right;
        }
        maxPF = maxProfitLeft2Right;
        int[] right2Left = new int[prices.length];
        right2Left[prices.length-1] = 0;
        min = max = prices[prices.length-1];
        int maxProfitRight2Left = 0;
        for(int i = prices.length-2;i >= 2;i--){
            if(prices[i] < max){
                if(prices[i] < min){
                    min = prices[i];
                    if(max - min > maxProfitRight2Left){
                        maxProfitRight2Left = max - min;
                        if(maxProfitRight2Left + left2Right[i-1] > maxPF){
                            maxPF = maxProfitRight2Left + left2Right[i-1];
                        }
                    }
                }
            }else if(prices[i] > max){
                min = max = prices[i];
            }
        }
        return maxPF;
    }
    
}