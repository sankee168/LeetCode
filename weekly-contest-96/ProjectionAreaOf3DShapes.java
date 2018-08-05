//for base we need to count the elements in 2d array which are greater than 0
//for side xz we need to get max of each row. if max is not zero add it to the sum
//for side yz we need to get max of each column, if max is not zero add it to the sum
//Time complexity: O(n)
//Space complexity: O(1)
public int projectionArea(int[][] grid) {
	int m = grid.length;
	int n = grid[0].length;
	int xy = m*n;
	int xz = 0;
	for(int i = 0; i < m; i++){
		int max = Integer.MIN_VALUE;
		for(int j = 0; j < n; j++){
			if(grid[i][j] == 0){
				xy--;
			}else{
				max = Math.max(max, grid[i][j]);
			}
		}
		if(max != Integer.MIN_VALUE) xz += max;
	}

	int yz = 0;
	for(int j = 0; j < n; j++){
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < m; i++){
			if(grid[i][j] != 0){
				max = Math.max(max, grid[i][j]);
			}
		}
		if(max != Integer.MIN_VALUE) yz += max;
	}

	return xy+xz+yz;
}