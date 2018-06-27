//Time complexity: O(n) where n is the total number of elements in M
//Space complexity: O(n) for new ans. and dir is of constant space. 
public int[][] imageSmoother(int[][] M) {
	int r = M.length;
	int c = M[0].length;
	int[][] ans = new int[r][c];
	int[][] dir = {{-1, -1}, {-1, 0}, {0, -1},{-1, 1}, {1, -1}, {1, 1}, {1, 0}, {0, 1}, {0, 0}};
	for(int i = 0; i < r; i++){
		for(int j = 0; j < c; j++){
			int sum = 0, count = 0;
			for(int k = 0; k < dir.length; k++){
				int p = dir[k][0] + i;
				int q = dir[k][1] + j;
				
				if(p >= 0 && q >= 0 && p < r && q < c){
					sum+=M[p][q];
					count++;
				}
			}
			ans[i][j] = sum/count;
		}
	}

	return ans;
}