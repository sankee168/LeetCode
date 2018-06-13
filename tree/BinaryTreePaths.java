/**
*Given a binary tree, return all root-to-leaf paths.
*
*Note: A leaf is a node with no children.
*
*Example:
*
*Input:
*
*   1
* /   \
*2     3
* \
*  5
*
*Output: ["1->2->5", "1->3"]
*
*Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

List<String> ans = new ArrayList<>();

public List<String> binaryTreePaths(TreeNode root) {
	String s = "";
	dfs(root, s);
	return ans;
}

private void dfs(TreeNode root, String s){
	if(root == null) return;
	if(s.length() != 0){
		s = s + "->" + String.valueOf(root.val);
	}else{
		s = String.valueOf(root.val);
	}

	if(root.left == null && root.right == null){
		ans.add(s);
        return;
	}
    
    if(root.left != null){
		dfs(root.left, s);
	}
    if(root.right != null){
		dfs(root.right, s);
    }
}