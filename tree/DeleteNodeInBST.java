public TreeNode deleteNode(TreeNode root, int key) {
	TreeNode curr = root;
	if(root.val == key) {return util(root);}
	TreeNode parent = null;
	//iterate till we find node with value as key
	//in the process we update the parent
	while(curr != null && curr.val != key){
		parent = curr;
		if(key < curr.val){
			curr = curr.left;
		}
		else curr = curr.right;
	}
	if(parent.left == curr) {
		parent.left = util(curr);
	}else parent.right = util(curr);

	return root;
}

//this method deletes node and rearranges the children 
//such that right node becomes new root
private TreeNode util(TreeNode root){
	if(root == null) return null;
	if(root.left == null) return root.right;
	if(root.right == null) return root.left;
	TreeNode nextRoot = root.right;
	TreeNode left = root.left;
	TreeNode temp = nextRoot;
	while(temp.left != null){
		temp = temp.left;
	}

	temp.left = root.left;
	return nextRoot;
}