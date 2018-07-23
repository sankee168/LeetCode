//This is a math solution. Inorder to make result larger, we have to minimize denominator
//Time complexity: O(n)
//Space complexity: O(n) for storing result
public String optimalDivision(int[] nums) {
	if(nums.length == 1) return String.valueOf(nums[0]);
	if(nums.length == 2) return String.valueOf(nums[0] + "/" + nums[1]);
	StringBuilder sb = new StringBuilder();
	sb.append(nums[0] + "/" + "(" + nums[1]);
	for(int i = 2; i < nums.length; i++){
		sb.append("/ " + nums[i]);
	}
	sb.append(")");
	return sb.toString();
}