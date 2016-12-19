/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    //应该用递归的 10行以内可以搞定;
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode head;
        if(l1.val>l2.val){
            head = l2;
            l2 = l2.next;
        }else{
            head = l1;
            l1 = l1.next;
        }
        
        ListNode current = head;
        while(l1 != null && l2 != null){
            if(l1.val > l2.val){
                current.next = l2;
                l2 = l2.next;
            }else{
                current.next = l1;
                l1 = l1.next;
            }
            current = current.next;
        }
        current.next = l1 == null?l2:l1;
        return head;
    }
}