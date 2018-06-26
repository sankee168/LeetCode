//This approach loops over from left corner and compares with first element in row
//repeated the same for column wise too. 
//Time complexity: O(m*n)
//Space complexity: O(1)
public boolean isToeplitzMatrix(int[][] matrix) {
	int m = matrix.length;
	int n = matrix[0].length;

	for(int sum = m-1; sum >= 0; sum--){
		int i = sum;
		int j = 0;
		int prev = matrix[i][j];
		while(i <= m-1 && i >=0 && j < n && j>=0){
			if(matrix[i][j] != prev) return false;
			i++; j++;
		}
	}

	for(int sum = n-1; sum >= 0; sum--){
		int i = 0;
		int j = sum;
		int prev = matrix[i][j];
		while(j <= n-1 && j >=0 && i < m && i>=0){
			if(matrix[i][j] != prev) return false;
			i++; j++;
		}
	}

	return true;
}

//This is a simple approach where you compare itselef with the top left element in the array. Simple
//Time complexity: O(m*n)
//Space complexity: O(1)
public boolean isToeplitzMatrix(int[][] matrix){
	int m = matrix.length;
	int n = matrix[0].length;

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(i>0 && j>0 && matrix[i-1][j-1] != matrix[i][j]){
				return false;
			}
		}
	}
	return true;
}