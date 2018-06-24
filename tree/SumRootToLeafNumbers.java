//recursive
//dfs traversal but keep count of sum till the parent. 
public int sumNumbers(TreeNode root){
	int count = 0;
	if(root == null) return 0;
	return util(root, count);
}

private int util(TreeNode root, int sum){
	if(root == null) return 0;
	if(root.left == null && root.right == null) return 10*sum + root.val;
	return util(root.left, 10*sum + root.val) + util(root.right, 10*sum + root.val);
}

//iterative
public int sumNumbers(TreeNode root){
	int sum = 0;
	int val = 0;	
	Stack<TreeNode> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();
	TreeNode curr = root;
	while(!s1.isEmpty() || curr != null){
		while(curr != null){
			val = 10*val + curr.val;
			s1.push(curr);
			s2.push(val);
			curr = curr.left;
		}
		curr = s1.pop();
		val = s2.pop();
		if(curr.right == null && curr.left == null) {
			sum += val;
		}
		curr = curr.right;
	}
    return sum;
}