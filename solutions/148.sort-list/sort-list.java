/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        int len = 1;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null){
            len += 2;
            runner = runner.next.next;
        }
        if(runner.next != null) len++;
        return sort(head,len);
    }
    public ListNode sort(ListNode head,int totalLen){
        if(totalLen == 1) return head;
        int len = (totalLen -1)/2;
        ListNode runner = head;
        for(int i = 0;i < len;i++) runner = runner.next;
        ListNode secondPartHead = sort(runner.next,totalLen - len - 1);
        runner.next = null;
        ListNode firstPartHead = sort(head,len+1);
        ListNode fakeHead = new ListNode(0);
        runner = fakeHead;
        while(secondPartHead != null && firstPartHead != null){
            if(secondPartHead.val < firstPartHead.val){
                runner.next = secondPartHead;
                secondPartHead = secondPartHead.next;
            }else{
                runner.next = firstPartHead;
                firstPartHead = firstPartHead.next;
            }
            runner = runner.next;
        }
        if(secondPartHead != null){
            runner.next = secondPartHead;
        }else{
            runner.next = firstPartHead;
        }
        return fakeHead.next;
    }
}