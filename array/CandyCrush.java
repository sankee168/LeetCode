//This is bit of raw solution.
//Time compelxity: O(mn) per iteration
//Space complexity: O(1)
public int[][] candyCrush(int[][] board) {
	int m = board.length;
	int n = board[0].length;
	boolean check = false;

	//mark all the same elements in row as negative
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n-2; j++){
			int candy = Math.abs(board[i][j]);
			if(candy != 0 && candy == Math.abs(board[i][j+1]) && candy == Math.abs(board[i][j+2])){
				board[i][j] = -1*candy;
				board[i][j+1] = -1*candy;
				board[i][j+2] = -1*candy;
				check = true;
			}
		}
	}

	//mark all the same elements in column as negative
	for(int j = 0; j < n; j++){
		for(int i = 0; i < m-2; i++){
			int candy = Math.abs(board[i][j]);
			if(candy != 0 && candy == Math.abs(board[i+1][j]) && candy == Math.abs(board[i+2][j])){
				board[i][j] = -1*candy;
				board[i+1][j] = -1*candy;
				board[i+2][j] = -1*candy;
				check = true;
			}
		}
	}

	//drop non negative elements from the top
	for(int j = n-1; j >= 0; j--){
		int p = m-1;
		int q = m-1;
		while(p >= 0 && q >= 0){
			if(board[p][j] > 0) {
				p--; q = p;
			}else if(board[q][j] > 0){
				board[p][j] = board[q][j];
				board[q][j] *= -1;
				p--;q--;
			}else{
				q--;
			}
		}

		for(int i = p; i >= 0; i--){
			board[i][j] = 0;
		}
	}

	if(check) return candyCrush(board);
	return board;
}
