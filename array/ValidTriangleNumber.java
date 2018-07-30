//Time complexity: O(n2)
//Space complexity: O(logn) for sorting
public int triangleNumber(int[] nums) {
	int count = 0;
	Arrays.sort(nums);
	for(int i = 0; i < nums.length-2; i++){
		int k = i+2;
		for(int j = i+1; j < nums.length-1 && nums[i] !=0;  j++){
			while(k < nums.length && ( nums[i]+ nums[j] > nums[k])){
				k++;
			}
			count += (k-j-1);			
		}
	}
	return count;
}


//Time complexity: O(n2+logn)
//Space complexity: O(logn) for sorting
public int triangleNumber(int[] nums){
	int count = 0; Arrays.sort(nums);
	for(int i = 0; i < nums.length-2; i++){
		for(int j = i+1; j < nums.length-1; j++){
			int k = binarySearch(nums, i, j);
			count += k-j-1;
		}
	}

	return count;
}

private int binarySearch(int[] nums, int i, int j){
	int p = j+1, q = nums.length-1;
	while(p <= q){
		int mid = (p+q)/2;
		if(nums[mid] >= nums[i] + nums[j]){
			q = mid-1;
		}else p = mid+1;
	}

	return p;
}