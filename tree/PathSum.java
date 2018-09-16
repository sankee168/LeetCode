//recursively check if rest of the sum exists in either of children
public boolean hasPathSum(TreeNode root, int sum) {
	if(root == null) return false;
	if(root.left == null && root.right == null){
    	if(sum == root.val) return true;
    	else return false;
	        
	return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
}

//this is iterative dfs
//we can optimize this by updating the each node value by summing with parents 
//before pushing to stack.
public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> rem = new Stack<>();
        nodeStack.push(root);
        rem.push(sum);
        while(!nodeStack.isEmpty()){
            TreeNode curr = nodeStack.pop();
            int remainingSum = rem.pop();
            if(curr.left == null && curr.right == null){
                if(remainingSum == curr.val) return true;
                else continue;
            }
            
            if(curr.left != null){
                nodeStack.push(curr.left);
                rem.push(remainingSum-curr.val);
            }
            if(curr.right != null){
                nodeStack.push(curr.right);
                rem.push(remainingSum-curr.val);
            }
        }
        return false;
    }