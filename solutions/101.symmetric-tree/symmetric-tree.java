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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return dfs(root.left,root.right);
    }
    public boolean dfs(TreeNode left,TreeNode right){
        if(left == null){
            if(right == null){
                return true;
            }else{
                return false;
            }
        }else{
            if(right == null) return false;
            if(!dfs(left.left,right.right)) return false;
            if(left.val != right.val) return false;
            return dfs(left.right,right.left);
        }
        
    }
}