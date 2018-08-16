//This is O(n3) solution. Idea is to calculate the max product for ith integer by looking at its two values which sum to n
//We store the max product which we can achieve when given integer is i in ith index
//So for computing n, we have to check if 1 and n-1, 2 and n-2 and ... 

public int integerBreak(int n) {
    int[] arr = new int[n+1];
    arr[0] = 0;
    arr[1] = 1;
    arr[2] = 1;
    for(int i = 3; i <= n; i++){
        int p = 1;
        int q = i-1;
        int max = Integer.MIN_VALUE;
        while(p <= q){
            int i1 = Math.max(p, arr[p]);
            int i2 = Math.max(q, arr[q]);
            max = Math.max(i1*i2, max);
            p++; q--;
        }
        arr[i] = max;
    }        
    return arr[n];
}