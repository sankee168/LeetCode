//Simple backtracking solution
//Time complexity: O(n!)
//Space complexity: O(n) if recurring call stack is considered
public List<List<Integer>> subsets(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	util(nums, res, new ArrayList<Integer>(), 0);
	return res;
}

private void util(int[] nums, List<List<Integer>> res, List<Integer> curr, int start){
	res.add(new ArrayList<>(curr));
	if(start >= nums.length) return;
	for(int i = start; i < nums.length; i++){
		curr.add(nums[i]);
		util(nums, res, curr, i+1);
		curr.remove(curr.size()-1);
	}
}