/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    var start = l1;
    var lastInc = 0;
    if(l1 === null){
        return l2
    }
    if(l2 === null){
        return l1
    }
    while(l1 !== null && l2 !== null){
        var value = l1.val + l2.val + lastInc;
        if(value > 9){
            l1.val = value % 10;
            lastInc = 1;
        }else{
            l1.val = value;
            lastInc = 0;
        }
        var l1Last = l1,l2Last = l2;
        l1 = l1.next,l2 = l2.next;
    }
    if((l1 === null) && (l2 !== null)){
        l1Last.next = l2;
        var val = l2.val + lastInc;
        l2.val = val % 10;
        lastInc = val > 9;
        while(lastInc){
            if(l2.next){
                val = l2.next.val + lastInc;
                l2.next.val = val % 10;
                lastInc = val > 9;
                l2 = l2.next;
            }else{
                lastInc = 0;
                l2.next = {val:1,next:null}
            }
        }
    }else if((l2 === null) && (l1 !== null)){
        var val = l1.val + lastInc;
        l1.val = val % 10;
        lastInc = val > 9;
        while(lastInc){
            if(l1.next){
                val = l1.next.val + lastInc;
                l1.next.val = val % 10;
                lastInc = val > 9;
                l1 = l1.next;
            }else{
                lastInc = 0;
                l1.next = {val:1,next:null}
            }
        }
    }else{
        if(lastInc){
            l1Last.next = {val:lastInc,next:null}    
        }
    }
    return start;
};