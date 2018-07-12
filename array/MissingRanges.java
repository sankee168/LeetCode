//Time complexity: O(n) where n is the length of input array

public List<String> findMissingRanges(int[] nums, int lower, int upper) {
	List<String> res = new ArrayList<>();
	int expected = lower;
	for(int i = 0; i < nums.length; i++){
		int curr = nums[i];
		if(curr < expected) continue;
		if(curr == expected) {expected++; continue;}
		getRange(expected, curr-1, res);
		expected = curr+1;	
		if(expected == Integer.MIN_VALUE) return res;
	}
	
	if(expected <= upper) getRange(expected, upper, res);
	return res;
}

private void getRange(int prev, int next, List<String> res){
	if(prev == next){
		res.add(String.valueOf(prev));
	}else res.add(prev + "->" + next);
}