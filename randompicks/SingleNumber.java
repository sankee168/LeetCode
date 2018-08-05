//Idea behind this using XOR. 
//A XOR A will return 0
//A XOR B XOR A will return B which is what we need as there are all duplicates except one
//Time complexity: O(n)
//Space complexity: O(1)
public int singleNumber(int[] nums) {
	int val = nums[0];
	for(int i = 1; i < nums.length; i++){
		val ^= nums[i];
	}
	return val;
}