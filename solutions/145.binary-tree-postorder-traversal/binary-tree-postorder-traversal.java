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
    public class Node {
        TreeNode tn;
        int level;
        Node(int x,TreeNode t) { level = x; tn = t; }
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> st = new Stack<>();
        st.push(new Node(0,root));
        while(!st.isEmpty()){
            Node peek = st.peek();
            switch(peek.level){
                case 0: peek.level = 1;
                if(peek.tn.left != null){
                    st.push(new Node(0,peek.tn.left));
                }
                break;
                case 1:peek.level = 2;
                if(peek.tn.right != null){
                    st.push(new Node(0,peek.tn.right));
                }
                break;
                case 2:st.pop();
                result.add(peek.tn.val);
                break;
            }
        }
        return result;
    }
}