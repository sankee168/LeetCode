//Time complexity: O(n)
//Space complexity: O(1)
public int[] twoSum(int[] nums, int target) {
	Map<Integer, Integer> map = new HashMap<>();
	int[] ans = new int[2];
	for(int i = 0; i < nums.length; i++){
		int curr = nums[i];
		int countercount = map.getOrDefault(target-curr, -1);
		if(countercount != -1){
			ans[1] = i;
			ans[0] = countercount;
			break;
		}
		map.put(curr, i);
	}
	return ans;
}