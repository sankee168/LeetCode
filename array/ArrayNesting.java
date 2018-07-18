//Time complexity: O(n)
//Space complexity: O(1)
//Logic here is to identify if you have visited previous index.
//Either we can negate the value in the array or change it to max_value. 
//If we want to negate, we have to add +1 to it because we can't be sure if we have visited index with value 0.
public int arrayNesting(int[] nums) {
	for(int i = 0; i < nums.length; i++){
		nums[i]++;
	}
	int maxCount = 0;

	for(int i = 0; i < nums.length; i++){
		if(nums[i] < 0){continue;}
		int start = i;
		int count = 0;
		while(nums[start] > 0){
			nums[start] = -nums[start];
			start = Math.abs(nums[start])-1;
			count++;
		}

		if(count == nums.length){
			return count;
		}else maxCount = Math.max(count, maxCount);
	}

	return maxCount;
}