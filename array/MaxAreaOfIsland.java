//dfs solution to calculate the maximum area of island
//Time complexity: O(mn)
//Space complexity: O(mn)
public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
	int n = grid[0].length;
	boolean[][] visited = new boolean[m][n];
	int max = 0;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(grid[i][j] == 1 && !visited[i][j]){
				int area = dfs(i, j, m, n, grid, visited);
				max = Math.max(area, max);
			}
		}
	}
	return max;
}

int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
private int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited){
	int count = 1;
    visited[i][j] = true;
	for(int k = 0; k < 4; k++){
		int x = dir[k][0]+i;
		int y = dir[k][1]+j;
		if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 1){
			count += dfs(x, y, m, n, grid, visited);
		}
	}
	return count;
}

//we can write the iterative version of this too
public int maxAreaOfIsland(int[][] grid) {
    int m = grid.length;
	int n = grid[0].length;
	boolean[][] visited = new boolean[m][n];
	int max = 0;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(grid[i][j] == 1 && !visited[i][j]){
				visited[i][j] = true;
				int area = dfs(i, j, m, n, grid, visited);
				max = Math.max(area, max);
			}
		}
	}
	return max;
}

int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
private int dfs(int i, int j, int m, int n, int[][] grid, boolean[][] visited){
	Stack<int[]> stack = new Stack<>();
	stack.push(new int[]{i, j});
	int count = 0;
	while(!stack.isEmpty()){
		int[] curr = stack.pop();
		count++;
		for(int k = 0; k < 4; k++){
			int x = curr[0]+dir[k][0];
			int y = curr[1]+dir[k][1];
			if(x >= 0 && y >= 0 && x < m && y < n && grid[x][y] == 1 && !visited[x][y]){
				visited[x][y] = true;
				stack.push(new int[]{x,y});
			}
		}
	}
	return count;
}