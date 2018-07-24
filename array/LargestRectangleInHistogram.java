//This is bit tricky solution using stacks. 
//Keep inserting indices into stack such that if height of the top element in stack is less than to-be-inserted index stack. 
//if height of to-be-inserted is less than top most stack index's height, calculate the area occupied with top most index.
//if stack is not empty, then top index covers the width from next top element index to current to-be-inserted element
//if stack is empty, then index's width covers from beginning to current index
public int largestRectangleArea(int[] heights) {
     if(heights.length == 0) return 0;
	Stack<Integer> stack = new Stack<>();
	int maxArea = -1;
	for(int i = 0; i < heights.length; i++){
		int area = 0;
		if(stack.isEmpty()){
			stack.push(i);
		}else{
			if(heights[i] >= heights[stack.peek()]){
				stack.push(i);
			}else{
				while(!stack.isEmpty() && heights[stack.peek()] > heights[i]){
					int p = stack.pop();
					if(stack.isEmpty()){
						area = heights[p]*(i);
					}else{
						area = heights[p]*(i-stack.peek()-1);
					}
					maxArea = Math.max(maxArea, area);
				}
				stack.push(i);
			}
		}
	}

	while(!stack.isEmpty()){
		int area = 0;
		int p = stack.pop();
		if(stack.isEmpty()){
			area = heights[p]*(heights.length);
		}else{
			area = heights[p]*(heights.length-stack.peek()-1);
		}
		maxArea = Math.max(maxArea, area);
	}

	return maxArea;
}