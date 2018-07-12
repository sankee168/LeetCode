//Time complexity: O(n^2)
//Space complexity: O(1)
//Simple solution with two pointers
public int threeSumClosest(int[] nums, int target) {
	Arrays.sort(nums);
	int val = nums[0]+nums[1]+nums[2];
	for(int i = 0; i < nums.length-2; i++){
		int start = i+1;
		int end = nums.length-1;
		while(start < end){
			int temp = nums[i] + nums[start] + nums[end];
			if(Math.abs(temp-target) < Math.abs(val-target)) {
				val = temp;
			}
			if(temp < target){
				start++;
			}else end--;
		}
	}
	return val;
}