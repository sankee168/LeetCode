//Time complexity: O(n)
//Space complexity: O(1)
//trick here is to use stack to push the points in each round
public int calPoints(String[] ops) {
	Stack<Integer> stack = new Stack<>();
	for(int i = 0; i < ops.length; i++){
		String curr = ops[i];
		if(curr.equals("+")){
            int k = 2;
			int p1 = 0; int p2 = 0;
			while(!stack.isEmpty() && k > 0){
				if(k == 2) p1 = stack.pop();
				if(k == 1) p2 = stack.pop();
                k--;
			}

			if(k == 0) {stack.push(p2); stack.push(p1);}
			if(k == 1) stack.push(p1);
			stack.push(p1+p2);
		}
		else if(curr.equals("D")){
			if(!stack.isEmpty()){
				stack.push(stack.peek()*2);
			}
		}else if(curr.equals("C")){
			stack.pop();
		}else{
			stack.push(Integer.parseInt(curr));
		}
	}


	int sum = 0;
	while(!stack.isEmpty()){
		sum += stack.pop();
	}
	return sum;
}