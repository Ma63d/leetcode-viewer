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
    public boolean isValidBST(TreeNode root) {
        return isValidSubTree(root,(double)Integer.MIN_VALUE,(double)Integer.MAX_VALUE);
    }
    public boolean isValidSubTree(TreeNode root,double start,double end){
        if(root == null) return true;
        if((double)(root.val) > end || (double)(root.val) < start) return false;
        if(!isValidSubTree(root.left,start,(double)(root.val)-1) || !isValidSubTree(root.right,(double)(root.val)+1,end)){
            return false;
        }
        return true;
    }
}