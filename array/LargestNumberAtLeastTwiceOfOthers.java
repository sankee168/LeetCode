// Time complexity: O(n)
// Space complexity: O(1)
public int dominantIndex(int[] nums) {
	int max1 = Integer.MIN_VALUE;
	int max2 = Integer.MIN_VALUE;
	int i = -1;
	int j = -1;
	for(int k = 0; k < nums.length; k++){
		if(nums[k] >= max1){
			max2 = max1;
			max1 = nums[k];
			j = i;
			i = k;
		}else if(nums[k] >= max2){
			max2 = nums[k];
			j = k;
		}
	}

	if(max2*2 <= max1){
		return i;
	}
	return -1;
}