//Here we maintain stack of indices. If we observe all the examples, we check if stack.peek() is '(' and cur index is ')' then that is valid parentheses
//maximum length will be differnece between cur index and top element in stack
//Time complexity: O(n)
//Space complexity: O(n) 
public int longestValidParentheses(String s) {
	if(s.length() < 2) return 0;
	Stack<Integer> stack = new Stack<>();
	stack.push(-1);
	stack.push(0);
	int max = 0;
	for(int i = 1; i < s.length(); i++){
		if(s.charAt(i) == ')' && stack.peek() != -1 && s.charAt(stack.peek()) == '('){
			stack.pop();
			max = Math.max(i-stack.peek(), max);
		}else stack.push(i);
	}
	return max;
}


//let us say dp[i] denotes the max length of valid parentheses substring ending at ith index
//Lets pick each valid parentheses string
// () - this is valid when s[i] is ) and s[i-1] is (
//(()) - this is also valid. inorder to consider this. if s[i] and s[i-1] is )
//we can observe that dp[i-1] will be 2. so if we can check s[i] == ')' and s[i-dp[i-1]-1] is '(', then it is valid parentheses
//then dp[i] = dp[i-1] +2 + dp[i-dp[i-1]-2] this last term is to check if there exists any valid parenthese before '('.
public int longestValidParentheses(String s){
	if(s.length() < 2) return 0;
	int[] dp = new int[s.length()];
	dp[0] = 0;
	int max = 0;
	for(int i = 1; i < s.length(); i++){
		if(s.charAt(i) == ')'){
			if(s.charAt(i-1) == '('){
				if(i > 1){
					dp[i] = dp[i-2];
				}
				dp[i] += 2;
			}else{
				int index = i-dp[i-1]-1;
				if(index >= 0 && s.charAt(index) == '('){
					dp[i] = dp[i-1]+2;
					if((i-dp[i-1]-2) >= 0){
						dp[i] += dp[i-dp[i-1]-2];
					}
				}
			}
		}
		max = Math.max(max, dp[i]);
	return max;
}

public int longestValidParentheses(String s) {
    if(s.length() < 2) return 0;
	int[] arr = {0};
	int max = 0;
	for(int i = 1; i < s.length(); i+=2){
		int[] temp = new int[s.length()-i];
		for(int p = 0; p +i < s.length(); p++){
			int q = p+i;

			if(s.charAt(p) == '(' && s.charAt(q) == ')') temp[p] = 1;
			else if(s.charAt(p) == ')' && s.charAt(q) == '(') temp[p] = -1;
			else temp[p] = -(s.length()+1);
			if(i != 1){
				temp[p] += arr[p+1];				
			}
            if(temp[p] >= 0){
                max = Math.max(max, i+1);
			}	
		}
        arr = temp;
	}
	return max;
}