public class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int lastSum = nums[0];
        for(int i = 1;i< nums.length;i++){
            if(lastSum > 0){
                lastSum += nums[i];
            }else{
                lastSum = nums[i];
            }
            if(lastSum > maxSum) maxSum = lastSum;
        }
        return maxSum;
    }
}