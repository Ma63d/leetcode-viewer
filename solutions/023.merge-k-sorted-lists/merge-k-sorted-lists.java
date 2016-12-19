/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    private ListNode merge2lists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val){
            l1.next = merge2lists(l1.next,l2);
            return l1;
        }else{
            l2.next = merge2lists(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        if(lists.length == 1) return lists[0];
        return mergeLists(lists,0,lists.length-1);
    }
    private ListNode mergeLists(ListNode[] lists,int startIndex,int endIndex){
        if(startIndex == endIndex || startIndex == endIndex -1){
            lists[startIndex/2] = startIndex == endIndex? lists[startIndex]: merge2lists(lists[startIndex],lists[endIndex]);
            return lists[startIndex/2];
        }
        for(int i = startIndex;i <= endIndex;i += 2){
            int end = i+1 > endIndex? endIndex:i+1;
            mergeLists(lists,i,end);
        }
        return mergeLists(lists,startIndex,endIndex/2);
    }
}