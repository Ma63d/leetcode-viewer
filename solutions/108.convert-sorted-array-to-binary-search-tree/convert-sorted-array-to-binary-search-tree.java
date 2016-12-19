/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return _formSubBST(nums,0,nums.length-1);
    }
    public TreeNode _formSubBST(int[] nums,int start,int end){
        if(end < start) return null;
        int middle =  (start + end)/2;
        TreeNode cur =  new TreeNode(nums[middle]);
        cur.left = _formSubBST(nums,start,middle-1);
        cur.right = _formSubBST(nums,middle+1,end);
        return cur;
    }
}