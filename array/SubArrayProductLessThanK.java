//This is O(n^2) solution. Simple two loop
public int numSubarrayProductLessThanK(int[] nums, int k) {
	int count = 0;
	for(int i = 0; i < nums.length; i++){
		int curr = nums[i];
        if(curr >= k){continue;}
		count++;
		for(int j = i+1; j < nums.length; j++){
			if(curr*nums[j] < k){
                curr = curr*nums[j];
				count++;
			}else break;
		}
	}
	return count;
}

//Tricking solution. keep multipling the current element and add number of sub arrays from left to right index at every level. 
//when product is greater than k then start diving from left index and update the product. 
public int numSubarrayProductLessThanK(int[] nums, int k) {
	int count = 0;
	int prod = 1;
	int left = 0;
	for(int right = 0; right < nums.length; right++){
		prod *= nums[right];
		while(prod >= k && left <= right){
			prod /= nums[left];
			left++;
		}
		count += right-left+1;
	}
	return count;
}