//Time complexity : O(mn) as we are traversing through all the elements
//Space complexity : O(1) We reused grid for cumulative min path sum till each point. 
//Idea is simple. f(x,y) be min path sum from (0,0) to (x,y). f(x,y) = min(f(x-1, y), f(x, y-1)) + grid[x][y]
public int minPathSum(int[][] grid) {
	int m = grid.length;
	int n = grid[0].length;
	for(int i = 1; i < m; i++){
		grid[i][0] += grid[i-1][0];
	}

	for(int i = 1; i < n; i++){
		grid[0][i] += grid[0][i-1];
	}

	for(int i = 1; i < m; i++){
		for(int j = 1; j < n; j++){
			int min = Math.min(grid[i-1][j], grid[i][j-1]);
			grid[i][j] += min;
		}
	}

	return grid[m-1][n-1];
}