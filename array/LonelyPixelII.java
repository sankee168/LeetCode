//not so great problem. description itself is confusing
public int findBlackPixel(char[][] picture, int N) {
	int finalcount = 0;
	int[] row = new int[picture.length];
	int[] col = new int[picture[0].length];
	Map<String, Integer> map = new HashMap<>();
	for(int i = 0; i < picture.length; i++){
		StringBuilder sb = new StringBuilder();		
		for(int j = 0; j < picture[0].length; j++){
			sb.append(Character.toString(picture[i][j]));
			if(picture[i][j] == 'B') 
				{row[i]++; col[j]++;}			
		}
		if(row[i] == N){
			map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
		}
	}

	for(String key: map.keySet()){
		int count = map.get(key);
		if(count == N){
			for (int i = 0; i < key.length(); i++) {
                if (key.charAt(i) == 'B' && col[i] == N) {
                    finalcount += N;
                }
            }
		}
	}
	return finalcount;
}