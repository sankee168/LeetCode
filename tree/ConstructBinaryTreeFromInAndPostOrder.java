public TreeNode buildTree(int[] inorder, int[] postorder) {
	return util(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);        
}

private TreeNode util(int[] inorder, int[] postorder, int i, int j, int pStart, int pEnd){
	if(pEnd < pStart || i>j) return null;
	TreeNode root = new TreeNode(postorder[pEnd]);
	int index= 0;
	for(int k = i; k <=j; k++){
		if(root.val == inorder[k]){
			index = k;
		}
	}

	root.left = util(inorder, postorder, i, index-1, pStart,  pStart+ index-i-1);
	root.right = util(inorder, postorder, index+1, j, pStart+index-i, pEnd-1);
	return root;
}