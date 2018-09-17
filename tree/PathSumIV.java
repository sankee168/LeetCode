

//main idea is to find the node level, position and value from integer
//and calculate the right children level+position value and keep adding that to sum
//time complexity: O(n) Space complexity: O(n)
int ans = 0;
Map<Integer, Integer> map = new HashMap<>();

public int pathSum(int[] nums) {
	for(int curr : nums){
		map.put(curr/10, curr%10);
	}
	dfs(nums[0]/10, 0);
	return ans;
}

private void dfs(int node, int sum){
	if(!map.keySet().contains(node)) return;
	int val = map.get(node);
	int level = node/10;
	int position = node%10;

	sum+=val;
	int leftnode = (level+1)*10 + (2*position-1);
	int rightnode = (level+1)*10 + (2*position);

	if(!map.keySet().contains(leftnode) && !map.keySet().contains(rightnode)){
		ans+=sum;
	}
	else{
		dfs(leftnode, sum);
		dfs(rightnode, sum);
	}
}