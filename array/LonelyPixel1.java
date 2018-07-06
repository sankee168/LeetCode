//Time complexity: O(mn)
//Space complexity: O(m+n)
//iterate through the picture and find if each row has only one B. Same for column too
//iterate through the picture array and check if each element is B and row and col has single lonely black element.
public int findLonelyPixel(char[][] picture) {
	int m = picture.length;
	int n = picture[0].length;
	boolean[] row = new boolean[picture.length];
	boolean[] col = new boolean[picture[0].length];
	int res = 0;

	for(int i = 0; i < m; i++){
		int count = 0;
		for(int j = 0; j < n; j++){
			if(picture[i][j] == 'B'){
				count++;
			}
		}
		if(count == 1) row[i] = true;
	}

	for(int j = 0; j < n; j++){
		int count = 0;
		for(int i = 0; i < m; i++){
			if(picture[i][j] == 'B'){
				count++;
			}
		}
		if(count == 1) col[i] = true;
	}

	for(int i = 0; i < m; i++){
		for(int j = 0; j < n; j++){
			if(picture[i][j] == 'B' && row[i] && col[j]){
				res++;
			} 
		}
	}

	return res;

}