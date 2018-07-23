//idea is simple. store the sum from 0 to ith idex in sum array. 
//If you are asked to calculate the sum range from ith to jth index, substract sum[i] from sum[j+1] 
//Time complexity: O(n) for computing sum once
//Space compelxity: O(1)
class NumArray {
	int[] sum;
    public NumArray(int[] nums) {    	
    	sum = new int[nums.length+1];
    	for(int i = 0; i < nums.length; i++){
    		sum[i+1] = sum[i] + nums[i];
    	}
    }
    
    public int sumRange(int i, int j) {
    	return sum[j+1] - sum[i];
    }
}
