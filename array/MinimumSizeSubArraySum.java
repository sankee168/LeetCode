//lets have a sliding window from (i, j) and keep a check on sum. if sum is greater than given input, 
//we move the ith index and substract the value from sum. During this we need to check of min length
//Time complexity: O(n)
//Space complexity: O(1)
public int minSubArrayLen(int s, int[] nums) {
	int min = Integer.MAX_VALUE;
	int i = 0, j = 0, curSum = 0;
	while(j < nums.length){
		curSum += nums[j];
		if(curSum >= s){
			min = Math.min(min, j-i+1);
		}

		while(curSum >= s){
			curSum -= arr[i];
			i++;
		}
	}

	return min;
}