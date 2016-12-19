/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return;
        ListNode runner = head,catcher = head;
        while(runner.next != null && runner.next.next != null){
            runner = runner.next.next;
            catcher = catcher.next;
        }
        ListNode secondPartHead = catcher;
        if(secondPartHead.next.next != null){
            catcher = runner = secondPartHead.next;
            while(runner.next != null){
                secondPartHead.next = runner.next;
                runner.next = runner.next.next;
                secondPartHead.next.next = catcher;
                catcher = secondPartHead.next;
            }
        }
        runner = head;
        while(runner != secondPartHead){
            catcher = runner.next;
            runner.next = secondPartHead.next;
            secondPartHead.next = secondPartHead.next.next;
            runner.next.next = catcher;
            runner = catcher;
        }
    }
}