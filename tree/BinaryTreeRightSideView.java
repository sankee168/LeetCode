//This soultion is just level order traversal whenever we are at the end of the level
//we add it to the return list
//Time complexity: O(n)
//Space complexity: O(n) max nodes at each level can be n/2
public List<Integer> rightSideView(TreeNode root) {
	List<Integer> ans = new ArrayList<>();
	if(root == null) return ans;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
        int size = queue.size();
        for(int i = 0; i< size; i++){
            TreeNode curr = queue.poll();
            if(curr.left != null) queue.add(curr.left);
            if(curr.right != null) queue.add(curr.right);
            if(i == size-1) ans.add(curr.val);
        }
    }
    return ans;
}

//we can used dfs solution too here
//idea is to do dfs traversal and if each depth corresponds to its position in list
//but first we have to give preference to right node and then left(reverse preorder sort)
public List<Integer> rightSideView(TreeNode root) {
	List<Integer> ans = new ArrayList<>();
	if(root == null) return ans;
	dfs(root, ans, 0);
	return ans;
}

private void dfs(TreeNode root, List<Integer> ans, int depth){
	if(root == null) return;
	if(depth == ans.size()) ans.add(root.val);
	dfs(root.right, ans, depth+1);
	dfs(root.left, ans, depth+1);
}