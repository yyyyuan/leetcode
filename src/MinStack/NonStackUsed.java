public class MinStack {
    
    private class Node {
        int val;
        int min;
        Node next;
       
        private Node(int val, int min) {
            this(val, min, null);     // "this" can be used cause we define a complete constructor in next method.
        }
        
        // This constructor must be defined for invocation.
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
    
    private Node head;
    
    /** initialize your data structure here. */
    public MinStack() {
    }
    
    public void push(int x) {
        if (head == null) head = new Node(x, x);
        else head = new Node(x, Math.min(x, head.min), head);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
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
