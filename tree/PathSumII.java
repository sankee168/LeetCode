public List<List<Integer>> pathSum(TreeNode root, int sum) {
	List<List<Integer>> ans = new ArrayList<>();
	List<Integer> curr = new ArrayList<>();
	pathSum(root, sum, ans, curr);
	return ans;
}

//Trick here is to keep removing last element from the list after recursive call so that next block of code will have correct list
private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> curr){
	if(root == null) return;
	if(root.left == null && root.right == null && root.val == sum){
		curr.add(root.val);
		res.add(new ArrayList<>(curr));		
		curr.remove(curr.size()-1);
	}
	if(root.left != null){
		curr.add(root.val);
		pathSum(root.left, sum-root.val, res, curr);
		curr.remove(curr.size()-1);
	}
	if(root.right != null){
		curr.add(root.val);
		pathSum(root.right, sum-root.val, res, curr);
		curr.remove(curr.size()-1);
	}
}