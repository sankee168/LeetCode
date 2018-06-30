//Time compelxity: O(n)
//Space compelxity: O(1)
public int pivotIndex(int[] nums) {
	int sum = 0;
	int curSum = 0;
	for(int curr: nums){
		sum+=curr;
	}

	for(int i = 0; i < nums.length; i++){
		if(curSum*2 == sum-nums[i]){
			return i;
		}
		curSum+=nums[i];
	}

	return -1;
}