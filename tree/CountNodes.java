//Major trick is to find left height(keep going left) and right height
//if they are equal that means it is complete binary tree and result will be 2^h-1;

public int countNodes(TreeNode root){
	if(root == null) return 0;
	int l = lheight(root);
	int r = rheight(root);
	if(l == r) return (2<<(l))-1;
	else return countNodes(root.left) + countNodes(root.right) + 1;

}

private int lheight(TreeNode root){
	int h = 0;
	if(root.left == null) return 0;
	TreeNode curr = root.left;
	while(curr != null){
		curr = curr.left;
		h++;
	}
	return h;
}
private int rheight(TreeNode root){
	int h = 0;
	if(root.right == null) return 0;
	TreeNode curr = root.right;
	while(curr != null){
		curr = curr.right;
		h++;
	}
	return h;
}