//Here idea is determine dp[i][j] has a length of square with right bottom at matrix[i][j]. this can be found by looking
//at the adjacent elements in the dp array. 
//if matrix[i][j] == 1 dp[i][j] = min(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) 
//else dp[i][j] = 0;
//Time complexity: O(mn)
//Space complexity: O(mn) we can decrease the space complexity to O(n) as we are just dependent on previous row
public int maximalSquare(char[][] matrix) {
	int m = matrix.length;
	if(m == 0) return 0;
	int n = matrix[0].length;
	int[][] arr = new int[m+1][n+1];
	int maxLength = 0;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(matrix[i][j] == '0') arr[i+1][j+1] = 0;
			else{
				arr[i+1][j+1] = Math.min(Math.min(arr[i][j], arr[i+1][j]), arr[i][j+1])+1;
			}
			maxLength = Math.max(maxLength, arr[i+1][j+1]);
		}
	}
	return maxLength*maxLength;
}