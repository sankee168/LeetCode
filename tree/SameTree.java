/**
*Given two binary trees, write a function to check if they are the same or not.
*
*Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
*
*Example 1:
*
*Input:     1         1
*          / \       / \
*         2   3     2   3
*
        *[1,2,3],   [1,2,3]
*
*Output: true
*Example 2:
*
*Input:     1         1
*          /           \
*         2             2
*
*        [1,2],     [1,null,2]
*
*Output: false
*Example 3:
*
*Input:     1         1
*          / \       / \
*         2   1     1   2
*
*        [1,2,1],   [1,1,2]
*
*Output: false
*/

public boolean isSameTree(TreeNode p, TreeNode q) {
	if(p == null && q == null) return true;
	if(p != null && q != null){
        if(p.val == q.val){
		    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
	}
	return false;         
}


public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(p);
        s2.push(q);
        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode c1 = s1.pop();
            TreeNode c2 = s2.pop();
            if(c1.val != c2.val) return false;
            if(c1.left != null) s1.push(c1.left);
            if(c2.left != null) s2.push(c2.left);
            if(s1.size() != s2.size()) return false;
            if(c1.right != null) s1.push(c1.right);
            if(c2.right != null) s2.push(c2.right);
            if(s1.size() != s2.size()) return false;
        }
        
        if(s1.isEmpty() && s2.isEmpty()) return true;
        return false;
    }
