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
    //这道题没有做出来 
    //但其实要是对二叉树的先/中/后序遍历掌握比较清楚,对其意义比较了解的话,其实做起来很简单的
    //一个BST 用中序遍历就可以将它扁平化,拉直成为一个排好序的数组,
    //明白了这一点,这个题就好做了,
    //2 elements are swapped 那就是去一个有两个元素被调换顺序的数组中找到这两个元素
    //这不就简单啦?
    //用constant space的话那就不要递归了 改成循环就可以了
    public void recoverTree(TreeNode root) {
        TreeNode now = root;
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode mistake1 = null,mistake2 = null;
        TreeNode prev = null;
        int i = 0;
        while(now != null || !st.empty()){
            if(now != null){
                st.push(now);
                now = now.left;
            }else{
                now = st.pop();
                if(i == 0){
                    i++;
                }else{
                    if(now.val < prev.val){
                        if(mistake2 == null){
                            mistake1 = prev;
                            mistake2 = now;
                        }else{
                            mistake2 = now;
                        }
                    }
                }
                prev = now;
                now = now.right;
            }
        }
        int temp = mistake1.val;
        mistake1.val = mistake2.val;
        mistake2.val = temp;
    }
}