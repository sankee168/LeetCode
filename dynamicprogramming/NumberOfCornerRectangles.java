//Idea here is mainly about storing the two columns where there are 1s. If you encounter 2 1s in the same columns may be different row.
//then that means, you can make a rectangle with these two columns and other rows. 
//Time complexity: O(mn2)
//Space complexity: O(n2)
public int countCornerRectangles(int[][] grid) {
	int ans = 0;
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < grid.length; i++){
		for(int j = 0; j < grid[0].length-1; j++){
			if(grid[i][j] == 1){
				for(int k = j+1; k < grid[0].length; k++){
					if(grid[i][k] == 1){
						int key = 200*j + k;
						int val = map.getOrDefault(key, 0);
						ans += val;
						map.put(key, val+1);
					}
				}
			}
		}
	}
	return ans;
}

//Time complexity: O(m2n)
//Space complexity O(1)
public int countCornerRectangles(int[][] grid){
	int ans = 0;
	for(int i = 0; i < grid.length-1; i++){
		for(int j = i+1; j < grid.length; j++){
			int counter = 0;
			for(int k = 0; k < grid[0].length; k++){
				if(grid[i][k] == 1 && grid[j][k] == 1){
					counter++;
				}
			}
			if(counter > 0) ans += (counter*(counter-1))/2;
		}
	}
	return ans;
}