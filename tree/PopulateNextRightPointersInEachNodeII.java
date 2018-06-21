public void connect(TreeNode root){
	if(root == null) return;
	TreeNode level = root;
	while(level != null){
		TreeLinkNode dummy = new TreeLinkNode(0);
		TreeNode temp = dummy;
		TreeNode curr = level;
		while(curr != null){
			if(curr.left != null){
				temp.next = curr.left;
				temp = curr.left;
			}
			if(curr.right != null){
				temp.next = curr.right;
				temp = curr.right;
			}
			curr = curr.next;
		}
		level = dummy.next;
	}
}