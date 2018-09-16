//We can direclty think of skipping next element and compare two sums but there is chance that robber might have to skip 2 houses in the middle. 
//So f(i) is the max amount then f(i) = Math.max(f(i-2), f(i-3)) + nums[i];
//This means either he can skip one house or two houses. if he skips more than 3 houses he might as well pick in i-2 location. 
//Time complexity: O(n)
//Space complexity: O(1) as we are reusing the same array
public int rob(int[] nums) {
	if(nums.length == 0) return 0;
	if(nums.length == 1) return nums[0];
	int prev = 0;
	for(int i = 2; i < nums.length; i++){
		nums[i] += Math.max(nums[i-2], prev);
		prev = nums[i-2];
	}

	return Math.max(prev, cur);
}

//This is same implementation but we don't update the array rather we maintain the f(i-3) and f(i-2) in the variables and keep updating them
public int rob(int[] nums){
	int p1 = 0;
	int p2 = 0;
	for(int i = 0; i < nums.length; i++){
		int temp = p1;
		p1 = Math.max(p1, p2+nums[i]);
		p2 = temp;
	}
	return p1;
}

//dp function maximum amount robber can gain if he robs ith house
public int rob(int[] nums){
    int m = nums.length;
    if(m == 0) return 0;
	int[] dp = new int[m+2];
    dp[0] = 0;
    dp[1] = 0;
    dp[2] = nums[0];
    for(int i = 3; i< m+2; i++){
        dp[i] = Math.max(dp[i-2], dp[i-3])+nums[i-2];  
    }
    return Math.max(dp[m+1], dp[m]);
}