/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int lenA = 1;
        int lenB = 1;
        ListNode runnerA = headA,runnerB = headB;
        while(runnerA.next != null){
            runnerA = runnerA.next;
            lenA++;
        }
        while(runnerB.next != null){
            runnerB = runnerB.next;
            lenB++;
        }
        if(runnerA != runnerB){
            return null;
        }
        runnerA = headA;runnerB = headB;
        if(lenA > lenB){
            while(lenA > lenB){
                lenA--;
                runnerA = runnerA.next;
            }
        }
        if(lenA < lenB){
            while(lenA < lenB){
                lenB--;
                runnerB = runnerB.next;
            }
        }
        while(runnerA != runnerB){
            runnerA = runnerA.next;
            runnerB = runnerB.next;
        }
        return runnerA;
    }
}