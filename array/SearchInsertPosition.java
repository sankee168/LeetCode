//Time complexity: O(n)
//Space complexity: O(1)
public int searchInsert(int[] nums, int target) {
	for(int i = 0; i < nums.length; i++){
		if(target <= nums[i]){
			return i;
		}
	}
	return nums.length;
}


//Time complexity: O(logn)
//Space complexity: O(1)
public int searchInsert(int[] nums, int target) {
    int i = 0;
    int j = nums.length;
    while(i < j){
        int m = (i+j)/2;
        if(nums[m] == target){
            return m;
        }
        if(nums[m] < target){
            i = m+1;
        }
        else{ j =             
            
    return j;
}
