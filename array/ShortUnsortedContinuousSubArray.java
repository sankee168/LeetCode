//Idea here is to use the stack to keep track of correct index of given element
//Do this from start of array and end of the array
//Time complexity: O(n)
//Space complexity: O(n) for stacks
public int findUnsortedSubarray(int[] nums) {
	Stack<Integer> stack = new Stack<>();
	int min = nums.length;
	int max = 0;
	for(int i = 0; i < nums.length; i++){
		if(stack.size() == 0){
			stack.push(nums[i]);
		}else{
			if(stack.peek() > nums[i]){
				while(!stack.isEmpty() && stack.peek() > nums[i]){
					stack.pop();
				}
				min = Math.min(min, stack.size()-1);				
			}
			stack.push(nums[i]);
		}
	}

	stack = new Stack<>();
	for(int i = nums.length-1; i >= 0; i--){
		if(stack.size() == 0){
			stack.push(nums[i]);
		}else{
			if(stack.peek() < nums[i]){
				while(!stack.isEmpty() && stack.peek() < nums[i]){
					stack.pop();
				}
				max = Math.max(max, nums.length-stack.size()-1);				
			}
			stack.push(nums[i]);
		}
	}

	if(max-min > 0){
		return max-min+1;
	}
	return 0;
}

//tricky solution. needs a very good thinking into this
//whenever there is the negative slope, that means our required 
//array has started. but we are not sure if that is the least element. So traverse through rest of the array and determine if there is any minimum existing. 
//Similary do that from end of the array but look of posotive slope and number greater than that.
//Now that you have min and max. Figure out what is the correct indices for those values. 
//difference should give the length of the array
//Time complexity: O(n)
//Space complexity: O(1)
public int findUnsortedSubarray(int[] nums) {
	int min = nums.length-1;
	int max = 0;

	for(int i = 1; i < nums.length; i++){
		if(nums[i-1] > nums[i]){
			min = i;
			while(i < nums.length){
				if(nums[i] < nums[min]){
					min = i;
				}
				i++;
			}
		}
	}

	for(int i = nums.length-2; i >=0; i--){
		if(nums[i+1] < nums[i]){
			max = i;
			while(i >= 0){
				if(nums[i] > nums[max]){
					max = i;
				}
				i--;
			}
		}
	}
    System.out.println(max + " " + min);
	for(int i = 0; i < nums.length; i++){
		if(nums[i] > nums[min]){
			min = i;
			break;
		}
	}

	for(int i = nums.length-1; i >= 0; i--){
		if(nums[i] < nums[max]){
			max = i;
            break;
		}
	}
    System.out.println(max + " " + min);
	if(max-min > 0) return max-min+1;
	return 0;
}