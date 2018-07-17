//Trick here is to use right index to determine which half you should be traversing
//Time complexity: O(n)
//Space compelexity: O(1)
public int findMin(int[] nums) {
	int i = 0; 
	int j = nums.length-1;
	while(i<j){
		int mid = (i+j)/2;
		
		if(nums[mid] > nums[j]) i = mid+1;
		else if(nums[mid] < nums[j]){
			j = mid;
		}else j--;
	}

	return nums[i];
}
