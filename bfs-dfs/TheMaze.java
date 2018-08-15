//Time complexity: O(mn) as we are visiting each node only once
//Space complexity: O(mn) for visited boolean array
public boolean hasPath(int[][] maze, int[] start, int[] destination) {
	int m = maze.length;
	if(m == 0) return false;
	int n = maze[0].length;
	boolean[][] visited = new boolean[m][n];
	return dfs(maze, start[0], start[1], destination[0], destination[1], visited);
}

private boolean dfs(int[][] maze, int sx, int sy, int dx, int dy, boolean[][] visited){
	if(sx == dx && sy == dy) return true;
	if(visited[sx][sy]) return false;
	visited[sx][sy] = true;
	int r = sy+1, l = sy-1, u = sx-1, d = sx+1; 
	while(r < maze[0].length && maze[sx][r] == 0){
		r++;
	}
	r-=1;
	if(dfs(maze, sx, r, dx, dy, visited)) return true;
	while(l >= 0 && maze[sx][l] == 0){
		l--;
	}
	l+=1;
	if(dfs(maze, sx, l, dx, dy, visited)) return true;

	while(u >= 0 && maze[u][sy] == 0){
		u--;
	}
	u += 1;
	if(dfs(maze, u, sy, dx, dy, visited)) return true;

	while(d < maze.length && maze[d][sy] == 0){
		d++;
	}

	d-=1;
	if(dfs(maze, d, sy, dx, dy, visited)) return true;

	return false;
}