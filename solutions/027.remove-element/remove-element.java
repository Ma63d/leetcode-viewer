public class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] == val) continue;
            nums[count++] = nums[i]; 
        }
        return count;
    }
}