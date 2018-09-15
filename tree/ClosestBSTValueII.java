//Idea here is do the inorder traversal and keep maintaing a list of k sequential numbers
//such that when you add an element to end of list, check with the starting of the list
//if absolute difference between them with target is lesser on the front, this means
//there won't be any more nodes which are closer to target
//else remove the front of the list and add current to end of the list
//Time complexity: O(n)
//Space complexity: O(n)
public List<Integer> closestKValues(TreeNode root, double target, int k) {
	Stack<TreeNode> stack = new Stack<>();
	List<Integer> list = new ArrayList<>();
	TreNode curr = root;
	while(!stack.isEmpty() || curr != null){
		while(curr != null){
			stack.push(curr);
			curr = curr.left;
		}

		curr = stack.pop();
		list.add(curr.val);
		if(list.size() > k){
			if(Math.abs(list.get(0)-target) < Math.abs(list.get(k)-target)){
				list.remove(k);
				break;
			}else{
				list.remove(0);
			}
		}
		curr = curr.right;
	}
	return list;
}

//We can also do this by finding predecessors and successros and then determining which one is clsoer
//Time complexity would be O(logn)