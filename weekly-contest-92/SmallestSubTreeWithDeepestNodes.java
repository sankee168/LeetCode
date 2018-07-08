public TreeNode subtreeWithAllDeepest(TreeNode root) {
	int h = height(root);
    if(h <= 1) return root;
	return dfs(root, h-1);
}

private int height(TreeNode root){
	if(root == null) return 0;
	int l = height(root.left);
	int r = height(root.right);
	return Math.max(l, r) + 1;
}

private TreeNode dfs(TreeNode root, int h){
	if(root == null) return null;
	if(h == 0) return root;

	TreeNode left = dfs(root.left, h-1);
	TreeNode right = dfs(root.right, h-1);
	if(left != null && right != null){
		return root;
	}else if(left != null) return left;
	else if(right != null) return right;
	return null;
}