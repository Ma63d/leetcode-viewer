/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fakeHead = new ListNode(0);
        ListNode prev = fakeHead;
        ListNode cur = prev.next = head;
        for(int i = 1;i < m;i++,cur = cur.next,prev = prev.next);
        for(int i = m;i < n;i++){
            ListNode reverseHead = prev.next;
            prev.next = cur.next;
            cur.next = cur.next.next;
            prev.next.next = reverseHead;
        }
        return fakeHead.next;
    }
}