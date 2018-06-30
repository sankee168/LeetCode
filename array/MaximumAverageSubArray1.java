//Time complexity: O(n)
//Space complexity: O(1)
public double findMaxAverage(int[] nums, int k) {
	int start = 0;
	int end = k;
	int sum = 0;

	for(int i = start; i < end; i++){
		sum += nums[i];
	}

	int maxSum = sum;

	while(end < nums.length){
		sum = sum + nums[end] - nums[start];
		maxSum = Math.max(sum, maxSum);
		start++; end++;
	}

	return (maxSum/(double) k);
}