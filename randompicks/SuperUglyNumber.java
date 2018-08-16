//This solution is very similar to ugly number but we are given primes
//So we keep an indices array and keep finding the min product of primes and arr[index_corresponding_to_prime]
//Time complexity: O(nk) where k is the length of primes
//Space complexity: O(n+k)
public int nthSuperUglyNumber(int n, int[] primes) {
    int len = primes.length;
    int[] indices = new int[len];
    int[] arr = new int[n];
    arr[0] = 1;
    for(int i = 1; i < n; i++){
        int min = findMin(indices, primes, arr); 
        arr[i] = min;
        increaseIndex(indices, primes, arr, min);
    }
    return arr[n-1];
}    
private void increaseIndex(int[] indices, int[] primes, int[] arr, int min){
    for(int i = 0; i < indices.length; i++){
        if(primes[i]*arr[indices[i]] == min) indices[i]++;
    }
}    
private int findMin(int[] indices, int[] primes, int[] arr){
    int min = Integer.MAX_VALUE;
    for(int i = 0; i < indices.length; i++){
        min = Math.min(min, primes[i]*arr[indices[i]]);
    }
    return min;
}