/**
*Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.
*
*Example 1:
*Input: 
*    5
*   / \
*  3   6
* / \   \
*2   4   7
*
*Target = 9
*
*Output: True
*Example 2:
*Input: 
*    5
*   / \
*  3   6
* / \   \
*2   4   7
*
*Target = 28
*
*Output: False
*/
public boolean findTarget(TreeNode root, int k) {
	Set<Integer> set = new HashSet<>();
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	while(!queue.isEmpty()){
		TreeNode curr = queue.remove();
		if(curr.left != null){
			queue.add(curr.left);
		}
		if(curr.right != null){
			queue.add(curr.right);
		}

		int temp = k - curr.val;
		if(set.contains(temp)){
			return true;
		}

		set.add(curr.val);
	}

	return false;

}
