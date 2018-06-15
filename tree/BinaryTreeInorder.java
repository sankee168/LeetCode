//recursive

List<Integer> ans = new ArrayList<>();

public List<Integer> inorderTraversal(TreeNode root){
	if(root == null) return ans;
	inorder(root);
	return ans;
}

private void inorder(TreeNode root){
	if(root == null) return;
	inorder(root.left);
	ans.add(root.val);
	inorder(root.right);
}

//iterative

public List<Integer> inorderTraversal(TreeNode root){
	List<Integer> ans = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<TreeNode>();
	ListNode curr = root;
	while(curr != null || !stack.isEmpty()){
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
		curr = stack.pop();
		ans.add(curr.val);
		curr = curr.right;
	}

	return ans;
}
