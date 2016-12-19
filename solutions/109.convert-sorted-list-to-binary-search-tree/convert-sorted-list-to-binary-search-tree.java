/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        ArrayList<Integer> nums = new ArrayList<Integer>();
        while(head!=null){
            nums.add(head.val);
            head = head.next;
        }
        Integer[] numArray = nums.toArray(new Integer[nums.size()]);
        return _formSubBST(numArray,0,numArray.length-1);
    }
    public TreeNode _formSubBST(Integer[] nums,int start,int end){
        if(end < start) return null;
        int middle =  (start + end)/2;
        TreeNode cur =  new TreeNode(nums[middle]);
        cur.left = _formSubBST(nums,start,middle-1);
        cur.right = _formSubBST(nums,middle+1,end);
        return cur;
    }
}