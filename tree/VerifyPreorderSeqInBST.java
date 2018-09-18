//Idea here is to simulate the preorder. Iteratre through the array. 
//Keep inserting into stack till you see current value greater than stack last element. 
//so last element will be largest element in that subtree. 
//idea is when we see any element which is greater than previous
//that means we are entrering to some node which is in right subtree
//so we pop all the elements which are less than that
//in that process we update the low such that next coming elements should not have value less than this
public boolean verifyPreorder(int[] preorder) {
	int low = Integer.MIN_VALUE;
	Stack<Integer> stack = new Stack<>();
	for(int p : preorder){
		if(p < low){
			return false;
		}
		while(!stack.isEmpty() && p > stack.peek()){
			low = stack.pop();
		}
		stack.push(p);
	}

	return true;
}

//we can do this using the same array
public boolean verifyPreorder(int[] preorder){
	int low = Integer.MIN_VALUE;
	int i = -1;
	for(int p : preorder){
		if(p < low) return false;
		while(i >= 0 && p > stack.peek()){
			low = preorder[i--];
		}
		//we change the ith index to p
		preorder[i++] = p;
	}
	return true;
}