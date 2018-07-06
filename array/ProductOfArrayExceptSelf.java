//Time complexity: O(n)
//Space complexity: O(1) excluding the return array
//first calculate the product of all the left elements in nums array and store it in result array
//next come from right. So that all the elements will be covered except the self
public int[] productExceptSelf(int[] nums) {
	int[] res = new int[nums.length];
	int n = nums.length;
	res[0] = 1;
	for(int i = 1; i < n; i++){
		res[i] = res[i-1]*nums[i-1];
	}

	int right = 1;
	for(int i = n-1; i>=0; i--){
		res[i] = res[i]*right;
		right = right*nums[i];
	}

	return res;
}