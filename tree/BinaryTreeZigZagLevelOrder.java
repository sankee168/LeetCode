//Level order traversal using stacks and maintain boolean flag which determines whether right/left should be pushed first
//Time complexity: O(n) Space complexity O(n)
public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	Stack<TreeNode> s1 = new Stack<>();        
	Stack<TreeNode> s2 = new Stack<>();
	boolean isLeft = true;
	s1.push(root);
	List<Integer> list = new ArrayList<>();
	List<List<Integer>> ans = new ArrayList<>();
	while(!s1.isEmpty()){
		TreeNode curr = s1.pop();
		if(curr != null){
			list.add(curr.val);
			if(isLeft){
				s2.push(curr.left);
				s2.push(cur.right);
			}else{
				s2.push(curr.right);
				s2.push(curr.left);
			}
		}

		if(s1.isEmpty() && !s2.isEmpty()){
			s1 = s2;
			s2 = new Stack<>();
			isLeft = !isLeft;
			ans.add(list);
			list = new ArrayList<>();
		}
	}
}