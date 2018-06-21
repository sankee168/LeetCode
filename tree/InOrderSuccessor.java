public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	if(root == null) return null;
	if(p.val >= root.val){
		return inorderSuccessor(root.right, p);
	}
	else{
		TreeNode left = inorderSuccessor(root.left, p);
		if(left == null) return root;
		else return left;
	}
}

public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	if(root == null || p == null) return null;
	//if p.right is not null then left most node in the right subtree is the successor
	TreeNode cur = p;
	while(curr.right != null){
		TreeNode temp = curr.right;
		while(temp.left != null){
			temp = temp.left;
		}
		return temp;
	}

	//if p.right is null then successor might be in diffrent branch of parent. 
	//continue with binary search traversal and keep track of node when curr 
	//node value is greater than given node. Keep overridng the curr node. 
	//At the end of the traversal that variable holds the last node which is greater 
	//than given node
	TreeNode temp = root;
	TreeNode ans = null;
	while(temp != null){
		if(temp == p) return null;
		if(temp.val <= p.val){
			temp = temp.right;
		}
		else{
			ans = temp;
			temp = temp.left;
		}
	}
	return ans;
}
