public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int current = nums[0];
        int currentCount = 1;
        int totalCount = 0;
        for(int i = 1;i < nums.length;i++){
            if(nums[i] ==current){
                if(++currentCount < 3){
                    totalCount++;
                    if(totalCount!=i){
                        nums[totalCount] = nums[i];
                    }
                }
            }else{
                totalCount++;
                current = nums[i];
                currentCount = 1;
                if(totalCount!=i){
                    nums[totalCount] = nums[i];
                }
            }
        }
        return totalCount+1;
    }
}