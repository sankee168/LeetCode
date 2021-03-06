/**
*Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*
*For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
*
*Example:
*
*Given the sorted array: [-10,-3,0,5,9],
*
*One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
*
*      0
*     / \
*   -3   9
*   /   /
* -10  5
*
*/

public TreeNode sortedArrayToBST(int[] nums) {
	return util(nums, 0, nums.length);
}

private TreeNode util(int[] nums, int i, int j){
	if(i == j) return null;
	if(i + 1 == j) return new TreeNode(nums[i]);
	int mid = (i+j)/2;
	TreeNode root = new TreeNode(nums[mid]);
	root.left = util(nums, i, mid);
	root.right = util(nums, mid+1, j);
}