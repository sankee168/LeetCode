//If we find that mid element is target, then keep searching on both sides and keep updating res array
//Time complexity: O(logn)
//Space complexity: O(1)
public int[] searchRange(int[] nums, int target) {
	int[] res = new int[2];
	res[0] = -1;
	res[1] = -1;
	binarysearch(nums, 0, nums.length-1, target, res);
	return res;
}

private void binarysearch(int[] nums, int i, int j, int target, int[] res){
	if(i > j) return;
	int mid = (i+j)/2;
	if(target < nums[mid]){
		binarysearch(nums, i, mid-1, target, res);
	}else if(target > nums[mid]){
		binarysearch(nums, mid+1, j, target, res);
	}else{
        if(res[0] == -1){
            res[0] = mid;
            res[1] = mid;
        }else{
		    res[0] = Math.min(res[0], mid);
		    res[1] = Math.max(res[1], mid);
        }
		binarysearch(nums, i, mid-1, target, res);
		binarysearch(nums, mid+1, j, target, res);
	}
}

//in here we will be checking for nextnumber which is equal or higher than target
//start will be equal, end will be greater
public int[] searchRange(int[] nums, int target) {
	int[] res = new int[2];
	int start = findGreaterOrEqualElement(nums, target);
	if(start == nums.length || nums[start] != target) return new int[]{-1,-1};
	int end = findGreaterOrEqualElement(nums, target+1);

	res[0] = start; res[1] = end-1;
	return res;
}

private int findGreaterOrEqualElement(int[] nums, int target){
	int i = 0, j = nums.length;
	while(i < j){
		int mid = (i+j)/2;
		if(nums[mid] < target){
			i = mid+1;
		}else {
			j = mid;
		}
	}
	return i;
}