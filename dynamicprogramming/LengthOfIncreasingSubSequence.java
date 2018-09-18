//main problem is to find the longest increasing subsequence. As given in the example, it is not continuous. 
//lets say dp[i] holds the length of longest increasing subsequence starting at i
//do recurrence relation willbe dp[i] = max(dp[i], if(nums[j] > nums[i] dp[j]+1)
//Time complexity: O(n2)
//Space complexity: O(n)
public int lengthOfLIS(int[] nums) {
	if(nums.length ==0) return 0;
	int[] dp = new int[nums.length];
	int max = 1;
	for(int i = nums.length-1; i >=0; i--){
		dp[i] = 1;
		for(int j = i+1; j < nums.length; j++){
			if(nums[j] > nums[i]){
				dp[i] = Math.max(dp[i], dp[j]+1);
				max = Math.max(dp[i], max);
			}
		}
	}

	return max;
}