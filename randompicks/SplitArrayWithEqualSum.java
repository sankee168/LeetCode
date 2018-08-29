//check the restrictions on i, j and k then iterate over j and it will be easy to find i and k
//Time complexity: O(n2)
//Space complexity: O(n)
public boolean splitArray(int[] nums) {
	int[] sum = new int[nums.length];
	sum[0] = nums[0];
	for(int i = 1; i < nums.length; i++){
		sum[i] = sum[i-1]+nums[i];
	}

	int n = nums.length;
	for(int j = 3; j < n-3; j++){

		Set<Integer> set = new HashSet<>();
		for(int i = 1; i < j-1; i++){
			if(sum[i-1] == sum[j-1]-sum[i]){
				set.add(sum[i-1]);
			}
		}
		for(int k = j+2; k < n-1; k++){
			if(sum[nums.length-1]-sum[k] == sum[k-1]-sum[j] && set.contains(sum[k-1]-sum[j])) return true;
		}
	}
	return false;
}