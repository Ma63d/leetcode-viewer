/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null ){
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        head = second;
        while(first != null && second != null){
            first.next = second.next;
            second.next = first;
            if(first.next != null && first.next.next != null){
                second = first;
                first = first.next;
                second.next = first.next;
                second = second.next;
            }else{
                return head;
            }
        }
        return head;
    }
}