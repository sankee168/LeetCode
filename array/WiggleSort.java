//Time complexity: O(n)
//Space complexity: O(1)
public void wiggleSort(int[] nums) {
	boolean isGreater = false;
	for(int i = 0; i < nums.length-1; i++){
		if(isGreater){
			if(nums[i] < nums[i+1]){
				int temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
		}
		else{
			if(nums[i] > nums[i+1]){
				int temp =  nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;
			}
		}

		isGreater = !isGreater;
	}
}