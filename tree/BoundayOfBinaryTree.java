public List<Integer> boundaryOfBinaryTree(TreeNode root) {
	List<Integer> ans = new ArrayList<>();
	if(root == null) return ans;
	if(root.left != null || root.right != null){
		ans.add(root.val);
	}
	getLeftBoundary(root.left, ans);
	getLeaves(root, ans);
	getRightBoundary(root.right, ans);        
	return ans;
}

private void getLeftBoundary(TreeNode root, List<Integer> ans){
	TreeNode curr = root;
	if(curr == null) return;
	while(!(curr.left == null && curr.right == null)){
		ans.add(curr.val);
		if(curr.left != null) curr = curr.left;
		else curr = curr.right;
	}
}

private void getRightBoundary(TreeNode root, List<Integer> ans){
	TreeNode curr = root;
	if(curr == null) return;
	Stack<TreeNode> stack = new Stack<>();
	while(!(curr.left == null && curr.right == null)){
		stack.push(curr);
		if(curr.right != null) curr = curr.right;
		else curr = curr.left;
	}

	while(!stack.isEmpty()){
		ans.add(stack.pop().val);
	}
}

private void getLeaves(TreeNode root, List<Integer> ans){
	if(root.left == null && root.right == null) ans.add(root.val);
	else{
		if(root.left != null) getLeaves(root.left, ans);
		if(root.right != null) getLeaves(root.right, ans);
	}
}