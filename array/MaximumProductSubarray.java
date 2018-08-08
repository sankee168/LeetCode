//Trick here is to calculate the maxProduct and minProduct ending at i index. 
//As we know if we multiply a negative number by positive number, product is going to decrease but we will keep track of it till we see another negative number
//when we encounter a negative number we swap maxPro and minPro
//Time complexity: O(n)
//Space complexity: O(1)
public int maxProduct(int[] nums) {
	if(nums.length == 0) return 0;
	int max = nums[0];
	int maxPro = nums[0];
	int minPro = nums[0];
	for(int i = 1; i < nums.length; i++){
		if(nums[i] < 0){
			int temp = maxPro;
			maxPro = minPro;
			minPro = temp;
		}

		maxPro = Math.max(maxPre*nums[i], nums[i]);
		minPro = Math.min(minPre*nums[i], nums[i]);
		max = Math.max(maxPro, max);
	}
	return max;
}