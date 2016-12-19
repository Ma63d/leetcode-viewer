public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1,j =0;
        for(;i > -1;i--){
            nums1[i+n] = nums1[i];
        }
        i = n;
        int l =0;
        while(i < m+n && j < n){
            if(nums1[i] < nums2[j]){
                nums1[l++] = nums1[i++];
            }else{
                 nums1[l++] = nums2[j++];
            }
        }
        while(i < m+n){
            nums1[l++] = nums1[i++];
        }
        while(j < n){
            nums1[l++] = nums2[j++];
        }
    }
}