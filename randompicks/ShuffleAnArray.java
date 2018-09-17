//This algorithm is called fisher yates algorithms - on each iteration we generate random index from 
//current index to end of the array and keep swapping the element
//Time comlpexity: O(n)
//Space complexity: O(n)
class Solution {
    
    int[] orig;
    int[] array;
    Random random;
    int n;
    public Solution(int[] nums) {
        orig = nums;
        array = orig.clone();
        n = nums.length;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        array = orig.clone();
        return array;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        for(int i = 0; i < n; i++){
            int temp = array[i];
            int j = random.nextInt(n-i)+i;
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */