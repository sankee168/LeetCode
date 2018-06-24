int count = 0;
public int countUnivalSubtrees(TreeNode root) {
	if(root == null) return 0;
	util(root);
	return count;
}

private boolean util(TreeNode root){
	if(root == null) return true;
	boolean l = util(root.left);
	boolean r = util(root.right);
    
    if(l && r){
        if(root.left != null && root.val != root.left.val){
            return false;
        }
        if(root.right != null && root.val != root.right.val){
            return false;
        }
        count++;
        return true;
    }
    
    return false;
}