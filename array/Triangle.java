//This is simple solution but computes the same sub problem again and again. 
//Time complexity: O(n)
//Space complexity: O(n)
public int minimumTotal(List<List<Integer>> triangle) {
	if(triangle == null || triangle.size() == 0) return 0;
	return minPathSum(triangle, 0, 0);
}

private int minPathSum(List<List<Integer>> triangle, int row, int index){
	if(row == triangle.size()) return 0;
	int curr = triangle.get(row).get(index);
	return Math.min(minPathSum(triangle, row+1, index), minPathSum(triangle, row+1, index+1)) + curr;
}

//This is a DP solution. If we compute bottom up and store the next bottom minPathSum list in the temp list, 
//we can reuse and donot compute again. 
//Time complexity: O(n) where n is the total number of elements in the triangle
//Space complexity: O(n) for temp list
public int minimumTotal(List<List<Integer>> triangle) {
	int n = triangle.size();
	List<Integer> prev = triangle.get(n-1);
	for(int row = n-2; row >= 0; row--){
		List<Integer> curr = new ArrayList<>();
		for(int index = 0; index <= row; index++){
			curr.add(triangle.get(row).get(index) + Math.min(prev.get(index), prev.get(index+1)));
		}
		prev = curr;
	}
	return prev.get(0);
}