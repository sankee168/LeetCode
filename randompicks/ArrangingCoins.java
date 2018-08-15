//we have to find the n where closestt n*(n+1)/2 < val. For this we will be doing binary search. 
//Time complexity: O(logn)
public int arrangeCoins(int val) {
    long n = (long)val;
    long i = 0;
    long j = n;
    while(i <= j){
        long mid = (i+j)/2;
        long sum = mid*(mid+1)/2;
        if(sum == n) return (int)mid;
        else if(sum < n) i = mid+1;
        else j = mid-1;
    }
    return (int)(i-1);
}


//O(1) solution using math formula for calculating roots for ax2 + bx + c = 0
public int arrangeCoins(int n){
    return (int)(-1+Math.sqrt(1+8*(long)n))/2;
}
