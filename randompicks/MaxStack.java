//Idea here is to have two stacks such that at other stack maintains 
//max element till its corresponding place in stack
// example s1 = {2 ,1, 3, 5, 4} here s1 is the order of pushing elemens
// for this s2 = {2, 2, 3, 5, 5} this way we know what is the max element
//for popMax we will pop till we see that element and push rest again
//popMax takes O(n) as we are storing in temp stack and again pushing back into s1,s2
class MaxStack {

    Stack<Integer> s1;
    Stack<Integer> s2;
    /** initialize your data structure here. */
    public MaxStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        if(s1.isEmpty()){
            s1.push(x);
            s2.push(x);
        }else{
            s1.push(x);
            if(s2.peek() > x){
                s2.push(s2.peek());
            }else s2.push(x);
        }
    }
    
    public int pop() {
        s2.pop();
        return s1.pop();
    }
    
    public int top() {
        return s1.peek();
    }
    
    public int peekMax() {
        return s2.peek();
    }
    
    public int popMax() {
        int max = s2.peek();
        Stack<Integer> temp = new Stack<>();
        while(s1.peek() != max){
            temp.push(s1.peek());
            pop();
        }
        pop();
        while(!temp.isEmpty()){
            push(temp.pop());
        }
        return max;
    }
}


//To decrease popMax complexity, using any data structure with linear complexity for removal
//doesn't work. So we have to use double linked list as we can do O(1) delete operation
//and maintain TreeMap to know largest node

//Idea here is to have two stacks such that at other stack maintains 
//max element till its corresponding place in stack
// example s1 = {2 ,1, 3, 5, 4} here s1 is the order of pushing elemens
// for this s2 = {2, 2, 3, 5, 5} this way we know what is the max element
//for popMax we will pop till we see that element and push rest again
//Here complexity of peekMax and popMax are logn operations
class MaxStack {
    DoubleLinkedList dll;
    TreeMap<Integer, List<Node>> map;
    /** initialize your data structure here. */
    public MaxStack() {
       map = new TreeMap<>();
       dll = new DoubleLinkedList();
    }
    
    public void push(int x) {
       Node node = dll.add(x);
       if(!map.containsKey(x)){
            map.put(x, new ArrayList<Node>());
       }
       map.get(x).add(node);
    }
    
    public int pop() {
        int val = dll.removeLast();
        List<Node> list = map.get(val);
        list.remove(list.size()-1);
        if(list.size() == 0) map.remove(val);
        return val;
    }
    
    public int top() {
        return dll.getLast();
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int max = peekMax();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);
        if(list.size() == 0) map.remove(max);
        dll.remove(node);
        return max;
    }


class Node {
    Node prev;
    Node next;
    int val;
    public Node(int val){
        this.val = val;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList(){
        head = new Node(1);
        tail = new Node(1);
        head.next = tail;
        tail.prev = head;
    }

    public Node add(int val){
        Node curr = new Node(val);
        curr.next = tail;
        curr.prev = tail.prev;
        tail.prev.next = curr;
        tail.prev = curr;
        return curr;
    }

    public int removeLast(){
        Node curr = tail.prev;
        remove(curr);
        return curr.val;
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return;
    }

    public int getLast(){
        return tail.prev.val;
    }
}
}