//Update boolean array at i index where i is current value in nums array. 
// traverse through the boolean array and which ever is false is missing number in 1 to n
//Time complexity: O(n)
//Space complexity: O(n)
public List<Integer> findDisappearedNumbers(int[] nums) {
	List<Integer> list = new ArrayList<>();
	boolean[] arr = new boolean[nums.length];
	for(int i: nums){
		arr[i-1] = true;
	}

	for(int i = 0; i < arr.length; i++){
		if(!arr[i]){
			list.add(i+1);
		}
	}

	return list;
}

//Same approach but using the nums array itself to
//keep space complexity as O(1) not counting list which is being returned
public List<Integer> findDisappearedNumbers(int[] nums) {
	List<Integer> list = new ArrayList<>();
	for(int i = 0; i < nums.length; i++){
		int index = Math.abs(nums[i])-1;
		nums[index] = -1*Math.abs(nums[index]);
	}

	for(int i = 0; i < nums.length; i++){
		if(nums[i] > 0){
			list.add(i+1);
		}
	}

	return list;
}