public int sumSubarrayMins(int[] A) {
        int n = A.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            int curMin = A[i];
            sum += curMin;
            sum %= 1000000007;
            for(int j = i+1; j < n; j++){
                curMin = Math.min(curMin, A[j]);
                sum += curMin;
                sum %= 1000000007;
            }
        }
        return sum;
    }