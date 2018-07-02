//Following things have to checked for determining a magic square
//No duplicates in the 3*3 grid and all numbers should be 1-9
//Sum of rows, columns and diagonals should be same.
//Time complexity: O(mn) where m is rows and n is columns
//Space complexity: O(1) boolean array is of fixed size
public int numMagicSquaresInside(int[][] grid) {
	int count = 0;
	for(int i = 0; i < grid.length-2; i++){
		for(int j = 0; j < grid[0].length-2; j++){
			if(isMagicSquare(grid, i, j)){
				count++;
			}
		}
	}
	return count;
}

private boolean isMagicSquare(int[][] grid, int x, int y){
	boolean[] isVisited = new boolean[9];
	int sum = 0;
	for(int i = x; i < x+3; i++){
		int curSum = 0;
		for(int j = y; j < y+3; j++){
			int curr = grid[i][j];
			if(curr < 1 || curr > 9) return false;
			if(isVisited[curr-1]) return false;
			isVisited[curr-1] = true;
			curSum += curr;
		}
		if(sum == 0) sum = curSum;
		else if(sum != curSum) return false;
	}

	for(int j = y; j < y+3; j++){
		int curSum = 0;
		for(int i = x; i < x+3; i++){	
			curSum += grid[i][j];
		}
		if(curSum != sum) return false;
	}

	if(grid[x][y] + grid[x+1][y+1] + grid[x+2][y+2] != sum) return false;
	if(grid[x+2][y] + grid[x+1][y+1] + grid[x][y+2] != sum) return false;
	
	return true;
}