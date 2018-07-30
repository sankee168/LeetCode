//This implementation is same as SpiralMatrix1
//Time complexity : O(n2)
//Space complexity: O(n2) for generating the matrix
public int[][] generateMatrix(int n) {
	int count = 1;
	int[][] matrix = new int[n][n];
	int r1 = 0, r2 = n-1, c1 =0, c2 = n-1;
	while(r1<=r2 && c1<=c2){
		for(int c = c1; c<=c2; c++){
			matrix[r1][c] = count++;
		}
		for(int r=r1+1; r<=r2; r++){
			matrix[r][c2] = count++;
		}
		if(r1 < r2 && c1 < c2){
			for(int c=c2-1; c>=c1; c--){
				matrix[r2][c] = count++;
			}
			for(int r=r2-1; r>r1; r--){
				matrix[r][c1] = count++;
			}
		}
		r1++;r2--;c1++;c2--;
	}
	return matrix;
}