/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        ListNode NAfter = head;
        ListNode beforeNAfter = head;
        int len = 1;
        while(n > 1){
            front = front.next;
            len++;
            n--;
        }
        if(front.next == null){
            return head.next;
        }else{
            while(front.next != null){
                beforeNAfter = NAfter;
                front = front.next;
                NAfter = NAfter.next;
            }
            beforeNAfter.next = NAfter.next;
            return head;
        }
    }
}