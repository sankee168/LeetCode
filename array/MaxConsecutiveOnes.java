//Time complexity: O(n)
//Space complexity: O(1)
public int findMaxConsecutiveOnes(int[] nums) {
	int max = 0;
	int curr= 0;
	for(int i = 0; i <nums.length; i++){
		if(nums[i] == 1){
			curr++;
		}else{
			max = Math.max(curr, max);
			curr=0;
		}
	}
	return Math.max(curr, max);
}