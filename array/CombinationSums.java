//Backtracking problem
//We have to try all combinations of the candidates to find it out
//Tiime complexity: O(n!) where n is the size of the candidates array
//Space complexity: O(m) m is the size of the return list
public List<List<Integer>> combinationSum(int[] candidates, int target) {
	List<List<Integer>> arr =  new ArrayList<>();
	backtrack(arr, new ArrayList<>(), candidates, target, 0);
	return arr;
}

private void backtrack(List<List<Integer>> arr, List<Integer> curr, int[] candidates, int target, int start){
	if(target == 0) {
		arr.add(new ArrayList<>(curr));
		return;
	}
	if(target < 0){
		return;
	}
	for(int i = start; i < candidates.length; i++){
		curr.add(candidates[i]);
		backtrack(arr, curr, candidates, target-candidates[i], i);
		curr.remove(curr.size()-1);
	}
}