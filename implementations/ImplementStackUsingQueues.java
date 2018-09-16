//implement stack using queues
//here we are making push as O(n)
class MyStack {

	Queue<Integer> q1;

	public MyStack(){
		q1 = new LinkedList<>();
		
	}
	
	public void push(int x){
		Queue<Integer> q2 = new LinkedList<>();
		q2.add(x);
		while(!q1.isEmpty()){
			q2.add(q1.poll());
		}
		q1 = q2;
	}

	public int pop(){
		return q1.poll();
	}

	public int top(){
		return q1.peek();
	}

	public boolean empty(){
		return q1.isEmpty();
	}
}


//here we are making pop as O(n)
class MyStack {
    
    Queue<Integer> q1;
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q1.add(x);
        top = x;
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> q2 = new LinkedList<>();
        while(q1.size() != 1){
            if(q1.size() == 2){
                top = q1.peek();
            }
            q2.add(q1.poll());
        }
        int temp =  q1.poll();
        q1 = q2;
        return temp;
    }
    
    /** Get the top element. */
    public int top() {
        return top;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */