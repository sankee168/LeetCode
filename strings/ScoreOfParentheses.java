//This is simple usage of stack. when you encounter ")" we have to apply all the given rules
//time complexity: O(n)
//Space complexity: O(n)
public int scoreOfParentheses(String S) {
	Stack<String> stack = new Stack<String>();
	for(char c: S.toCharArray()){
		if(c == '(') stack.push("(");
		else if(c == ')'){
			int count = 0;
			while(!stack.peek().equals("(")){
				count += Integer.parseInt(stack.pop());
			}
			stack.pop();
			if(count == 0) stack.push("1");
			else stack.push(String.valueOf(2*count));
		}
	}

	int sum = 0;
	while(!stack.isEmpty()){
		sum += Integer.parseInt(stack.pop());
	}

	return sum;
}