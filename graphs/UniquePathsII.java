//there are only two ways one can reach (i,j), (i-1,j) and (i, j-1) if there is an obstacle that means we cannot go pass through that
//Time complexity: O(mn)
//Space complexity: O(mn)
public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m = obstacleGrid.length;
    if(m == 0) return 0;
	int n = obstacleGrid[0].length;
	int[][] res = new int[m][n];
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(obstacleGrid[i][j] == 1){
				res[i][j] = 0;
			}else{
				if(i == 0 && j == 0){
					res[i][j] = 1;
				}else if(i == 0){
					res[i][j] = res[i][j-1];
				}else if(j == 0){
					res[i][j] = res[i-1][j];
				}else{
					res[i][j] = res[i-1][j] + res[i][j-1];
				}
			}
		}
	}
	return res[m-1][n-1];
}

public int uniquePathsWithObstacles(int[][] obstacleGrid) {
	int m = obstacleGrid.length;
    if(m == 0) return 0;
	int n = obstacleGrid[0].length;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(obstacleGrid[i][j] == 1){
				obstacleGrid[i][j] = 0;
			}else{
				if(i == 0 && j == 0){
					obstacleGrid[i][j] = 1;
				}else if(i == 0){
					obstacleGrid[i][j] = obstacleGrid[i][j-1];
				}else if(j == 0){
					obstacleGrid[i][j] = obstacleGrid[i-1][j];
				}else{
					obstacleGrid[i][j] = obstacleGrid[i-1][j] + obstacleGrid[i][j-1];
				}
			}
		}
	}
	return obstacleGrid[m-1][n-1];
}