public void moveZeroes(int[] nums) {
	int i = 0,j = 0;
	while(i < nums.length && j < nums.length){
		if(nums[i] == 0){
			j = i;
			while(j < nums.length && nums[j] == 0){
				j++;
			}
			if(j != nums.length){
				nums[i] = nums[j];
				nums[j] = 0;
			}else break;
		}
        i++;
	}
}


//Idea here is bit tricky. traverse through the array. if you find non-zero update at the index location.
//Update every element after index to 0. Done
public void moveZeroes(int[] nums){
	int index = 0;
	for(int curr: nums){
		if(curr != 0){
			nums[index++] = curr;
		}
	}

	for(int i = index; i< nums.length; i++){
		nums[i] = 0;
	}
}


//This approach is very similar to previous one but you update the current element with 0 in the same step
public void moveZeroes(int[] nums){
	int index = 0;	
	for(int i = 0; i < nums.length; i++){
		if(nums[i] != 0){
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
			index++;
		}
	}
}