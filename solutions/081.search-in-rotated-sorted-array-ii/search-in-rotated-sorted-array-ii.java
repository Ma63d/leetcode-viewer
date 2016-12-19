public class Solution {
    public boolean search(int[] nums, int target) {
        return search(nums,0,nums.length-1,target);
    }
    public boolean search(int[]nums,int start,int end,int target){
        int l = start,r = end;
        while(l <= r){
            int m = (r+l)/2;
            if(nums[m] == target){
                return true;
            }else{
                if(nums[l] == nums[m] && nums[m] == nums[r]){
                    return search(nums,l,m-1,target) || search(nums,m+1,r,target);
                }else if(nums[l] == nums[r]){
                    
                    if(nums[m] > nums[l]){
                        if(target >= nums[l] && target < nums[m]){
                            r = m -1;
                        }else{
                            l = m+1;
                        }
                    }else{
                        if(target > nums[m] && target <= nums[l]){
                            l = m +1;
                        }else{
                            r = m -1;
                        }
                    }
                    
                }else if(nums[l] < nums[r]){
                    if(target  > nums[m]){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }else if(nums[m] < nums[l]){
                    if(target > nums[m] &&target <= nums[r]){
                        l = m+1;
                    }else{
                        r = m-1;
                    }
                }else{
                    if(target >= nums[l] && target <nums[m]){
                        r = m-1;
                    }else{
                        l = m+1;
                    }
                }
            }
        }
        return false;
    }
}