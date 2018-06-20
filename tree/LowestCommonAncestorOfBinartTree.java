public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	if(root == null) return root;
	if(p == root || q == root) return root;

	TreeNode l = lowestCommonAncestor(root.left, p, q);
	TreeNode r = lowestCommonAncestor(root.right, p, q);
	if(l != null && r != null) return root;
	if(l != null) return l;
	if(r != null) return r;
	return null;
}