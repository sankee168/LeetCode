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