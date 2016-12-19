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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        return _formTree(postorder,0,postorder.length-1,inorder,0,postorder.length-1);
    }
    public TreeNode _formTree(int[] postorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
        TreeNode cur = new TreeNode(postorder[pEnd]);
        if(pStart == pEnd) return cur;
        for(int i = iEnd;i >= iStart;i--){
            if(postorder[pEnd] == inorder[i]){
                int right = 1;
                if(i != iEnd){
                    right = iEnd - i+1;
                    cur.right = _formTree(postorder,pEnd -(iEnd - i),pEnd-1,inorder,i+1,iEnd);
                }
                if(i != iStart){
                    cur.left = _formTree(postorder,pStart,pEnd-right,inorder,iStart,i-1);
                }
                break;
            }
        }
        return cur;
    }
}