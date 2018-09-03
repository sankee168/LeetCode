//This is like bfs solution. we have divided the problem into two problems
//one problem where we are finding the coordinates of the point which can be reached
//here reached is when height of the surroundings are greater than current. like backtacking
//So we find the two boolean arrays which can reach from atlantic and pacific
//iterate through them and find the last result
//Time complexity: O(mn)
//Space complexity: O(mn)
public List<int[]> pacificAtlantic(int[][] matrix) {
	List<int[]> list = new ArrayList<>();
	int m = matrix.length;
    if(m == 0) return list;
	int n = matrix[0].length;
	boolean[][] pacific = new boolean[m][n];
	boolean[][] atlantic = new boolean[m][n];
	Queue<int[]> q1 = new LinkedList<>();
	Queue<int[]> q2 = new LinkedList<>();
	for(int i = 0; i < n; i++){
		pacific[0][i] = true;
		atlantic[m-1][i] = true;
		q1.add(new int[]{0,i});
		q2.add(new int[]{m-1,i});
	}

	for(int i = 0; i < m; i++){
		pacific[i][0] = true;
		atlantic[i][n-1] = true;
		q1.add(new int[]{i, 0});
		q2.add(new int[]{i, n-1});
	}

	bfs(matrix, q1, m, n, pacific);
	bfs(matrix, q2, m, n, atlantic);

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(pacific[i][j] && atlantic[i][j]){
				list.add(new int[]{i,j});
			}

		}
	}
	return list;
}

private void bfs(int[][] matrix, Queue<int[]> queue, int m, int n, boolean[][] reach){
	int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	while(!queue.isEmpty()){
		int[] curr = queue.poll();
		int height = matrix[curr[0]][curr[1]];
		for(int i = 0; i < 4; i++){
			int x = curr[0] + dir[i][0];
			int y = curr[1] + dir[i][1];
			if(x >= 0 && y >= 0 && x < m && y < n && !reach[x][y] && matrix[x][y] >= height){
				queue.add(new int[]{x, y});
				reach[x][y] = true;
			}
		}
	}
}

//we can also do this in dfs approach
//Time complexity: O(mn)
//Space complexity: O(mn)
public List<int[]> pacificAtlantic(int[][] matrix) {
	List<int[]> list = new ArrayList<>();
	int m = matrix.length;
    if(m == 0) return list;
	int n = matrix[0].length;
	boolean[][] pacific = new boolean[m][n];
	boolean[][] atlantic = new boolean[m][n];
	for(int i = 0; i < n; i++){
		pacific[0][i] = true;
		atlantic[m-1][i] = true;
		dfs(matrix, m, n, 0, i, pacific);
		dfs(matrix, m, n, m-1, i, atlantic);
	}

	for(int i = 0; i < m; i++){
		pacific[i][0] = true;
		atlantic[i][n-1] = true;
		dfs(matrix, m, n, i, 0, pacific);
		dfs(matrix, m, n, i, n-1, pacific);
	}

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(pacific[i][j] && atlantic[i][j]){
				list.add(new int[]{i,j});
			}

		}
	}
	return list;
}

private void dfs(int[][] matrix, int m, int n, int i, int j, boolean[][] reach){
	int[][] dir = {{-1,0},{1,0},{0,1},{0,-1}};
	for(int k = 0; k < 4; k++){
		int x = i+dir[k][0];
		int y = j+dir[k][1];
		if(x >= 0 && y >= 0 && x < m && y < n && !reach[x][y] && matrix[x][y] >= matrix[i][j]){
			reach[x][y] = true;
			dfs(matrix, m, n, x, y, reach);
		}
	}
}