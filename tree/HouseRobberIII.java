//Idea here is to find the sub problem structure. Either root is robbed or not. 
//With this condition if root is included root.left and root.right will not be robbed.
//So keep doing this recursively which will increase the complexity to exponential, so memoize the solved problem
public int rob(TreeNode root) {
	if(root == null) return 0;
	Map<TreeNode, Integer> map = new HashMap<>();
	return util(root, map);
}

private int util(TreeNode root, Map<TreeNode, Integer> map){
	if(root == null) return 0;
	if(map.keySet().contains(root)) return map.get(root);

	int val = root.val;

	if(root.left != null){
		val+=util(root.left.left, map) + util(root.left.right, map);
	}
	if(root.right != null){
		val+=util(root.right.left, map) + util(root.right.right, map);
	}

	val = Math.max(val, util(root.left, map) + util(root.right, map));
	map.put(root, val);
	return val;
}