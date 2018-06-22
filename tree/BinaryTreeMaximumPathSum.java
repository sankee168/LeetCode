int maxValue;
public int maxPathSum(TreeNode root) {
	maxValue = Integer.MIN_VALUE;
	pathsum(root);
	return maxValue;
}

private int pathsum(TreeNode root){
	if(root == null) return 0;    
    int sum = root.val;
	int l = pathsum(root.left);
	int r = pathsum(root.right);

    if(l > 0){
        sum+=l;
    }
    if(r > 0){
        sum+=r;
    }
	return sum;
}