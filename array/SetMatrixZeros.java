//Time complexity: O(mn)
//Space complexity: O(m + n)
public void setZeroes(int[][] matrix) {
	int m = matrix.length;
	int n = matrix[0].length;
	boolean[] row = new boolean[m];
	boolean[] col = new boolean[n];

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(matrix[i][j] == 0){
				row[i] = true;
				break;
			}
		}	
	}

	for(int i = 0; i < n; i++){
		for(int j = 0; j < m; j++){
			if(matrix[j][i] == 0){
				col[i] = true;
				break;
			}
		}
	}

	for(int i = 0; i < m; i++){
		if(row[i] == true){
			for(int j = 0; j < n; j++){
				matrix[i][j] = 0;
			}
		}
	}

	for(int j = 0; j < n; j++){
		if(col[j] == true){
			for(int i = 0; i < m; i++){
				matrix[i][j] = 0;
			}
		}
	}
}

//Trick here is to use first row and first col as the placeholder to determine if corresponding row and col contains 0. 
//Time complexity: O(mn)
//Space complexity: O(1)
public void setZeroes(int[][] matrix){
	boolean fRow = false, fCol = false;
	int m = matrix.length;
	int n = matrix[0].length;
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(matrix[i][j] == 0){
				if(i==0) fRow = true;
				if(j==0) fCol = true;
				matrix[i][0] = 0;
				matrix[0][j] = 0;
			}
		}
	}

	for(int i = 1; i < m; i++){
		for(int j = 1; j < n; j++){
			if(matrix[0][j] == 0 || matrix[i][0] == 0){
				matrix[i][j] = 0;
			}
		}
	}

	if(fRow == true){
		for(int i = 0; i < n; i++){
			matrix[0][i] = 0;
		}
	}
	if(fCol == true){
		for(int i = 0; i < m; i++){
			matrix[i][0] = 0;
		}
	}
}