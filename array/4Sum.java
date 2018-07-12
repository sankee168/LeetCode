//Extenstion of 3sum problem. but we have to use map to store the numbers between start and end
//Time complexity: O(n^2)
//Space complexity: O(n)
public List<List<Integer>> fourSum(int[] nums, int target) {
	Arrays.sort(nums);
	List<List<Integer>> res = new ArrayList<>();
	for(int i = 0; i < nums.length-3; i++){
		if(i != 0 && nums[i] == nums[i-1]) continue;
		Map<Integer, Integer> map = createMap(nums, i);
		int curr = nums[i];
		decrease(map, curr);
		int start = i+1;		
		int end = nums.length-1;
		while(start < end){
			decrease(map, nums[start]);
			decrease(map, nums[end]);
			int temp = target - curr - nums[start] - nums[end];
			if(map.containsKey(temp)){
				List<Integer> list = new ArrayList<>();
				list.add(curr); list.add(nums[start]); list.add(nums[end]); list.add(temp);
				res.add(list);
			}
			if(temp > 0){
				start++;
			}else end--;
		}
	}
	return res;
}

private void decrease(Map<Integer, Integer> map, int curr){
	if(map.containsKey(curr)){
		int temp = map.get(curr);
		if(temp-1 == 0){
			map.remove(curr);
		}else{
			map.put(curr, temp-1);
		}
	}	
}

private Map<Integer, Integer> createMap(int[] nums, int start){
	Map<Integer, Integer>map = new HashMap<>();
	for(int i = start; i < nums.length; i++){
		if(map.containsKey(nums[i])){
			int temp = map.get(nums[i]);
			map.put(nums[i], temp+1);
		}
		else map.put(nums[i], 1);
	}
	return map;
}