/**
*Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
*
*Example:
*Given a binary tree 
*          1
*         / \
*        2   3
*       / \     
*      4   5    
*Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
*
*Note: The length of path between two nodes is represented by the number of edges between them.
*/


int diameter = 0;

public int diameterOfBinaryTree(TreeNode root) {
	height(root);
	return diameter;
}

private int height(TreeNode root){
	if(root == null) return 0;

	int l = 0;
	if(root.left != null) { 
		l = height(root.left) + 1;
	}
	int r = 0;
	if(root.right != null){
		r = height(root.right) + 1;
	}

	diameter = Math.max(diameter, l + r);
	return Math.max(l, r);
}