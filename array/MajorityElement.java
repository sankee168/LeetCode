//Idea is to maintin counter. As question 
//says there is majority element for sure, count will be greater than 0 at the end of traversal.
//Time complexity: O(n)
//Space complexity: O(1)
public int majorityElement(int[] nums) {
	int count = 0;
	Integer maj = null;

	for(int curr: nums){
		if(count == 0){
			maj = curr;
		}
		if(curr == maj){
			count++;
		}else count--;
	}

	return maj;
}