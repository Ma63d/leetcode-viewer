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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        ListNode runner = head,catcher = head;
        boolean found = false;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            catcher = catcher.next;
            if(catcher == runner){
                found = true;
                break;
            }
        }
        if(!found) return null;
        if(catcher == head) return head;
        runner = head;
        while(runner != catcher){
            runner = runner.next;
            catcher = catcher.next;
        }
        return runner;
    }
}