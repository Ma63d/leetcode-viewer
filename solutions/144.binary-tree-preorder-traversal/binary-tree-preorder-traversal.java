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
    public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pointer = root;
        while(pointer != null || !st.isEmpty()){
            if(pointer != null){
                result.add(pointer.val);
                if(pointer.right != null) st.push(pointer.right);
                pointer = pointer.left;
            }else{
                pointer = st.pop();
            }
        }
        return result;
    }
}