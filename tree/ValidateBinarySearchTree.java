//Do inorder traversak, keep track of previous node and verify if its value is less than current node
public boolean isValidBST(TreeNode root) {
	if(root == null) return true;
	TreeNode prev = null;
	Stack<TreeNode> stack = new Stack<>();
	TreeNode curr = root;
	while(!stack.isEmpty() || curr != null){
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
		curr = stack.pop();
		if(prev == null) prev = curr;
		else if(curr.val <= prev.val) return false;
		prev = curr;
		curr = curr.right;
	}
	return true;
}