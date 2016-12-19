public class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i = 0;i < nums.length;i++){
            while(nums[i] > 0 && nums[i] <= nums.length && nums[nums[i]-1] != nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        int i;
        for(i = 0;i < nums.length;i++){
            if(nums[i] != i+1){
                break;
            }
        }
        return i+1;
    }
}