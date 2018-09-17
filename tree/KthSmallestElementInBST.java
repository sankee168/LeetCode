//Idea here is to do inorder traversal and keep count of number of nodes in travesal
//Time complexity O(n) as we will traverse through all nodes worst case
// Space complexity O(n) for stack
public int kthSmallest(TreeNode root, int k) {
	
	Stack<TreeNode> stack = new Stack<TreeNode>();
	int count = 0;
	TreeNode curr = root;
	while(!stack.isEmpty() || curr != null){
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}
		curr = stack.pop();
		count++;
		if(count == k){
			return curr.val;
		}
		curr = curr.right;
	}
	return curr.val;
}


int count = 0;
int ans = 0;
public int kthSmallest(TreeNode root, int k){
	inorder(root, k);
	return ans;
}

private int inorder(TreeNode root, int k){
	if(root.left != null) inorder(root.left, k);
	count++;
	if(count == k)  {
		ans = root.val;
		return;
	}
	if(root.right != null) inorder(root.right, k);
}