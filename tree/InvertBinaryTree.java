/**
*Invert a binary tree.
*
*Example:
*
*Input:
*
*     4
*   /   \
*  2     7
* / \   / \
*1   3 6   9
*Output:
*
*     4
*   /   \
*  7     2
* / \   / \
*9   6 3   1
*Trivia:
*This problem was inspired by this original tweet by Max Howell:
*
*Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree on a whiteboard so f*** off.
*/

public TreeNode invertTree(TreeNode root) {
	if(root == null) return null;
	if(root.left == null && root.right == null){
		return root;
	}

	TreeNode temp = root.left;
	root.left = invertTree(root.right);
	root.right = invertTree(temp);

	return root;
}

//bfs and iterative solution
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            TreeNode left = curr.left;
            curr.left = curr.right;
            curr.right = left;
            if(curr.right != null) queue.add(curr.right);
            if(curr.left != null) queue.add(curr.left);
        }
        return root;
    }