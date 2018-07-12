//Trick here is to calculate the maxProduct and minProduct ending at i index. 
//Time complexity: O(n)
//Space complexity: O(1)
public int maxProduct(int[] nums) {
	if(nums.length == 0) return 0;
	int max = nums[0];
	int maxPre = nums[0];
	int minPre = nums[0];
	for(int i = 1; i < nums.length; i++){
		if(nums[i] < 0){
			int temp = maxPre;
			maxPre = minPre;
			minPre = temp;
		}

		maxPre = Math.max(maxPre*nums[i], nums[i]);
		minPre = Math.min(minPre*nums[i], nums[i]);
		max = Math.max(maxPre, max);
	}
	return max;
}