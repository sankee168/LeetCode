//this is simple insert into BST. we iterate over the root. 
//while going to next level we update the pre with current node;
//Time complexity: O(logn)
public TreeNode insertIntoBST(TreeNode root, int val) {
    TreeNode insert = new TreeNode(val);
    if(root == null) return insert;
    TreeNode curr = root;
    TreeNode pre = null;
    while(curr != null){
        pre = curr;
        if(curr.val > val){
            curr = curr.left;
        }else curr = curr.right;
    }
    if(pre.val > val){
        pre.left = insert;
    }else pre.right = insert;
    return root;
}