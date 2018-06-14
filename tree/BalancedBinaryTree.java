public boolean isBalanced(TreeNode root) {
	if(util(root) == -1) return false;
	return true;
}

private int util(TreeNode root){
	if(root == null) return 0;

	int l = util(root.left);
	int r = util(root.right);

	if(l == -1 || r == -1) return -1;
	if(Math.abs(l-r) > 1) return -1;
	return Math.max(l , r) + 1;
}