public int totalFruit(int[] tree) {
	int n = tree.length;
	Map<Integer, Integer> map = new HashMap<>();
	int max = 0;
	int anchor = 0;
    int count = 0;
	for(int i = 0; i < n; i++){
		int curType = tree[i];
		map.put(curType, map.getOrDefault(curType, 0)+1);
        if(map.get(curType) == 1) count++;
		while(count > 2){
			int prevType = tree[anchor];
			if(map.get(prevType) == 1) {
                count--;
            }
            map.put(prevType, map.get(prevType)-1);
			anchor++;
		}
		max = Math.max(max, i-anchor+1);
	}
	return max;
}