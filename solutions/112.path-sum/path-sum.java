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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return dfs(root,0,sum);
    }
    public boolean dfs(TreeNode root, int curSum,int target){
        curSum += root.val;
        if(root.left != null && root.right != null){
            return dfs(root.left,curSum,target) || dfs(root.right,curSum,target);    
        }else if(root.left == null && root.right == null){
            return curSum == target;
        }else if(root.left == null){
            return dfs(root.right,curSum,target);    
        }else{
            return dfs(root.left,curSum,target);
        }
    }
}