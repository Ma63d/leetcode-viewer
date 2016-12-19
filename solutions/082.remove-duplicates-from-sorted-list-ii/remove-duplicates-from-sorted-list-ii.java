/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        head = fakeHead;
        while(head.next != null && head.next.next != null){
            if(head.next.val == head.next.next.val){
                int cur = head.next.val;
                ListNode curNode = head.next;
                while(curNode != null && curNode.val == cur){
                    curNode = curNode.next;
                }
                head.next = curNode;
            }else{
                head = head.next;
            }
        }
        return fakeHead.next;
    }
}