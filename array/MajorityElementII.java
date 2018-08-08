//Here we will be using Boyer-Moore algorithm. As noticed there can be only max of 2 elements with more than n/3 frequency. 
//logic is mainly like last man standing
//lets assume two elements have more than n/3 frequency. then rest of the numbers combinely should be less than n/3. 
//If you substract the count, it should be >0 for those numbers but we are not sure. If there is no majority element, we keep 
//overriding the maj1 and maj2 so we can't be sure. 
//To make sure we loop again and check the frequency of the found element 
//Time complexity: O(n)
//Space complexity: O(n) for result array
public List<Integer> majorityElement(int[] nums) {
	List<Integer> list = new ArrayList<>();
	if(nums.length == 0) return list;
	int maj1 = nums[0], maj2 = nums[0], count1 = 0, count2 = 0;
	for(int i = 0; i < nums.length; i++){
		if(nums[i] == maj1){
			count1++;
		}else if(nums[i] == maj2){
			count2++;
		}else if(count1 == 0){
			maj1 = nums[i];
			count1 = 1;
		}else if(count2 == 0){
			maj2 = nums[i];
			count2 = 1;
		}else{
			count1--;
			count2--;
		}
	}

	count1 = 0; count2 = 0;
	for(int curr: nums){
		if(curr == maj1) count1++;
		else if(curr == maj2) count2++;
	}

	if(count1 > nums.length/3) list.add(maj1);
	if(count2 > nums.length/3) list.add(maj2);
	return list;
}