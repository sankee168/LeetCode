//Time complexity: O(n)
//Space complexity: O(n)
public boolean containsDuplicate(int[] nums) {
	Set<Integer> set = new HashSet<>();
	for(int i : nums){
		if(set.contains(i)){
			return true;
		}else{
			set.add(i);
		}
	}
	return false;
}