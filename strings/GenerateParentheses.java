public List<String> generateParenthesis(int n) {
	List<String> list = new ArrayList<>();
	if(n == 0) return list;
	char[] arr = new char[2*n];
	util(list, arr, 0, 0, n);
	return list;
}

private void util(List<String> list, char[] arr, int p, int q, int n){
	if(p == n && q == n) {
		list.add(String.valueOf(arr));
		return;
	}
	if(p < n){
		arr[p+q] = '(';
		util(list, arr, p+1, q, n);
	}

	if(q < p){
		arr[p+q] = ')';
		util(list, arr, p, q+1, n);
	}
}