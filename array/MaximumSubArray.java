//Time complexity: O(n)
//Space complexity: O(1)
//logic here is to check if previous sum < 0. If it is < 0 adding 
//it to next value will decrease overall sum. So that won't be greater than curr element. So ignore it. 
public int maxSubArray(int[] nums) {
	int max = nums[0];
	int curMax = nums[0];

	for(int i = 1; i < nums.length; i++){
		if(curMax > 0){
			curMax+=nums[i];
		}else{
			curMax = nums[i];
		}

		max = Math.max(max, curMax);
	}
	return max;
}