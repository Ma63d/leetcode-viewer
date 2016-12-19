public class Solution {
    public int maxProduct(int[] nums) {
        int[] positiveResult = new int[nums.length];
        int[] negativeResult = new int[nums.length];
        int max = nums[0];
        if(max > 0) positiveResult[0] = max;
        if(max < 0) negativeResult[0] = max;
        for(int i = 1; i < nums.length;i++){
            int cur;
            if(nums[i] == 0){
                positiveResult[i] = negativeResult[i] = 0;
                cur = 0;
            }else{
                if(nums[i] < 0){
                    cur = nums[i];
                    negativeResult[i] = nums[i];
                    if(positiveResult[i-1] > 0){
                        negativeResult[i] = positiveResult[i-1] * nums[i];
                    } 
                    if(negativeResult[i-1] < 0){
                        positiveResult[i] = nums[i] * negativeResult[i-1];
                        cur = positiveResult[i];
                    }
                }else{
                    cur = nums[i];
                    positiveResult[i] = nums[i];
                    if(positiveResult[i-1] > 0){
                        positiveResult[i] = positiveResult[i-1] * nums[i];
                        cur = positiveResult[i];
                    } 
                    if(negativeResult[i-1] < 0){
                        negativeResult[i] = nums[i] * negativeResult[i-1];
                    }
                }
            }
            if(cur > max) max = cur;
        }
        return max;
    }
}