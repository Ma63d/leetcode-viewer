/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root!=null){
            TreeLinkNode head = null,last = null;
            while(root != null){
                if(root.left != null){
                    if(head == null) head = last = root.left;
                    else {
                        last.next = root.left;
                        last = root.left;
                    }
                }
                if(root.right != null){
                    if(head == null) head = last = root.right;
                    else {
                        last.next = root.right;
                        last = root.right;
                    }
                }
                root = root.next;   
            }
            root = head;
        }
    }
}