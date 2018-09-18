// Encodes a tree to a single string.
public String serialize(TreeNode root) {
	StringBuilder sb = new StringBuilder();
	if(root == null) return " ";
	sb.append(root.val);
	sb.append(" ");
	sb.append(serialize(root.left));
	sb.append(serialize(root.right));
	return sb.toString();
}

// Decodes your encoded data to tree.
public TreeNode deserialize(String data) {
	String[] split = data.split(" ");
	int[] index = new int[1];
	index[0] = 0;
	return util(split, index);
}

private TreeNode util(String[] data, int[] index){
	if(index[0] == data.length) return null;
	if(data[index[0]].length() == 0) {index[0]++; return null;}
	int val = Integer.parseInt(data[index[0]]);
	TreeNode root = new TreeNode(val);
	index[0]++;
	root.left = util(data, index);
	root.right = util(data, index);
	return root;
}


//This is bit intuite than previous one
//Idea is to do a preorder and for serializing. this is evident

public String serialize(TreeNode root) {
	Stack<TreeNode> stack = new Stack<>();
	StringBuilder sb = new StringBuilder();
	if(root == null) return "";
	stack.push(root);
	while(!stack.isEmpty()){
		TreeNode curr = stack.pop();
		if(curr.right != null) stack.push(curr.right);
		if(curr.left != null) stack.push(curr.left);
		sb.append(curr.val).append(",");
	}
	return sb.toString();
}

//now we have generate preorder string. lets see how we can deserialize this
//first element is root and and left subtree upperbound is root.val and right subtree lower bound is root.val
//we will use that to create the tree
public TreeNode deserialize(String data){
	if(data.equals("")) return null;
	String[] arr = data.split(",");
	int[] pos = {0};
	return util(pos, arr, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

private TreeNode util(int[] pos, String[] arr, int lower, int upper){
	if(pos[0] == arr.length) return null;
	int index = pos[0];
	int val = Integer.parseInt(arr[index);
	//this is most important
	if(val <= lower || val >= upper) return null;
	TreeNode root = new TreeNode(val);
	pos[0]++;
	root.left = util(pos, arr, lower, val);
	root.right = util(pos, arr, val, upper);
	return root;
}