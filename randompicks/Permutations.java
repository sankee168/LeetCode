//We iterate over each entry in nums and set the index in element and add that number to set
//then for next position we again check all the element but which are not present in the set. 
//Time complexity: 
public List<List<Integer>> permute(int[] nums) {
	List<List<Integer>> res = new ArrayList<>();
    if(nums.length == 0) return res;
	generatePermutations(nums, res, 0, new ArrayList<Integer>(), new HashSet<Integer>());
	return res;
}

private void generatePermutations(int[] nums, List<List<Integer>> result, int index, List<Integer> curr, Set<Integer> set){
	if(index == nums.length){
		result.add(new ArrayList<>(curr));
		return;
	}

	for(int i = 0; i < nums.length; i++){
		if(set.contains(nums[i])) continue;
		curr.add(nums[i]);
		set.add(nums[i]);
		generatePermutations(nums, result, index+1, curr, set);
		curr.remove(curr.size()-1);
		set.remove(nums[i]);
	}
}