//Idea here is to treat the matrix as a single dimension array and generate the (i, j) for the mid
//Time complexity: O(log(mn))
//Space complexity: O(1)
public boolean searchMatrix(int[][] matrix, int target) {
    if(matrix.length == 0 || matrix[0].length == 0) return false;
	int m = matrix.length, n = matrix[0].length;
	int start = 0, end = m*n-1;
	while(start <= end){
		int mid = (start+end)/2;
		if(matrix[mid/n][mid%n] == target) return true;
		else if(matrix[mid/n][mid%n] > target) end = mid-1;
		else start = mid+1;
	}
	return false;
}