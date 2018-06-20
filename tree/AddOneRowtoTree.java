//Idea here is to do a level order traversal and keep track of levels
public TreeNode addOneRow(TreeNode root, int v, int d) {
	if(d == 1){
		TreeNode node = new TreeNode(v);
		node.left = root;
		return node;
	}
	Queue<TreeNode> queue1 = new LinkedList<>();
	Queue<TreeNode> queue2 = new LinkedList<>();
	int level = 1;
	queue1.add(root);
	
	while(!queue1.isEmpty()){
		if(level == d-1){
			while(!queue1.isEmpty()){
				TreeNode curr = queue1.remove();
				TreeNode temp1 = new TreeNode(v);
				temp1.left = curr.left;
				curr.left = temp1;
				TreeNode temp2 = new TreeNode(v);
				temp2.right = curr.right;
				curr.right = temp2;										
			}
			return root;
		}
		TreeNode curr = queue1.remove();
				
		if(curr.left != null){
			queue2.add(curr.left);
		}
		if(curr.right != null){
			queue2.add(curr.right);
		}
		if(queue1.isEmpty()){
			queue1 = queue2;
			queue2 = new LinkedList<>();
			level++;
		}
				
			}
		
		
	return root;
	}

}