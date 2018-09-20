public int findMin(int[] nums) {
	int i = 0;
	//as our search space is inside nums, we can have upper bound to be last element
	int j = nums.length-1;
	while(i <= j){
		int mid = (i+j)/2;
		//if there are only two elements to search
		if(j-i <= 1) return Math.min(nums[i], nums[j]);
		//if everything is sorted then return start
		if(nums[i] < nums[mid] && nums[mid] < nums[j]){
			return nums[i];
		}else if(nums[i] < nums[mid]){
			//if first half is sorted and other is not. then min lies in second half
			//we have to consider mid too because we don't have a check on mid anywhere
			i = mid;
		}else {
			j = mid;
		}
	}
	return nums[0];
}


public int findMin(int[] nums) {
	int i = 0;
	int j = nums.length;
	while(i < j){
		int mid = (i+j)/2;
		if(j-i <= 1) return Math.min(nums[i], nums[j-1]);
		if(mid > 0 && nums[mid] < nums[mid-1]){
			return nums[mid];
		}else if(nums[i] < nums[mid] && nums[j-1] < nums[mid]){
			i = mid+1;
		}else j = mid;
	}

	return nums[0];
}


int findMin(int arr[], int low, int high)
    {
        // This condition is needed to handle the case when array
        // is not rotated at all
        if (high < low)  return arr[0];
 
        // If there is only one element left
        if (high == low) return arr[low];
 
        // Find mid
        int mid = low + (high - low)/2; /*(low + high)/2;*/
 
        // Check if element (mid+1) is minimum element. Consider
        // the cases like {3, 4, 5, 1, 2}
        if (mid < high && arr[mid+1] < arr[mid])
            return arr[mid+1];
 
        // Check if mid itself is minimum element
        if (mid > low && arr[mid] < arr[mid - 1])
            return arr[mid];
 
        // Decide whether we need to go to left half or right half
        if (arr[high] > arr[mid])
            return findMin(arr, low, mid-1);
        return findMin(arr, mid+1, high);
    }