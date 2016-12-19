public class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length < 2) return;
        int j;
        for(j = nums.length - 1;j > 0 && nums[j] <= nums[j- 1];j--);
        if(j == 0){
            Arrays.sort(nums,0,nums.length);
            return;
        }else{
            int temp = nums[j-1];
            int i;
            for(i = j;i+1 < nums.length && temp < nums[i+1];i++);
            nums[j-1] = nums[i];
            nums[i] = temp;
            Arrays.sort(nums,j,nums.length);
        }
    }
}