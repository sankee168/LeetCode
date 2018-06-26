//Time complexity: O(nlogn)
//Space complexity: O(1)
public int arrayPairSum(int[] nums) {
	Arrays.sort(nums);
	int sum = 0;
	for(int i = 0; i < nums.length; i++){
		sum += nums[i]; i++;
	}
	return sum;
}