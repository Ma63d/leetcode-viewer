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
    public void flatten(TreeNode root) {
        if(root == null) return;
        _mergeLeftTree(root);
    }
    public TreeNode _mergeLeftTree(TreeNode root){
        if(root.left != null){
            TreeNode finalLeft = _mergeLeftTree(root.left);
            finalLeft.right = root.right;
            root.right = root.left;
            root.left = null;
            return finalLeft.right == null? finalLeft:_mergeLeftTree(finalLeft.right);
        }else{
            if(root.right == null){
                return root;
            }else{
                return _mergeLeftTree(root.right);
            }
        }
    }
}