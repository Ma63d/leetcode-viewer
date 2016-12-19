/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2){
            return head;
        }
        return reverseKOneTime(head,k);
    }
    private ListNode reverseKOneTime(ListNode head, int k){
        int i = 0;
        for(ListNode temp = head;temp != null && i < k;i++,temp=temp.next);
        if(i == k){
            ListNode start = head, end = head;
            for(i = 0;i < k-1;i++){
                ListNode temp = end.next;
                end.next = temp.next;
                temp.next = start;
                start = temp;
            }
            end.next = reverseKOneTime(end.next,k);
            head = start;
        }
        return head;
    }
}