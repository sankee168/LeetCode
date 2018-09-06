public int[] dailyTemperatures(int[] temperatures){
	int n = temperatures.length;
	if(n == 0) return temperatures;
	int[] arr = new int[n];
	int j = 0;
	for(int i = 0; i < n; i++){
		if(i == j){
			j = i+1;
			while(j < n && temperatures[i] >= temperatures[j]){
				j++;
			}
		}

		if(j == n) arr[i] = 0;
		else arr[i] = j-i;
	}
	return arr;
}

public int[] dailyTemperatures(int[] temperatures){
	Stack<Integer> stack = new Stack<>();
	int n = temperatures.length;
	if(n == 0) return temperatures;
	int[] res = new int[n];
	for(int i = n-1; i >= 0; i--){
		while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) stack.pop();
		if(stack.isEmpty()) res[i] = 0;
		else res[i] = stack.peek()-i;

		stack.push(i);
	}
	return res;
}

public int[] dailyTemperatures(int[] temperatures){
	Stack<Integer> stack = new Stack<>();
	int n = temperatures.length;
	if(n == 0) return temperatures;
	int[] res = new int[n];
	for(int i = 0; i < n; i++){
		while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
			int index = stack.pop();
			res[index] = i-index;
		}
		stack.push(i);
	}
	return res;
}