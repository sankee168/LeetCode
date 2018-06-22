//logic here is to either include root or not. if you don't include root, keep calling recursively for left and right
//pathSumFrom includes all the nodes from root to leaf. 
//pathSum handles handles all the cases where root starts in mid of tree
public int pathSum(TreeNode root, int sum) {
	if(root == null) return 0;
	return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
}

private int pathSumFrom(TreeNode root, int sum){
	if(root == null) return 0;
	int count = 0;
	if(root.val == sum) count++;
	count+= pathSumFrom(root.left, sum-root.val);
	count+= pathSumFrom(root.right, sum-root.val);
	return count;
}