//Time complexity: O(p!) here p is 9
//Space complexity: O(m) where m is the size of the list
public List<List<Integer>> combinationSum3(int k, int n) {
	List<List<Integer>> list = new ArrayList<>();
	util(list, new ArrayList<>(), k , n, 1);
	return list;
}

private void util(List<List<Integer>> list,  List<Integer> curr, int k, int n, int start){
	if(k == 0 && n == 0){
		list.add(curr); return;
	}else if(k == 0) return;
	else if(n < 0) return;
	for(int i = start; i < 10; i++){
		curr.add(i); 
		util(list, curr, k-1, n-i, i+1);
		curr.remove(curr.size()-1);
	}
}