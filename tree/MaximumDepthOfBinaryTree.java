/**
*Given a binary tree, find its maximum depth.
*
*The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*
*Note: A leaf is a node with no children.
*
*Example:
*
*Given binary tree [3,9,20,null,null,15,7],
*
*    3
*   / \
*  9  20
*    /  \
*   15   7
*return its depth = 3.
*/

public int maxDepth(TreeNode root) {
	if(root == null) return 0;
	if(root.left == null && root.right == null) return 1;
	return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}


//we can do this by BFS too
public int maxDepth(TreeNode root){
	if(root == null) return 0;
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);
	int depth = 0;
	while(!queue.isEmpty()){
		int size = queue.size();
		for(int i = 0; i < size; i++){
			TreeNode curr = queue.poll();
			if(curr.left != null){
				queue.add(curr.left);
			}
			if(curr.right != null){
				queue.add(curr.right);
			}
		}
		depth++;
	}
	return depth;
}

//or DFS too
public int maxDepth(TreeNode root){
	if(root == null) return 0;
	Stack<TreeNode> nodeStack = new Stack<>();
	Stack<Integer> depthStack = new Stack<>();
	nodeStack.push(root);
	depthStack.push(1);
	int max = 0;
	while(!nodeStack.isEmpty()){
		TreeNode curr = nodeStack.pop();
		int depth = depthStack.pop();
		if(curr.left != null){
			nodeStack.push(curr.left);
			depthStack.push(depth+1);
		}

		if(curr.right != null){
			nodeStack.push(curr.right);
			depthStack.push(depth+1);
		}
		max = Math.max(depth, max);
	}
	return max;
}