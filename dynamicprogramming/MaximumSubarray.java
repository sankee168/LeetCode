//Time complexity: O(n)
//Space complexity: O(n)
//logic here is to check if previous sum < 0. If it is < 0 adding 
//it to next value will decrease overall sum. So that won't be greater than curr element. So ignore it. 
//recurrence relation will be
//Assume dp(i) will have max sum with sum ending with ith element
//So dp(i) = if(dp(i-1) > 0) dp(i-1) + (i) 
// else dp(i) = (i)
public int maxSubArray(int[] nums) {
	int n = nums.length;
	int[] dp = new int[n];
	int max = nums[0];
	dp[0] = nums[0];
	for(int i = 1; i < n; i++){
		if(dp[i-1] > 0){
			dp[i] = dp[i-1]+nums[i];
		}else{
			dp[i] = nums[i];
		}
		max = Math.max(max, dp[i]);
	}
	return max;
}

//as we notice that we are just dependent on the previous dp element. we just store than in one variable
//Time complexity: O(n)
//Space complexity: O(1)
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