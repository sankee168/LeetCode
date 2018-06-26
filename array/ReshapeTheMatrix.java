//Idea is to determine index of the element in the given array and determining the position in the return array. 
//Time complexity: O(mn)
//Space complexity: O(mn)
public int[][] matrixReshape(int[][] nums, int r, int c) {
	int m = nums.length;
	int n = nums[0].length;

	if(m*n != r*c) return nums;
	int[][] ans = new int[r][c];
	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			int index = i*n + j;
			ans[index/c][index%c] = nums[i][j];
		}
	}
	return ans;
}