int max = 0;
public int longestConsecutive(TreeNode root) {
	if(root == null) return 0;
	util(root);
	return max;
}

private int util(TreeNode root){

	int l = longestConsecutive(root.left) + 1;
	int r = longestConsecutive(root.right) + 1;
	if(root.left != null && root.left.val != root.val+1){
		l = 1;
	}
	if(root.right != null && root.right.val != root.val+1){
		r == 1;
	}
	
	int curMax = Math.max(l, r);
	max = Math.max(max, curMax);

	return curMax;
}