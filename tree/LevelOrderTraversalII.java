public List<List<Integer>> levelOrderBottom(TreeNode root) {
	List<List<Integer>> ans = new ArrayList<>();
	if(root == null) return ans;

	Queue<TreeNode> temp1 = new LinkedList<>();
	Queue<TreeNode> temp2 = new LinkedList<>();

	temp1.add(root);
	List<Integer> curList = new ArrayList<>();
	while(!temp1.isEmpty()){
		TreeNode curr = temp1.poll();
		curList.add(curr.val);
		if(curr.left != null){
			temp2.add(curr.left);
		}
		if(curr.right != null){
			temp2.add(curr.right);
		}

		if(temp1.isEmpty()){
			temp1 = temp2;
			temp2 = new LinkedList<>();
			ans.add(curList);
			curList = new ArrayList<>();
		}
	}

	List<List<Integer>> rev = new ArrayList<>();
	for(int i = ans.size()-1; i >= 0; i--){
		rev.add(ans.get(i));
	}
	return rev;
}