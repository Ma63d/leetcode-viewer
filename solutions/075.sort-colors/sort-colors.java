public class Solution {
    public void sortColors(int[] nums) {
        if(nums.length < 2){
            return;
        }
        int left = 0,right = nums.length-1;
        while(left<right){
            while(nums[left] < 2 && left < right){
                left++;
            }
            while(nums[right] == 2 && left < right){
                right--;
            }
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left]= temp;
        }
        if(left != 0){
            if(nums[left] == 2){
                right = left - 1;
            }else{
                right = left;
            }
            left = 0;
            while(left<right){
                while(nums[left] == 0 && left < right){
                    left++;
                }
                while(nums[right] == 1 && left < right){
                    right--;
                }
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left]= temp;
            }
        }
    }
}