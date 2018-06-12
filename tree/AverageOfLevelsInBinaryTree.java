/**
*Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
*Example 1:
*Input:
*    3
*   / \
*  9  20
*    /  \
*   15   7
*Output: [3, 14.5, 11]
*Explanation:
*The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
*/

public List<Double> averageOfLevels(TreeNode root) {
	List<Double> ans = new ArrayList<>();
	Queue<TreeNode> queue = new LinkedList<>();
	queue.add(root);


	while(!queue.isEmpty()){
		Queue<TreeNode> tempQueue = new LinkedList<>();
		int count = 0;
		long sum = 0;
	
		while(!queue.isEmpty()){
			TreeNode cur = queue.remove();
			count++; sum+=cur.val;
			if(cur.left != null){
				tempQueue.add(cur.left);
			}
			if(cur.right != null){
				tempQueue.add(cur.right);
			}
		}
		ans.add(sum/(double) count);
		queue = tempQueue;
	}

	return ans;
}