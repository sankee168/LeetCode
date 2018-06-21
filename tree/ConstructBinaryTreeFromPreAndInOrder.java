//Idea here is to keep traversing preorder which gives out root in that level and
//at the same time keep segregating left and right sublists in inorder
public TreeNode buildTree(int[] preorder, int[] inorder) {
	return util(0, inorder.length-1, inorder, preorder, 0);
}

private TreeNode util(int i, int j, int[] inorder, int[] preorder, int pIndex){
	if(pIndex > preorder.length-1 || i > j) return null;
	TreeNode temp = new TreeNode(preorder[pIndex]);
	int index = 0;
	for(int k = i; k <= j; k++){
		if(inorder[k] == preorder[pIndex]){
			index = k;
		}
	}

	temp.left = util(i, index-1, inorder, preorder, pIndex+1);
	temp.right = util(index+1, j, inorder, preorder, pIndex+index-i+1);
	
	return temp;
}
