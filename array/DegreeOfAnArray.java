//Idea here is to store count for getting max degree of the whole array.
//and start to store the starting index of each number
//and end to store the end index of each number
//Time complexity: O(n)
//Space complexity: O(n)
public int findShortestSubArray(int[] nums) {
	Map<Integer, Integer> count = new HashMap<>();
	Map<Integer, Integer> start = new HashMap<>();
	Map<Integer, Integer> end = new HashMap<>();
	int maxDegree = 0;
	int minLength = Integer.MAX_VALUE;
	for(int i = 0; i < nums.length; i++){
		int curCount = 1;
		if(count.keySet().contains(nums[i])){
			curCount += count.get(nums[i]);			
			
		}
		count.put(nums[i], curCount);
		maxDegree = Math.max(maxDegree, curCount);

		if(!start.keySet().contains(nums[i])){
			start.put(nums[i], i);
		}

		end.put(nums[i], i);
	}

	Iterator<Integer> iter = count.keySet().iterator();
	while(iter.hasNext()){
		int num = iter.next();
		if(count.get(num) == maxDegree){
			minLength = Math.min(minLength, end.get(num)-start.get(num)+1);
		}
	}
	return minLength;
}