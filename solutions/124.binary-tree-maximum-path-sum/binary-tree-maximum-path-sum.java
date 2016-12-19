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
    int result = 0;
    public int maxPathSum(TreeNode root) {
        this.result = Integer.MIN_VALUE;
        dfs(root);
        return this.result;
    }
    public int dfs(TreeNode root){
        if(root != null){
            int left = Math.max(dfs(root.left),0);
            int right = Math.max(dfs(root.right),0);
            int curResult  = root.val + Math.max(left,right);
            if(left+ right + root.val > result) result = left+ right + root.val;
            return curResult;
        }else{
            return 0;
        }
    }
}