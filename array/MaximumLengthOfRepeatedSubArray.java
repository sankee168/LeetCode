//Time complexity: O(mn)
//Space complexity: O(mn)
//We are using dp[][] array to store the length of common sub array which ends at A[i] and B[j]. 
//so we can just compare dp[i-1][j-1]. If that is non-zero that means it is continuing common sequence. 
public int findLength(int[] A, int[] B) {
	int m = A.length, n = B.length;
	int[][] dp = new int[m+1][n+1];
	int max = 0;
	for(int i = 1; i < m+1; i++){
		for(int j = 1; j < n+1; j++){
			if(A[i-1] == B[j-1]){
				dp[i][j] = dp[i-1][j-1]+1;
				max = Math.max(dp[i][j], max);
			}
		}
	}
	return max;
}