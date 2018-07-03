//Time complexity: O(n)
//Space complexity: O(1)
public List<Integer> findDuplicates(int[] nums) {
	List<Integer> ans = new ArrayList<>();
	for(int curr: nums){
		int index = Math.abs(curr)-1;
		if(nums[index] < 0){
			ans.add(Math.abs(curr));
		}else{
			nums[index] = -1*nums[index];
		}
	}
	return ans;
}