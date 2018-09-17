//This solution is by using one single queue. and bfs
//Time complexity: O(n)
//Space complexity: O(n)
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> ans = new ArrayList<>();
    if(root == null) return ans;
	Queue<TreeNode> q1 = new LinkedList<>();
	q1.add(root);
	while(!q1.isEmpty()){
        int size = q1.size();
        List<Integer> level = new ArrayList<>();
        for(int i = 0; i < size; i++){
            TreeNode curr = q1.poll();
            level.add(curr.val);
            if(curr.left != null) q1.add(curr.left);
            if(curr.right != null) q1.add(curr.right);
        }
        ans.add(level);
	}
	return ans;
}


//This is dfs solution
public List<List<Integer>> levelOrder(TreeNode root) {
	List<List<Integer>> res = new ArrayList<>();
	if(root == null) return res;
	dfs(root, res, 0);
	return res;
}

private void dfs(TreeNode root, List<List<Integer>> res, int height){
	if(height == res.size()) res.add(new ArrayList<Integer>());
	res.get(height).add(root.val);
	if(root.left != null) dfs(root.left, res, height+1);
	if(root.right != null) dfs(root.right, res, height+1);
}
