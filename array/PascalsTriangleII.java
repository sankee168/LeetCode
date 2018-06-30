//Time complexity : O(rowIndex^2)
//Space complexity: O(rowIndex)
public List<Integer> getRow(int rowIndex) {
	List<Integer> prev = null;
	
	for(int i = 0; i <= rowIndex; i++){
		List<Integer> temp = new ArrayList<>();
		temp.add(1);
		for(int j = 1; j < i; j++){
			temp.add(prev.get(j-1) + prev.get(j));
		}
		if(i != 0) {temp.add(1);}
		prev = temp;
	}

	return prev;

}