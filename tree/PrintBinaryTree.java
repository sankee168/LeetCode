//This is recursive solution. Time complexity: O(mn) Space complexity: O(mn) 
//where m is the number of rows and n is number of cols
public List<List<String>> printTree(TreeNode root) {
	int h = height(root);
	String[][] res = new String[h][(1 << h) -1];
	for(int i = 0; i < res.length; i++){
		for(int j = 0; j < res[0].length; j++){
			res[i][j] = "";
		}
	}

	util(res, 0, 0, res[0].length, root);
	List<List<String>> val = new ArrayList<>();
	for(String[] arr: res){
		val.add(Arrays.asList(arr));
	}

	return val;
}

private void util(String[][] res, int i,  int l, int r, TreeNode root){
	if(root == null) return;
	res[i][(l+r)/2] = String.valueOf(root.val);
	util(res, i+1, l , (l+r)/2 -1, root.left);
	util(res, i+1, (l+r)/2 +1, r,  root.right);
}

private int height(TreeNode root){
	if(root == null) return 0;
	int l = height(root.left);
	int r = height(root.right);
	return Math.max(l, r) + 1;
}

