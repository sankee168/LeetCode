//First imagine the weight as the window. if we generate a random number
//and it falls under that interval we return the index of it
//so we change the input array to cumulative sum
//calculate the total sum in the manner
//generate a random integer which is less than that total weight
//check which window that falls under using binary search
//return that index
//Time complexity: O(n) for preprocessing and O(logn for pickIndex)
//Time complexity: O(1) as we are reusing the same array
class Solution {
    int[] arr;
    Random rand;
    int totalWeight;
    public Solution(int[] w) {
        arr = w;
        for(int i = 1; i < arr.length; i++){
            arr[i] += arr[i-1];
        }
        totalWeight = arr[arr.length-1];
        rand = new Random();
    }
    
    public int pickIndex() {
        int randomWeight = rand.nextInt(totalWeight);
        int index = binarySearch(0, arr.length, randomWeight);
        return index;
    }
    
    private int binarySearch(int i, int j, int val){
        while(i < j){
            int mid = (i+j)/2;
            if(arr[mid] <= val){
                i = mid+1;
            }else{
                j = mid;
            }
        }
        return j;
    }
}
