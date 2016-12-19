/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode runner = head,catcher = head;
        while(runner!= null && runner.next != null){
            int cur = runner.next.val;
            catcher = fakeHead;
            while(catcher.next != runner.next){
                if(catcher.next.val >= cur){
                    ListNode next = catcher.next;
                    catcher.next = runner.next;
                    runner.next = runner.next.next;
                    catcher.next.next = next;
                    break;
                }
                catcher = catcher.next;
            }
            if(catcher == runner){
                runner = runner.next;
            }
        }
        return fakeHead.next;
    }
}