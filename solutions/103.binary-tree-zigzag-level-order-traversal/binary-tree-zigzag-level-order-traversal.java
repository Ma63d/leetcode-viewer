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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        Stack<TreeNode> stParent = new Stack<TreeNode>();
        stParent.push(root);
        //因为z型遍历的时候需要调换加入栈中的顺序,前一遍是先加左节点,后一便就会反过来变成先加右节点
        //所以需要用这个boolean来记录当前是改左还是右.
        boolean leftOrRight = true;
        while(!stParent.empty()){
            Stack<TreeNode> stChild =new Stack<TreeNode>();
            ArrayList<Integer> curResult = new ArrayList<Integer>();
            while(!stParent.empty()){
                TreeNode cur = stParent.pop();
                curResult.add(cur.val);
                if(leftOrRight){
                    if(cur.left != null) stChild.push(cur.left);
                    if(cur.right != null) stChild.push(cur.right);
                }else{
                    if(cur.right != null) stChild.push(cur.right);
                    if(cur.left != null) stChild.push(cur.left);
                }
            }
            result.add(curResult);
            leftOrRight = !leftOrRight;
            stParent = stChild;
        }
        return result;
    }
}