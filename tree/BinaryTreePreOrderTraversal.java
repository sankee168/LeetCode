//Recursive
List<Integer> ans = new ArrayList<>();

public List<Integer> preorderTraversal(TreeNode root) {
	if(root == null) return ans;
	util(root);
	return ans;
}

private void util(TreeNode root){
	if(root == null) return;
	ans.add(root.val);
	util(root.left);
	util(root.right);
}


//iterative

public List<Integer> preorderTraversal(TreeNode root) {
	List<Integer> ans = new ArrayList<>();
	Stack<TreeNode> stack = new Stack<>();
    if(root == null) return ans;
	TreeNode curr = root; stack.push(root);
	while(!stack.isEmpty()){
		curr = stack.pop();
		ans.add(curr.val);
		if(curr.right != null){
			stack.push(curr.right);
		}
        if(curr.left != null){
			stack.push(curr.left);
		}
	}

	return ans;
}