//This is usual approach. we multiply row of A with col of B to determine one elemnt in result matrix
//Time complexity: O(r1*c2*c1);
//Space complexity: O(r1*c2);
public int[][] multiply(int[][] A, int[][] B) {
        int r1 = A.length;
        int c1 = A[0].length;
        int r2 = B.length;
        int c2 = B[0].length;
        
        int[][] res = new int[r1][c2];
        for(int i = 0; i < r1; i++){
            for(int j = 0; j < c2; j++){
                res[i][j] = multiply(A, i, B, j, c1);
            }
        }
        return res;
    }
    
    private int multiply(int[][] A, int row, int[][] B, int col, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += A[row][i]*B[i][col];
        }
        return sum;
    }

//rather than doing row to col multiplication, we will doing row to 
    //row and adding their contribution to respecitive positions
    //we can use hashmap to store one of the matrix elements
    //but I don't see any performance improvement as array also guarentees O(1)
//Time complexity: O(r1*c1*c2)
public int[][] multiply(int[][] A, int[][] B){
    int r1 = A.length;
    int k = A[0].length;
    int c2 = B[0].length;
        
    int[][] res = new int[r1][c2];

    for(int i = 0; i < r1; i++){
        for(int j = 0; j < k; j++){
            if(A[i][j] != 0){
                for(int p = 0; p < c2; p++){
                    res[i][p] += A[i][j]*B[j][p];
                }
            }
        }
    }
    return res;
}