//incomplete
public TreeNode str2tree(String s) {
	if(s.length() == 0) return null;
	return util(s.toCharArray(), 0, s.length());
}

private TreeNode util(char[] s, int i, int j){
	if(i > j) return null; 
	int val = Integer.parseInt(String.valueOf(s[i]));
	TreeNode curr = new TreeNode(val);	
	int count = 0;
	int ls = i+1;
	int lr = i+1;
	for(int k = i+1; k < j; k++){
		if(s[k] == '(') count++;
		if(s[k] == ')') count--;
		if(count == 0){
			lr = k;
		}
	}

	curr.left = util(s, ls+2, lr-1);
	curr.right = util(s, lr+2, j);
	return curr;
}