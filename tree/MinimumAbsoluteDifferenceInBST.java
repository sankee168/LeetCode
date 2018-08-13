//Idea here is to do inorder traversal and keep track of minimum. 
//Iterative version
public int getMinimumDifference(TreeNode root) {
    Stack<TreeNode> stack = new Stack<>();
    int diff = Integer.MAX_VALUE;
    TreeNode curr = root; Integer prev = null;
    while(curr != null || !stack.isEmpty()){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();
        if(prev != null){
            diff = Math.min(diff, Math.abs(prev-curr.val));
        }
        prev = curr.val;
        curr = curr.right;
    }
    return diff;
}

//This is recurivse way of doing
int diff = Integer.MAX_VALUE;
Integer prev = null;
public int getMinimumDifference(TreeNode root){
    inorder(root);
    return diff;
}

private void inorder(TreeNode root){
    if(root == null) return;
    inorder(root.left);
    if(prev != null){
        diff = Math.min(diff, Math.abs(root.val-prev));
    }
    prev = root.val;
    inorder(root.right);
}