//FindLeavesOfBinaryTree
//Idea here is to calculate the height of current node and place it in the respective position
//in result list
//while doing that in the recursive function we need to keep adding nodes
//Time compelxity: O(n)
//Space complexity: O(n)
public List<List<Integer>> findLeaves(TreeNode root) {
	List<List<Integer>> ans = new ArrayList<>();
	util(root, ans)
	return ans;
}

private int util(TreeNode root, List<List<Integer>> ans){
	if(root == null) return -1;
	int left = util(root.left, ans);
	int right = util(root.right, ans);

	int curr = Math.max(left, right) + 1;
	if(curr >= ans.size()){
		ans.add(new ArrayList<Integer>());
	}
	ans.get(curr).add(root.val);
	return curr;
}