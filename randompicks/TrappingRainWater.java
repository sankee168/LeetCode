//Here the basic idea is to find the adjacent highest bars at each index. so that we can find the water that can be stored 
public int trap(int[] height){
	Stack<Integer> stack = new Stack<>();
	int water = 0;
	int lastHeight = -1;
	for(int i = 0; i < height.length; i++){
		int curHeight = height[i];
		while(!stack.isEmpty() && height[stack.peek()] <= curHeight){
			int index = stack.pop();
			if(lastHeight == -1){
				water += height[index]*(i-index-1);
				lastHeight = height[index];
			}else{
				water += (height[index]-lastHeight)*(i-index-1);
                lastHeight = height[index];
			}
		}
        if(stack.isEmpty()) lastHeight = -1;
        else{
            water += (curHeight-lastHeight)*(i-stack.peek()-1);
        }
		stack.push(i);
	}
	return water;
}

//This is dynamic programming approach
//Main idea is to find the tallest to the right and tallest to the left
//Then water that can be stored is nothing but min of the both tallest bars - height of current index
//Time complexity: O(n)
//Space compelxity: O(n)
public int trap(int[] height){
	if(height.length == 0) return 0;
	int[] left = new int[height.length];
	int[] right = new int[height.length];
	left[0] = height[0];
	for(int i = 1; i < height.length; i++){
		left[i] = Math.max(left[i-1], height[i]);
	}

	right[height.length-1] = height[height.length-1];
	for(int i = height.length-2; i >=0; i--){
		right[i] = Math.max(right[i+1], height[i]);
	}

	int water = 0;
	for(int i = 0; i < height.length; i++){
		water += Math.min(left[i], right[i])-height[i];
	}
	return water;
}

//Time complexity: O(n)
//Space complexity: O(1)
//If we observe the dynamic programming approach, we keep a check on left max and right max
//till leftmax is less than right max, water till then is dependent on the left max itself
//when we reach the index on left where height is more than right max, then we come from right to left
public int trap(int[] height){
	if(height.length == 0) return 0;
	int l = 0, r = height.length-1;
	int water = 0;
	int leftMax = 0, rightMax = 0;
	while(l < r){
		if(height[l] < height[r]){
			if(height[l] >= leftMax) leftMax = height[l];
			else{
				water+= leftMax-height[l];
			}
			l++;
		}else{
			if(height[r] >= rightMax) rightMax = height[r];
			else water += rightMax-height[r];
			r--;
		}
	}
	return water;
}