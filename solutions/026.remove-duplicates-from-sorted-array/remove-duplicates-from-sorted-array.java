public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int count = 0;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] == nums[i-1]) continue;
            nums[++count] = nums[i];
        }
        return count+1;
    }
}