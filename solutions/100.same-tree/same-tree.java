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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> st1 = new Stack<TreeNode>(),st2 = new Stack<TreeNode>();
        TreeNode now1 = p,now2 = q;
        while(now1 != null || !st1.empty()){
            if(now1 != null){
                if(now2 == null) return false;
                if(now1.val != now2.val) return false;
                if(now1.right != null){
                    if(now2.right == null) return false;
                    st1.push(now1.right);st2.push(now2.right);
                }else{
                    if(now2.right != null) return false;
                }
                now1 = now1.left;
                now2 = now2.left;
            }else{
                if(now2 != null) return false;
                now1 = st1.pop();
                now2 = st2.pop();
            }
        }
        if(now2 != null) return false;
        return true;
    }
}