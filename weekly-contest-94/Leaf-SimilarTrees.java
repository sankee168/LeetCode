//Time complexity: O(n) + O(m) 
//Space complexity: O(logn) + O(logm) where n and m are the total nodes in two trees.
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
	List<Integer> list1 = getLeaves(root1);
	List<Integer> list2 = getLeaves(root2);

	if(list1.size() != list2.size()) return false;
	for(int i = 0; i < list1.size(); i++){
		if(list1.get(i) != list2.get(i)) return false;
	}
	return true;
}

private List<Integer> getLeaves(TreeNode root){
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> list = new ArrayList<>();
	if(root == null) return list;
	stack.push(root);
	while(!stack.isEmpty()){
		TreeNode curr = stack.pop();
		if(curr.left == null && curr.right == null){
			list.add(curr.val);
		}
		if(curr.right != null) stack.push(curr.right);
		if(curr.left != null) stack.push(curr.left);
	}

	return list;
}