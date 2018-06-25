int maxLevel = 0;
int val = root.val;

public int findBottomLeftValue(TreeNode root) {
	dfs(root, 0);
	return val;
}

private void dfs(TreeNode root, int level){
	if(root.left == null && root.right == null){
		if(level > maxLevel){
			val = root.val;
			maxLevel = level;
		}
	}

	if(root.left != null){
		dfs(root.left, level+1);
	}

	if(root.right != null){
		dfs(root.right, level+1);
	}
}

