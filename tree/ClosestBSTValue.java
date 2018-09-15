/**
*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
*
*Note:
*
*Given target value is a floating point.
*You are guaranteed to have only one unique value in the BST that is closest to the target.
*Example:
*
*Input: root = [4,2,5,1,3], target = 3.714286
*
*    4
*   / \
*  2   5
* / \
*1   3
*
*Output: 4
*/
//we go to a direction where values are closer to target
//while processing that we keep current diff and least encountered value
public int closestValue(TreeNode root, double target) {
	double diff = Integer.MAX_VALUE;
	int val = root.val;
	while(root != null){
		double temp = Math.abs(target-(double) root.val);
		if(temp == 0) return root.val;
		if(temp < diff){
			val = root.val;
			diff = temp;
		}
		if(root.val > target){
			root = root.left;
		}else if(root.val < target){
			root = root.right;
		}
	}
	
	return val;
}

//This is another version of it
public int closestValue(TreeNode root, double target) {
        TreeNode left = root;
        TreeNode right = root;
        TreeNode temp = root;
        while(temp != null){
            if(target == temp.val) return temp.val;
            if(target < (double)temp.val){
                right = temp;
                temp = temp.left;
            }else{
                left = temp;
                temp = temp.right;
            }
        }
        
        if(Math.abs(left.val-target) > Math.abs(right.val-target)) return right.val;
        return left.val;
    }