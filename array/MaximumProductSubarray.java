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



public int maxProduct(int[] nums) {
	if(nums.length == 0) return 0;
	int max = nums[0];
	int n = nums.length;
	int[] dp1 = new int[n];
	dp1[0] = nums[0];
	int[] dp2 = new int[n];
	dp2[0] = nums[0];
	for(int i = 1; i < nums.length; i++){
		if(nums[i] < 0){
			dp1[i] = Math.max(dp2[i-1]*nums[i] , nums[i]);
			dp2[i] = Math.min(dp1[i-1]*nums[i], nums[i]);		
		}else {
			dp1[i] = Math.max(dp1[i-1]*nums[i], nums[i]);
			dp2[i] = Math.min(dp2[i-1]*nums[i], nums[i]);		
		}

		max = Math.max(max, dp1[i]);
	}
	return max;
}