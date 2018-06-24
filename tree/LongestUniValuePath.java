int maxCount = 0;
public int longestUnivaluePath(TreeNode root){
	dfs(root);
	return maxCount;
}
//get the length of arrow from this node
private int dfs(TreeNode root){
	if(root == null) return 0;	
	int left = dfs(root.left);
	int right = dfs(root.right);
	int arrowleft = 0, arrowright = 0;
	if(root.left != null && root.left.val == root.val){
		arrowleft = left+1;
	}
	if(root.right != null && root.right.val == root.val){
		arrowright = right+1;
	}

	maxCount = Math.max(maxCount, arrowleft + arrowright);
	return Math.max(arrowleft, arrowright);
}