//Idea here is to do dfs to find islands and then determine unique shaped islands
//To differentiate shapes, we try to find the absolute difference from its starting point
//We can also generate the string from dfs and see uniqueness of each
//Time complexity: O(mn)
//Space complexity: O(mn)
public int numDistinctIslands(int[][] grid) {
	int m = grid.length;
	int n = grid[0].length;
	boolean[][] visited = new boolean[m][n];
	Set<Set<Integer>> shapes = new HashSet<>();
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(grid[i][j] == 1 && !visited[i][j]){
				Set<Integer> curShape = new HashSet<>();
				dfs(grid, visited, i, j, i, j, curShape);
				shapes.add(curShape);
			}
		}
	}

	return shapes.size();
}

private void dfs(int[][] grid, boolean[][] visited, int a, int b, int origX, int origY, Set<Integer> curShape){
	curShape.add((a-origX)*2*grid[0].length + b-origY);
	visited[a][b] = true;
	int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	int m = grid.length;
	int n = grid[0].length;
	for(int i = 0; i < 4; i++){
		int x = a+dir[i][0];
		int y = b+dir[i][1];
		if(x >= 0 && y >= 0 && x < m && y < n && !visited[x][y] && grid[x][y] == 1){
			dfs(grid, visited, x, y, origX, origY, curShape);
		}
	}
}