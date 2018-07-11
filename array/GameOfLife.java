//Time complexity: O(mn)
//Space complexity : O(1)
//Trick here is to treat current value and next value as bits. As there are only 2 possible values, 0 and 1. right most is treated as current state and left as next state. 
//So at any point we can get current state by & 1. and after the loop, delete the right bit. 
public void gameOfLife(int[][] board) {
	int r = board.length;
	int c = board[0].length;
	
	int[][] dir = {{0,-1},{0,1},{-1,1},{-1,0},{-1,-1},{1,-1},{1,0},{1,1}};
	for(int i = 0; i < r; i++){
		for(int j = 0; j < c; j++){
			int sum = 0;
			for(int k = 0; k < 8; k++){
				int x = dir[k][0];
				int y = dir[k][1];
				
				if(i+x >= 0 && j+y >= 0 && i+x < r && j+y <c){
					sum += board[i+x][j+y]&1;
				}
			}
            
			if(res[i][j] == 1 && (sum == 2 || sum == 3)){
				board[i][j] = 3;
			}
			if(res[i][j] == 0 && sum == 3){
				board[i][j] = 2;
			}
		}
	}

	for(int i = 0; i < r; i++){
		for(int j = 0; j < c; j++){
			board[i][j] = board[i][j]>>1;
		}
	}
}