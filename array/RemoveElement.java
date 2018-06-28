//Time complexity: O(n)
//Space compelxity: O(1)
public int removeElement(int[] nums, int val) {
	int count = 0;
	int i = 0;
	int j = nums.length-1;
	while(i <= j){
		if(nums[i] == val && nums[j] !=val){
			nums[i] = nums[j];
			j--; i++;
		}else if(nums[j] == val){j--;}
		else if(nums[i] != val){i++;}
	}
	return j+1;
}