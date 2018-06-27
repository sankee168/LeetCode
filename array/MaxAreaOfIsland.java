//not solved
public int maxAreaOfIsland(int[][] grid) {
	int m = grid.length;
	int n = grid[0].length;

	int max = 0;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(grid[i][j] == 1){
				if(i > 1){
					grid[i][j] += grid[i-1][j];
				}
				if(j > 1){
					grid[i][j] += grid[i][j-1];
				}
			}

			if(grid[i][j] > max){
				max = grid[i][j];
			}
		}
	}

	return max;	
}