public TreeNode pruneTree(TreeNode root) {
    return util(root);
}    
private TreeNode util(TreeNode root){
    if(root == null) return root;
    TreeNode left = util(root.left);
    TreeNode right = util(root.right);        
    if(left == null && right == null){
        if(root.val == 0) return null;
    }        
    root.left = left;
    root.right = right;        
    return root;
}