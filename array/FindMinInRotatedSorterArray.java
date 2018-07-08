public int findMin(int[] nums) {
	int i = 0;
	int j = nums.length-1;
	while(i <= j){
		int mid = (i+j)/2;
		if(j-i <= 1) return Math.min(nums[i], nums[j]);
		if(nums[i] < nums[mid] && nums[mid] < nums[j]){
			return nums[i];
		}else if(nums[j] < nums[mid]){
			i = mid;
		}else {
			j = mid;
		}
	}
	return nums[0];
}