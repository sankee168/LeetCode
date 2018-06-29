//time compelxity: O(numRows^2)
//space compelxity: O(numRows^2)
public List<List<Integer>> generate(int numRows) {
	List<List<Integer>> ans = new ArrayList<>();
	for(int i = 0; i < numRows; i++){
		List<Integer> curr = new ArrayList<>();
		curr.add(1);
		for(int j = 1; j < i; j++){
			curr.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
		}
		if(i != 0){
			curr.add(1);
		}
		ans.add(curr);
	}
	return ans;
}