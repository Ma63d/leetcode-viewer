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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        return generateSubTree(1,n);
    }
    public List<TreeNode> generateSubTree(int start,int end){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(end < start){
            result.add(null);
        }else if(start == end){
            result.add(new TreeNode(start));
        }else{
            for(int i = start;i <= end;i++){
                List<TreeNode> leftResult = generateSubTree(start,i-1);
                List<TreeNode> rightResult = generateSubTree(i+1,end);
                for(TreeNode left:leftResult){
                    for(TreeNode right:rightResult){
                        TreeNode root = new TreeNode(i);
                        root.left = left;
                        root.right = right;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}