/**
*Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
*
*Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
*
*If no such second minimum value exists, output -1 instead.
*
*Example 1:
*Input: 
*    2
*   / \
*  2   5
*     / \
*    5   7
*
*Output: 5
*Explanation: The smallest value is 2, the second smallest value is 5.
*Example 2:
*Input: 
*    2
*   / \
*  2   2
*
*Output: -1
*Explanation: The smallest value is 2, but there isn't any second smallest value.
*/

//we do a dfs search on the tree and check if curr.val is greater than 
int min = 0;
int ans = Integer.MAX_VALUE;

public int findSecondMinimumValue(TreeNode root) {
	min = root.val;
	dfs(root);
	if(ans == Integer.MAX_VALUE) return -1;
	return ans;
}

private void dfs(TreeNode root){
	if(root.val > min && root.val < ans){
		ans = root.val;
	}
	if(root.val == min){
        if(root.left != null) dfs(root.left);
        if(root.right != null) dfs(root.right);
    }
}

//this is iterative version of this
public int findSecondMinimumValue(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        int min = Integer.MAX_VALUE;
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr.val > root.val && curr.val < min){
                min = curr.val;
            }
            if(curr.val == root.val){
            	if(curr.left != null){
            		stack.push(curr.left);
            		stack.push(curr.right);
            	}
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }