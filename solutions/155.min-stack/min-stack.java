public class MinStack {
    public class Node{
        int val;
        int min;
        Node next;
        Node(int v,int m,Node n){
            val = v;
            min = m;
            next = n;
        }
    }
    Node head;
    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        int min = x;
        if(head != null){
            min = head.min;
        }
        Node newNode = new Node(x,Math.min(x,min),head);
        head = newNode;
    }
    
    public void pop() {
        if(head != null){
            head = head.next;
        }
    }
    
    public int top() {
        if(head != null){
            return head.val;
        }else{
            return 0;
        }
        
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */