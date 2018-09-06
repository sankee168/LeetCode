//Idea is to use stack for this process.
//Iterate through the array and keep pushing the indices. 
//whenever you see an index value which is greater than set 
//those indices value in result array to curr value because this 
//is the next largest value
//when we see that we encounter the end of list, then we start again
public int[] nextGreaterElements(int[] nums){
	Stack<Integer> stack = new Stack<>();
	int[] res = int[nums.length];
	int reps = 0;
	while(reps < 2){
		for(int i = 0; i < nums.length; i++){
			while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
				res[stack.pop()] = nums[i];
			}
			if(reps == 0) stack.push(i);
		}
		reps++;
	}

	while(!stack.isEmpty()){
		res[stack.pop()] = -1;
	}
	return res;
}