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

public int closestValue(TreeNode root, double target) {
	double diff = Integer.MAX_VALUE;
	int val = root.val;
	while(root != null){
		double temp = Math.abs(target, (double) root.val);
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