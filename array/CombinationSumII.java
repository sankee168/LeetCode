//Time complexity: O(n!) where n is the size of the candidates
//Space complexity: O(m) where m is the size of the return list

//Trick here is to sort the candidates array so that we can skip if two consequtive elements are same
public List<List<Integer>> combinationSum2(int[] candidates, int target) {
	Arrays.sort(candidates);
	List<List<Integer>> list = new ArrayList<>();
	backtrack(list, new ArrayList<>(), candidates, target, 0);
	return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> curr, int[] candidates, int remain, int start){
	if(remian < 0) return ;
	if(remain == 0) {
		list.add(new ArrayList<>(curr));
		return;
	}
	for(int i = start; i < candidates.length; i++){
		//it there are two same numbers, that combination would have been covered when i=start. 
		//So it is not necessary to go over the same combination again. Hence skip it. 
		if(i > start && candidates[i] == candidates[i-1]) continue;
		curr.add(candidates[i]);
		//As we don't want duplicate elements we are looking from i+1. If repeatations are allowed then, we would keep it at i.
		backtrack(list, curr, candidates, remain-candidates[i], i+1);
		curr.remove(curr.size()-1);
	}
}