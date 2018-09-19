//subset sum
//partition
//we are asked to if we can partition array into two parts such that their sum is equal
//step1 : we calculated the sum of numbers
//step2 : we tried to find the combination which will be equal to half of its sum very similar to combination sum
//Here complexity is O(2^n). assume T(n) is the time taken to solve problem of size n
//then T(n) = T(n-1) + T(n-2) + ....
public boolean canPartition(int[] nums) {
    int sum = 0;
    for(int num : nums) sum += num;
    if(sum%2 != 0) return false;
    sum = sum/2;
    return backtrack(nums, 0, sum, 0);
}    
private boolean backtrack(int[] nums, int curSum, int sum, int start){
    if(sum == curSum) return true;
    if(curSum > sum) return false;
    for(int i = start; i < nums.length; i++){
        boolean subCheck = backtrack(nums, curSum+nums[i], sum, i+1);
        if(subCheck) return true;
    }
    return false;
}