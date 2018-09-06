public List<List<Integer>> permuteUnique(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	if(nums.length == 0) return res;
	Arrays.sort(nums);
	backtrack(nums, res, 0, new ArrayList<Integer>(), new boolean[nums.length]);
	return res;
}

private void backtrack(int[] nums, List<List<Integer>> result, int index, List<Integer> curr, boolean[] visited){
	if(index == nums.length){
		result.add(new ArrayList<>(curr));
		return;
	}

	for(int i = 0; i < nums.length; i++){
		if(visited[i] || (i > 0 && (nums[i] == nums[i-1]) && visited[i-1])) continue;
		curr.add(nums[i]);
		visited[i] = true;
		backtrack(nums, result, index+1, curr, visited);
		curr.remove(curr.size()-1);
		visited[i] = false;
	}
}