public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length -1;
        while(left <= right){
            int middle = (left + right)/2;
            if(nums[middle] == target){
                left = middle;
                break;
            } else if(nums[middle] > target){
                right = middle - 1;
            }else{
                left = middle + 1;
            }
        }
        return left;
    }
}