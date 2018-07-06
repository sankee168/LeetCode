//Time complexity: O(mn)
//Space complexity: O(mn)
//DP problem. count of unique paths to i,j is the value in that array. So arr[i][j] = arr[i-1][j] + arr[i][j+1]
public int uniquePaths(int m, int n) {
	int[][] arr = new int[m][n];
	arr[0][0] = 1;
	compute(arr, m-1, n-1);
	return arr[m-1][n-1];
}

private void compute(int[] arr, int i, int j){
	if(arr[i][j] != 0) return arr[i][j];
	if(i > 0){
		arr[i][j] += compute(arr, i-1, j);
	}
	if(j > 0){
		arr[i][j] += compute(arr, i, j-1);
	}	
}


//We can solve this without recursion too(reducing stack space)
public int uniquePaths(int m, int n) {
	int[][] arr = new int[m][n];
	arr[0][0] = 1;

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(i == 0 || j == 0){
				arr[i][j] = 0;
			}else{
				arr[i][j] = arr[i-1][j] + arr[i][j-1];
			}
		}
	}
	return arr[m-1][n-1];
}