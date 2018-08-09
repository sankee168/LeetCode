//This is O(n) solution where we check each number's neighbors
//if it is first or last, we just check single neighbor
public int findPeakElement(int[] nums) {
    if(nums.length == 1) return 0;
    for(int i =0; i < nums.length; i++){
        if(i > 0 && i < nums.length-1){
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }else if(i == 0 && nums[i] > nums[i+1]) return i;
        else if(i == nums.length-1 && nums[i-1] < nums[i]) return i;
    }
    return -1;
}

//We can even decrease the complexity by doing binary search. Here we go to the side where local slope is the increasing
//Time complexity: O(logn)
public int findPeakElement(int[] nums){
	int i = 0; int j = nums.length-1;
	while(i <= j){
		if(i == j) return i;		
        if(j == i+1) {
            if(nums[i] > nums[j]) return i;
            else return j;
        }
		else{
			int mid = (i+j)/2;
			if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) return mid;
			else if(nums[mid] > nums[mid-1] && nums[mid+1] > nums[mid]) i = mid+1;
			else j = mid-1;
		}
	}
	return i;
}