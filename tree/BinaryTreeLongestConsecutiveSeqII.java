int max = 0;
public int longestConsecutive(TreeNode root) {
	if(root == null) return 0;
	util(root);
	return max;
}

private int[] util(TreeNode root){
	if(root == null) return new int[]{0, 0};
	int inc = 1, dcr = 1;

	int[] l = util(root.left);
	int[] r = util(root.right);

	if(root.left != null){
		if(root.val+1 == root.left.val){
			inc = Math.max(inc, l[0] + 1);
		}
		if(root.val == root.left.val+1){
			dcr = Math.max(dcr, l[1] + 1);
		}
	}

	if(root.right != null){
		if(root.val+1 == root.right.val){
			inc = Math.max(inc, r[0] + 1);
		}

		if(root.val == root.right.val+1){
			dcr = Math.max(dcr, r[1] + 1);
		}
	}

	max = Math.max(max, inc+dcr-1);
	return new int[]{inc, dcr};
}