//As input matrix is not square, we need to create new matrix
//Time complexity : O(mn)
//Space complexity: O(mn)
public int[][] transpose(int[][] A) {
	int m = A.length;
	int n = A[0].length;
	int[][] arr = new int[n][m];
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			arr[j][i] = A[i][j];
		}
	}
	return arr;
}