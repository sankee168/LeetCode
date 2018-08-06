//Here we are generating all the roots in the left subtree and right subtree and then looping over them to return all available trees in that range
public List<TreeNode> generateTrees(int n) {
    if(n == 0) return new ArrayList<TreeNode>();
	return util(1, n);
}

private List<TreeNode> util(int start, int end){
	List<TreeNode> list = new ArrayList<>();
	if(start > end){
		list.add(null); return list;
	}

	for(int i = start; i <= end; i++){
		List<TreeNode> leftNodes = util(start, i-1);
		List<TreeNode> rightNodes = util(i+1, end);
		
		for(TreeNode l: leftNodes){
			for(TreeNode r: rightNodes){
                TreeNode root = new TreeNode(i);
                root.left = l;
				root.right = r;
				list.add(root);
			}
		}
	}

	return list;
}

//but we are solving the same problem again and again. To do this, we can memoize the List of roots for a given interval. 
//What I mean by interval is end-start, 