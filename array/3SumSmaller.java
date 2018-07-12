//All the three sum problems are check on equals mostly. here trick is to get less than target. 
//So we have to count two pair sum which are less than that and with start index. 
//Time complexity: O(n^2)
//Space complexity: O(1)
public int threeSumSmaller(int[] nums, int target) {
	Arrays.sort(nums);
	int count = 0;
	for(int i = 0; i < nums.length-2; i++){
		int start = i+1;
		int end = nums.length-1;
		while(start < end){
			int temp = nums[i] + nums[start] + nums[end];
			if(temp < target) {count+=end-start; start++;}
			else {end--;}
		}
	}
	return count;
}