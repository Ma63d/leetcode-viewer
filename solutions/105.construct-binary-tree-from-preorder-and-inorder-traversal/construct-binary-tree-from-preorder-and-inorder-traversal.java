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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        return _formTree(preorder,0,preorder.length-1,inorder,0,preorder.length-1);
    }
    public TreeNode _formTree(int[] preorder,int pStart,int pEnd,int[] inorder,int iStart,int iEnd){
        TreeNode cur = new TreeNode(preorder[pStart]);
        if(pStart == pEnd) return cur;
        for(int i = iStart;i <=iEnd;i++){
            if(preorder[pStart] == inorder[i]){
                int left = 1;
                if(i != iStart){
                    left = i - iStart+1;
                    cur.left = _formTree(preorder,pStart+1,pStart+i-iStart,inorder,iStart,i-1);
                }
                if(i != iEnd){
                    cur.right = _formTree(preorder,pStart+left,pEnd,inorder,i+1,iEnd);
                }
                break;
            }
        }
        return cur;
    }
}