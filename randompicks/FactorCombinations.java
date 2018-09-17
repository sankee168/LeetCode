//we start from trying 2 as a factor. if 2 is a factor, then we recursively call the quotient with that i
//by now we will have all combinations of factors which includes i. now increase it to next integer and try again
//Time complexity: O(nlogn)
public List<List<Integer>> getFactors(int n) {
	List<List<Integer>> ans = new ArrayList<>();
	dfs(ans, new ArrayList<Integer>(), n, 2);
	return ans;
}

private void dfs(List<List<Integer>> res, List<Integer> curr, int n, int start){
	if(n == 1){
		if(curr.size() > 1) res.add(new ArrayList<>(curr));
		return;
	}

	for(int i = start; i <= n; i++){
		if(n%i == 0){
			curr.add(i);
			dfs(res, curr, n/i, i);
			curr.remove(curr.size()-1);
		}
	}
}