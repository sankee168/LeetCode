//Time complexity: O(logn)
//Space complexity: O(1)
//here we have to check which of the halves are sorted. 
//based on that info, we can decide if we have to do binary search in left or right half
public int search(int[] nums, int target) {
	if(nums.length == 0) return -1;
	int i = 0;
	int j = nums.length;
	while(i < j){
		int mid = (i+j)/2;
		if(target == nums[mid]) return mid;
		//check if left is sorted
		if(nums[i] <= nums[mid]){
			//check if target is in left half
			if(target < nums[mid] && target >= nums[i]){
				j = mid;
			}else i = mid+1;
		//else right is sorted
		}else {
			//check if target is in right half
			if(target < nums[i] && target > nums[mid]){
				i =mid+1;
			}else {
				j = mid;
			}
		}
	}
	return -1;
}