//Idea here is to simulate the preorder. Iteratre through the array. 
//Keep inserting into stack till you see current value greater than stack last element. 
//so last element will be largest element in that subtree. 
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