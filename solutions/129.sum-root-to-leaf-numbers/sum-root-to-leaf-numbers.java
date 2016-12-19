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
    public class Node{
        int val;
        TreeNode tn;
        Node(int v,TreeNode t){
            val = v;
            tn = t;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int result = 0;
        Stack<Node> st = new Stack<Node>();
        st.push(new Node(root.val,root));
        while(!st.isEmpty()){
            Stack<Node> curSt = new Stack<Node>();
            while(!st.isEmpty()){
                Node cur = st.pop();
                if(cur.tn.left == null && cur.tn.right == null){
                    result += cur.val;
                }else{
                    if(cur.tn.left != null){
                        curSt.push(new Node(cur.val*10+cur.tn.left.val,cur.tn.left));
                    }
                    if(cur.tn.right != null){
                        curSt.push(new Node(cur.val*10+cur.tn.right.val,cur.tn.right));
                    }
                }
            }
            st = curSt;
        }
        return result;
    }
}