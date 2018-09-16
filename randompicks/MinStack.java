class MinStack {

    Stack<Integer> s;
    Stack<Integer> min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        s.push(x);
        Stack<Integer> temp = new Stack<>();
        while(!min.isEmpty() && x > min.peek()){
            temp.push(min.pop());
        }
        min.push(x);
        while(!temp.isEmpty()){
            min.push(temp.pop());
        }
    }
    
    public void pop() {
        int res = s.pop();
        Stack<Integer> temp = new Stack<>();
        while(min.peek() != res){
            temp.push(min.pop());
        }
        min.pop();
        while(!temp.isEmpty()){
            min.push(temp.pop());
        }
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

//This solution does the pop in the O(1) which is very efficient
//Keeping track of min at every node and pushing the difference is the key
//but negative point here is the integer overflow
class MinStack {
    Stack<Long> s;
    long min;

    public MinStack() {
        s = new Stack<Long>();
    }

    public void push(int x){
        if(s.isEmpty()){
            s.push(0L);
            min = x;
        }else{
            s.push(x-min);
            if(x < min) min = x;
        }
    }


    public void pop(){
        long top = s.pop();
        if(top < 0) min = min-top;
    }

    public int top() {
        long top = s.peek();
        if(top > 0) return (int)(top+min);
        else return (int)min;
    }

    public int getMin() {
        return (int)min;
    }
}

//This solution is very good using the linkedlist data structure itself
//It is just that we are storing node at each level so more space
class MinStack {
    Node head;

    public MinStack() {
    }

    public void push(int x){
        if(head == null){
            head = new Node(x, x, null);
        }else{
            Node node = null;
            if(head.min > x){
                node = new Node(x, x, head);
            }else{
                node = new Node(x, head.min, head);
            }
            head = node;
        }
    }


    public void pop(){
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    class Node {
        Node next;
        int val;
        int min;

        public Node(int x, int min, Node next){
            this.next = next;
            this.val = x;
            this.min = min;
        }
    }
}
