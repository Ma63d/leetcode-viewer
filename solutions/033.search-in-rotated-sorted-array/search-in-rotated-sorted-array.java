public class Solution {
    //比直接暴力法时间还要长 我也是日了狗了
    // public int search(int[] nums, int target) {
    //     if(nums.length < 1) return -1;
    //     return ownSearch(nums,0,nums.length-1,target);
    // }
    // private int ownSearch(int[] nums,int startIndex,int endIndex,int target){
    //     if(endIndex - startIndex < 2){
    //         for(;startIndex <= endIndex && nums[startIndex] != target;startIndex++);
    //         return startIndex > endIndex ? -1 : startIndex ;
    //     }
    //     int middle = (startIndex + endIndex)/2;
    //     if(nums[middle] == target){
    //         return middle;
    //     }else{
    //         if(nums[middle] < nums[startIndex] ){
    //             //pivot 在middle和start之间;
    //             if(nums[middle] < target && target <= nums[endIndex]){
    //                 return binarySearch(nums,middle+1,endIndex,target);
    //             }else{
    //                 return ownSearch(nums,startIndex,middle-1,target);
    //             }
    //         } else{
    //             //pivot 在middle和end之间;
    //             if(nums[middle] > target && target >= nums[startIndex]){
    //                 return binarySearch(nums,startIndex,middle-1,target);
    //             }else{
    //                 return ownSearch(nums,middle+1,endIndex,target);
    //             }
    //         }                
    //     }
    // }
    // private int binarySearch(int[] nums,int startIndex,int endIndex,int target){
    //     if(endIndex - startIndex < 2){
    //         for(;startIndex <= endIndex && nums[startIndex] != target;startIndex++);
    //         return startIndex > endIndex ? -1 : startIndex ;
    //     }else{
    //         int middle = (startIndex + endIndex)/2;
    //         if(target == nums[middle]){
    //             return middle;
    //         }else if(target > nums[middle]){
    //             return binarySearch(nums,middle+1,endIndex,target);
    //         }else{
    //             return binarySearch(nums,startIndex,middle-1,target);
    //         }
    //     }
    // }
    public int search(int[] A, int target) {  
        int l = 0;  
        int r = A.length - 1;  
        while (l <= r) {  
            int mid = (l + r) / 2;  
            if (target == A[mid]) return mid;  
            if (A[l] <= A[r]) {  
                if (target < A[mid]) r = mid - 1;  
                else l = mid + 1;  
            } else if (A[l] <= A[mid]) {  
                if (target > A[mid] || target < A[l]) l = mid + 1;  
                else r = mid - 1;  
            } else {  
                if (target < A[mid] || target > A[r]) r = mid - 1;  
                else l = mid + 1;  
            }  
        }  
        return -1;  
    } 
}