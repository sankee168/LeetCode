//Idea here is to do post order and keep track of all the previous root element visited

TreeNode prev = null;
public void flatten(TreeNode root) {
	 if(root == null) return;
	 flatten(root.right);
	 flatten(root.left);
	 root.right = prev;
	 root.left = null;
	 prev = root;
	 return;
}
