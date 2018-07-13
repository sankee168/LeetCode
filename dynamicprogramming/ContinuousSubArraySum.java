//Time complexity: O(n^2)
//Space complexity: O(n)
//Idea here is to calculate the sum starting from index 0 to index n
public boolean checkSubarraySum(int[] nums, int k) {
    if(nums.length < 2) return false;
    int n = nums.length;
    int[] prev = {nums[0]};        
    for(int i = 1; i < n; i++){
        int[] curr = new int[i+1];
        for(int j = 0; j < i; j++){
            curr[j] = prev[j] + nums[i];
            if(i-j >=1){
            if(k != 0) { 
                if(curr[j]%k == 0) return true;
            }
            else if(curr[j] == 0) return true;
            }
        }
        curr[i] = nums[i];
        prev = curr;
    }        
    return false;
}