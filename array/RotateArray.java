//Space complexity: O(k)
//Time complexity: O(n+k)
public void rotate(int[] nums, int k) {
	k  = k%nums.length;
	if(k == 0) return;
	int[] temp = new int[k];
	int j = 0;
	for(int i = nums.length-k; i < nums.length; i++){
		temp[j++] = nums[i];
	}

	j = nums.length-1;
	for(int i = nums.length-k-1; i >=0; i--){
		nums[j--] = nums[i];
	}

	for(int i = 0; i < k; i++){
		nums[i] = temp[i];
	}
}
