//This is level order traversal which takes O(n) space and O(n) time complexity
public void connect(TreeLinkNode root) {
	if(root == null) return;
	Queue<TreeLinkNode> q1 = new LinkedList<>();
	Queue<TreeLinkNode> q2 = new LinkedList<>();  
	q1.add(root);
	while(!q1.isEmpty()){
		TreeLinkNode curr = q1.poll();
		if(curr.left != null){
			q2.add(curr.left);
		}
		if(curr.right != null){	
			q2.add(curr.right);
		}
		if(q1.isEmpty){
			TreeLinkNode next = null;
			while(!q2.isEmpty()){
				TreeLinkNode temp1 = q2.poll();
				if(next != null){
					next.next = temp1;
				}
				next = temp1;
				q1.add(temp1);
			}
		}
	}
}

// This solution takes O(1) space and O(n) time complexity

public void connect(TreeLinkNode root){
	//start is treated as start of each level dfs
	TreeLinkNode start = root;
	while(start != null){
		TreeLinkNode curr = start;
		//curr is treated as pointer for bfs traversal in one level
		while(curr != null){
			if(curr.left != null){
				curr.left.next = curr.right;
			}
			if(curr.right != null && curr.next != null){
				curr.right.next = curr.next.left;
			}
			curr = curr.next;
		}
		start = start.left;
	}
}