//Time complexity: O(n)
//Space complexity: O(n)
public int findPairs(int[] nums, int k) {
	if(k < 0 || nums.length == 0) return 0;
	Map<Integer, Integer> map = new HashMap<>();
	int count = 0;
	for(int curr: nums){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}

	for(Map.Entry<Integer, Integer> entry: map.entrySet()){
		if(k == 0){
			if(entry.getValue() >= 2) count++;
		}
		else{
			if(map.keySet().contains(entry.getKey() + k)){
				count++;
			}
		}
	}

	return count;
}