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


//Time complexity: O(n)
//Space complexity: O(k) where n is the length of nums and k is the input integer
//Trick here is to check if there occurs repeating remainder. say a%k == (a+b+c+d)%k that means b+c+d is perfectly divisible by k
public boolean checkSubarraySum(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    int sum = 0, previousRem = 0;
    for(int i = 0; i < nums.length; i++){
        sum += nums[i];
        if(k != 0) sum %= k;
        if(set.contains(sum)) return true;
        set.add(previousRem);
        previousRem = sum;
    }
    return false;
}


