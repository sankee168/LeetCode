//Idea here is to build maximal rectangle with each row as base. 
//So if we pick every row and 1s in it. that represents the height of bars starting from that row
//So this problem has transferred into histogram area problem
//Time complexity: O(mn) where m is the number of rows and n is the number of columns
//Space complexity: O(n)
public int maximalRectangle(char[][] matrix) {
	int m = matrix.length;
	if(m == 0) return 0;
	int n = matrix[0].length;
	int[] histogram = new int[n];
	int maxArea = 0;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(matrix[i][j] == '0'){
				histogram[j] = 0;
			}else histogram[j]++;
		}

		maxArea = Math.max(maxArea, hArea(histogram));
	}
	return maxArea;
}


public int hArea(int[] height){
	Stack<Integer> stack = new Stack<>();
	int maxArea = 0;
	for(int i = 0; i < height.length; i++){
		while(!stack.isEmpty() && height[stack.peek()] > height[i]){
			int top = stack.pop();
			int area = 0;
			if(stack.isEmpty()){
				area = height[top]*i;
			}else{
				area = height[top]*(i-1-stack.peek());
			}
			maxArea = Math.max(maxArea, area);
		}
		stack.push(i);
	}

	while(!stack.isEmpty()){
		int area = 0;
		int top = stack.pop();
		if(stack.isEmpty()){
			area = height[top]*(height.length);
		}else{
			area = height[top]*(height.length-1-stack.peek());
		}
		maxArea = Math.max(maxArea, area);
	}
	return maxArea;
}