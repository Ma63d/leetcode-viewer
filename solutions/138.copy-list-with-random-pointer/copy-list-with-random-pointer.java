/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode runner = head;
        RandomListNode returnHead = new RandomListNode(head.label),returnRunner = returnHead;
        map.put(head,returnHead);
        while(runner.next != null){
            runner = runner.next;
            returnRunner.next = new RandomListNode(runner.label);
            returnRunner = returnRunner.next;
            map.put(runner,returnRunner);
        }
        runner = head;returnRunner = returnHead;
        while(runner!= null){
            returnRunner.random = map.get(runner.random);
            runner = runner.next;
            returnRunner = returnRunner.next;
        }
        return returnHead;
    }
}