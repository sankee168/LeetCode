//Time complexity: O(n)
//Space complexity: O(n)
public int maxChunksToSorted(int[] arr) {
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < arr.length; i++){
		map.put(arr[i], i);
	}        

	int count = 0;
	for(int i = 0; i < arr.length; i++){

		int index = map.get(i);
		while(i < index){
			i++;
			index = Math.max(map.get(i), index);
		}
		count++;
	}
        
    return count;
}


//Same logic but without extra space
//Time complexity: O(n)
//Space complexity: O(1)
public int maxChunksToSorted(int[] arr) {
	int count = 0; int max = 0;
	for(int i = 0; i < arr.length; i++){
		max = Math.max(max, arr[i]);
		if(max == i) count++;
	}
        
    return count;
}