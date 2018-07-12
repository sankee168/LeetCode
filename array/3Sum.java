//backtracking solution. time limit has exceeded
public List<List<Integer>> threeSum(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> res = new ArrayList<>();
	dfs(nums, res, new ArrayList<Integer>(), 0, 0, 0);
	return res;	
}

private void dfs(int[] nums, List<List<Integer>> res, List<Integer> curr, int sum, int count, int start){
	if(count > 3){
		return;
	}
	if(sum == 0 && count == 3){
		res.add(new ArrayList<>(curr));
		return;
	}

	for(int i = start; i < nums.length; i++){
		if(i != start && nums[i] == nums[i-1]) continue;
		curr.add(nums[i]);
		dfs(nums, res, curr, sum+nums[i], count+1, i+1);
		curr.remove(curr.size()-1);
	}
}

//this is simple solution with two pointers inside the loop
//Time complexity: O(n2)
//Space complexity: O(1) other than return list
public List<List<Integer>> threeSum(int[] nums) {
	Arrays.sort(nums);
	List<List<Integer>> res = new ArrayList<>();
	for(int i = 0; i < nums.length-2; i++){
        if(i == 0 || (nums[i] != nums[i-1])){
		int start = i+1;
		int end = nums.length-1;		
		while(start < end){
			int temp = nums[start]+nums[end];
			if(temp == -1*nums[i]){
				List<Integer> curr = new ArrayList<>();
				curr.add(nums[i]);
				curr.add(nums[start]);
				curr.add(nums[end]);
				res.add(curr);
                while(start < end && nums[start] == nums[start+1]) start++;
                while(start < end && nums[end] == nums[end-1]) end--;
                start++; end--;
			}else if(temp < -1*nums[i]){
				start++;
			}else{end--;}
		}
        }
	}
	return res;
}