//Calculate sum of the sub array from ith index to jth index using DP. Formula is simple f(i, j) = f(i, j-1) + arr[j]
//I used a temp variable to store the previous sum.
//Time complexity: O(n2)
//Space complexity: O(1)
public int subarraySum(int[] nums, int k) {
	if(nums.length == 0) return 0;
	int count = 0;
	int prev = 0;
	for(int i = 0; i < nums.length; i++){
		for(int j = i; j < nums.length; j++){
			if(i == j) prev = nums[j]);
			else{
				prev += nums[j]);				
			}
			if(prev == k) count++;
		}
	}
	return count;
}

//This solution is bit tricky. we keep calculating cumulative sum from 0 index to end of the array and keep storing sum in hashmap. 
//we have to understand that sum[j]-sum[i] gives the sum from ith index to jth index in that array. So at every element, we have to check if there is any previous sum with sum-k value
//that determines that sum from 0-i is x and 0-j is x+k so i-j sum is k. 
//Time complexity: O(n)
//Space complexity: O(1)
public int subarraySum(int[] nums, int k) {
	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	int sum = 0;
	int count = 0;
	map.put(0, 1);
	for(int i = 0; i < nums.length; i++){
		sum += nums[i];
		if(map.containsKey(sum-k)){
			count += map.get(sum-k);
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);		
	}
	return count;
}
