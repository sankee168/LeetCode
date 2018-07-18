//not completed
public int maxChunksToSorted(int[] arr) {
	TreeMap<Integer, Integer> last = new TreeMap<>();
	for(int i = 0; i < arr.length; i++){
		last.put(arr[i], i);
	}

	int count = 0;
	for(int i = 0; i < arr.length; i++){
		int curr = arr[i];
		i = lastOccurence(last, curr);
		count++;
	}
}

private int lastOccurence(TreeMap<Integer, Integer> map, int e){
	int lastIndex = -1;
	for(Map.Entry<Integer, Integer> curr: map.entrySet()){
		if(curr.getKey() > e){
			break;
		}else{
			lastIndex = Math.max(lastIndex, curr.getValue());
		}
		map.remove(curr.getKey());
	}

	return lastIndex;
}