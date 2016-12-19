/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode runner = head,catcher = head;
        while(runner.next != null && runner.next.next !=null){
            runner = runner.next.next;
            catcher = catcher.next;
            if(runner == catcher) return true;
        }
        return false;
    }
}