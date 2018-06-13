/**
*Find the sum of all left leaves in a given binary tree.
*
*Example:
*
    *3
*   / \
*  9  20
*    /  \
*   15   7
*
*There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
public int sumOfLeftLeaves(TreeNode root) {
	if(root == null) return 0;
	int sum = 0;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()){
		TreeNode temp = queue.remove();
		if(temp.left != null){
			if(temp.left.left == null && temp.left.right == null){
				sum += temp.left.val;
			}else{
				queue.add(temp.left);
			}
		}

		if(temp.right != null){
			queue.add(temp.right);
		}
	}

	return sum;
}