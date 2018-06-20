public List<Integer> rightSideView(TreeNode root) {

	List<Integer> ans = new ArrayList<>();
	if(root == null) return ans;
	Queue<TreeNode> q1 = new LinkedList<>();
	Queue<TreeNode> q2 = new LinkedList<>();
	q1.add(root);
	while(!q1.isEmpty()){
		TreeNode curr = q1.peek();
		if(q1.size() == 1){
			ans.add(curr.val);
		}
		curr = q1.poll();
		if(curr.left != null){
			q2.add(curr.left);
		}
		if(curr.right != null){
			q2.add(curr.right);
		}

		if(q1.isEmpty()){
			q1 = q2;
			q2 = new LinkedList<>();
		}
	}

	return ans;
}