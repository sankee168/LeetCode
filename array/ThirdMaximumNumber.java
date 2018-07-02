//Time complexity: O(n)
//Space complexity: O(1)
public int thirdMax(int[] nums) {
	Integer max1 = null;
	Integer max2 = null;
	Integer max3 = null;

	for(Integer curr: nums){
		if(curr.equals(max1) || curr.equals(max2) || curr.equals(max3)) continue;
		if(max1 == null || curr > max1){
			max3 = max2;
			max2 = max1;
			max1 = curr;
		}else if(max2 == null || curr > max2){
			max3 = max2;
			max2 = curr;
		}else if(max3 == null || curr > max3){
			max3 = curr;
		}
	}

	if(max3 == null) return max1;
	return max3;
}