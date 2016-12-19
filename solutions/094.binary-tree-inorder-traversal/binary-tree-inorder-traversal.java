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
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> nodeToTraversal = new Stack<TreeNode>();
        nodeToTraversal.push(root);
        TreeNode cur;boolean left = true;
        while(!nodeToTraversal.empty()){
            cur = nodeToTraversal.peek();
            if(left == true && cur.left != null){
                nodeToTraversal.push(cur.left);
            }else{
                nodeToTraversal.pop();
                result.add(cur.val);
                if(cur.right != null){
                    left = true;
                    nodeToTraversal.push(cur.right);
                }else{
                    left = false;
                }
            }
            
        }
        return result;
    }
    //下面是源神给的代码,代码更加精简优美,但是其实思路是一样的,
    //我是用一个boolean来记录当前是否在一直遍历左枝 
    //而源神的代码里是用了now是否等于null来标记左枝遍历的结束.
//     public void traversal(TreeNode root) {
// 		TreeNode now = root;
// 		Stack<TreeNode> stack = new Stack<TreeNode>();
// 		while (now != null || !stack.isEmpty()) {// 栈和当前指针都为null才算遍历完成
// 			if (now != null) {// 一直向左枝走
// 				stack.push(now);
// 				now = now.left;
// 			} else {// 左枝走到头，访问当前节点，然后跳到右枝
// 				now = stack.pop();
// 				System.out.println(now.val);// 访问该节点
// 				now = now.right;
// 			}
// 		}
// 	}
}