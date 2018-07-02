//Keep a sliding window of size k in the nums and check if set contains cur element
//Time complexity: O(n)
//Space complexity: O(1)
public boolean containsNearbyDuplicate(int[] nums, int k) {
	Set<Integer> set = new HashSet<>();
	for(int i = 0;  i < nums.length; i++){
		if(set.contains(nums[i])) return true;
		set.add(nums[i]);
		if(set.size() > k){
			set.remove(nums[i-k]);
		}
	}
	return false;
}