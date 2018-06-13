/**
*
*Example:
*
*Input: The root of a Binary Search Tree like this:
*              5
*            /   \
*           2     13
*
*Output: The root of a Greater Tree like this:
*             18
*            /   \
*          20     13
*/

public TreeNode convertBST(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode p = root;
	int sum = 0;
	

	while(!stack.isEmpty() || p != null){
		while(p != null){
			stack.add(p);
			p = p.right;
		}

		TreeNode temp = stack.pop();
		temp.val = temp.val + sum;
		sum = temp.val;
		p = temp.left;
	}

	return root;
}