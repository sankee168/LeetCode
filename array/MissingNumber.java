//Time compelxity: O(n)
//Space compelxity: O(1)
public int missingNumber(int[] nums) {
	int n = nums.length;
	int sum = n*(n+1)/2;
	for(int i : nums){
		sum -= i;
	}
	return sum;
}