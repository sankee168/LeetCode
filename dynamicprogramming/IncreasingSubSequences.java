//This is another form of backtracking problem. We have to find all the combinations of the sub sequences here. 
//Time complexity: O(n!)
//Space complexity: O(n2)
public List<List<Integer>> findSubsequences(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
	if(nums.length == 0) return res;
	util(nums, 0, new ArrayList<Integer>(), res);
	return res;
}

private void util(int[] nums, int start, List<Integer> curr, List<List<Integer>> res){
	if(curr.size() >= 2) res.add(new ArrayList<>(curr));
	if(start == nums.length) return;
	Set<Integer> set = new HashSet<>();
	for(int i = start; i < nums.length; i++){
		if(set.contains(nums[i])) continue;
		if((curr.size() == 0) || (nums[i] >= curr.get(curr.size()-1))){
			set.add(nums[i]);
			curr.add(nums[i]);
			util(nums, i+1, curr, res);
			curr.remove(curr.size()-1);
		}
	}
	return;
}