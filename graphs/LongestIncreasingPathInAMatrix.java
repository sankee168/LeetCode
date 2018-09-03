//Here we can do dfs for every element in the matrix
//as we will solving repeatitively we memoise the longest path at the location during dfs traversal
//Time complexity: O(mn)
//Space complexity: O(mn)
public int longestIncreasingPath(int[][] matrix) {
	int m = matrix.length;
	if(m == 0) return 0;
	int n = matrix[0].length;
	int[][] longest = new int[m][n];
	int max = 1;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			max = Math.max(max, dfs(matrix, m, n, i, j, longest));
		}
	}
	return max;
}

private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] longest){
	if(longest[i][j] != 0) return longest[i][j];
	int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	int temp = 1;
	for(int k = 0; k < 4; k++){
		int x = i+dir[k][0];
		int y = j+dir[k][1];
		if(x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]){
			temp = Math.max(temp, dfs(matrix, m, n, x, y, longest) +1);
		}
	}
	longest[i][j] = temp;
	return longest[i][j];
}