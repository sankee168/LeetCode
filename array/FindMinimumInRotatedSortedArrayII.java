//rotated
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


//lets look at the use cases. 
//three types 
//1. whole array is completely sorted we have consider equality on the right half
//2. min lies in the left 
//3. min lies in the right
public int findMin(int[] nums) {
	int i = 0; 
	int j = nums.length-1;
	while(i<=j){
        if(j-i <= 1) return Math.min(nums[i], nums[j]);
		int mid = (i+j)/2;
		if(nums[i] < nums[mid] && nums[mid] <= nums[j]) j = mid;
		else if(nums[i] > nums[mid]) j = mid;
		else if(nums[mid] > nums[j]) i = mid;
		else i++;
	}
	return nums[i];
}