//This is simple. have four counters r1, r2 and c1 and c2 to keep track of which row/column to start and end.
//Time complexity: O(mn)
//Space complexity: O(1)
public List<Integer> spiralOrder(int[][] matrix) {
	int m = matrix.length;
	List<Integer> list = new ArrayList<>();
	if(m==0) return list;
	int n = matrix[0].length;
	
	int r1=0, r2=m-1, c1=0, c2=n-1;
	while(r1<=r2 && c1<=c2){
		for(int c = c1; c<=c2; c++){
			list.add(matrix[r1][c]);
		}
		for(int r = r1+1; r<=r2; r++){
			list.add(matrix[r][c2]);
		}
		if(r1 < r2 && c1 < c2){
			for(int c = c2-1; c>c1; c--){
				list.add(matrix[r2][c]);
			}
			for(int r = r2; r>r1; r--){
				list.add(matrix[r][c1]);
			}
		}

		r1++; c1++; r2--; c2--;
	}
	return list;
}