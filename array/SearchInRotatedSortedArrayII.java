//Complexity: O(n)
public boolean search(int[] nums, int target) {
    if(nums.length == 0) return false;
	int i = 0;
	int j = nums.length;
	while(i < j){
		int mid = (i+j)/2;
		if(nums[mid] == target) return true;
		//check if first half is sorted
		if(nums[i] < nums[mid]){
			//check if number exists in left half
			if(target < nums[mid] && target >= nums[i]){
				j = mid;
			}else i = mid+1;
		}
		//check if first half is not sorted means right half is sorted
		else if(nums[mid] < nums[i]){
			if(target > nums[mid] && target < nums[i]){
				i = mid + 1;
			}else j = mid;
		}else{
			//as nums[i] == nums[mid] increment i
            i++;
        }
	}
	return false;
}