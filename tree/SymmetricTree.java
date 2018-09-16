/**
*Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
*
*For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
*
*    1
*   / \
*  2   2
* / \ / \
*3  4 4  3
*But the following [1,2,2,null,3,null,3] is not:
    *1
*   / \
  *2   2
   *\   \
   *3    3
*Note:
*Bonus points if you could solve it both recursively and iteratively.
*/

public boolean isSymmetric(TreeNode root) {
	if(root == null) return true;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	queue.add(root);
	while(!queue.isEmpty()){
		TreeNode l = queue.remove();
		TreeNode r = queue.remove();

		if(l == null && r == null) continue;
		if(l == null || r == null) return false;
		if(l.val != r.val) return false;
		queue.add(l.left);
		queue.add(r.right);
		queue.add(r.left);
		queue.add(l.right);
	}
	return true;
}

public boolean isSymmetric(TreeNode root) {
	if(root == null) return true;
	return util(root.left, root.right);
}

private boolean util(TreeNode left, TreeNode right){
	if(left != null && right != null) return true;
	if(left == null || right == null) return false;
	if(left.val != right.val) return false;
	return util(left.left, right.right) && util(left.right, right.left);
}

public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right ==null) return true;
        if(root.left == null || root.right == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        stack.push(root.right);
        while(!stack.isEmpty()){
            TreeNode r = stack.pop();
            TreeNode l = stack.pop();
            if(r == null && l == null) continue;
            if(r == null || l == null) return false;
            if(l.val != r.val) return false;
            stack.push(l.left);
            stack.push(r.right);
            stack.push(l.right);
            stack.push(r.left);
        }
        return true;
    }