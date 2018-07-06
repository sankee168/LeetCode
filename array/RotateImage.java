//This code is the most optimal inplace rotation of the matrx
//arr[i][j] values should be moved to arr[j][n-i-1]
//We have to go by outer rings. go one by one inside
//Out while loop takes care of looping through outer rings
//Second while loop takes care of elements in that row
//inner while loop moves the element to the corresponding location
//Time complexity: O(n2)
//Space complexity: O(1)
public void rotate(int[][] matrix) {
	int row = 0;
	int n = matrix.length;

	while(row <= n/2){
		int i = row;
		int j = row;
        while(j < n-row-1){
            int prev = matrix[i][j];
		    int p = j;
		    int q = n-i-1;
            while(p != i || q != j){
                int temp = matrix[p][q];
			    matrix[p][q] = prev;
			    prev = temp;
                int tempIndex = p;
			    p = q;
			    q = n-tempIndex-1;
            }
            matrix[p][q] = prev;
            j++;
        }
		row++;
	}
}