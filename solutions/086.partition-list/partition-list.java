/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode findLess = head,save = null;
        while(findLess != null){
            if(findLess.val < x){
                save = findLess;
            }
            findLess = findLess.next;
        }
        if(save == null){
            return head;
        }
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        ListNode tail = save;
        while(head != save){
            if(head.val >= x){
                ListNode cur = head.next;
                head.next = tail.next;
                prev.next = cur;
                tail.next = head;
                tail = head;
                head = cur;
            }else{
                prev = head;
                head = head.next;
            }
        }
        return fakeHead.next;
    }
}