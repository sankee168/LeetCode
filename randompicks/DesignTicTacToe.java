//we increment that particular cell value by 1 if it is plater 1 and decrease by 1 if it is player 2;
//we keep individual arrays where we keep sum of all elements in rows, cols and diognals
//we check in respective rows and cols if it is either n or -n
//Time complexity: O(1)
//Space complexity: O(n)
class TicTacToe {
    
    int[] rows;
    int[] cols;
    int[] dios;
    int n;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        dios = new int[2];
        this.n = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int val = -1;
        if(player == 1) val = 1;
        rows[row] += val;
        cols[col] += val;
        if(row == col) dios[0] += val;
        if(row+col == n-1) dios[1] += val;
        
        
        if(rows[row] == n || cols[col] == n) return 1;
        if(cols[col] == n || cols[col] == n) return 1;
        if(rows[row] == -n || cols[col] == -n) return 2;
        if(cols[col] == -n || cols[col] == -n) return 2;
        if(row == col && dios[0] == n) return 1;
        if(row == col && dios[0] == -n) return 2;
        if(row+col == n-1 && dios[1] == n) return 1;
        if(row+col == n-1 && dios[1] == -n) return 2; 
        
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */