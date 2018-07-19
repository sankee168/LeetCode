//Time complexity: O(n) where n is the size of the string
//Space complexity: O(n)
public List<String> generatePossibleNextMoves(String s) {
	List<String> nextMoves = new ArrayList<>();
	int i = 0;
	while(i < s.length()-1){
		char[] arr = s.toCharArray();
		if(arr[i] == '+' && arr[i+1] == '+'){
			arr[i] = '-';
			arr[i+1] = '-';
            nextMoves.add(String.valueOf(arr));
		}
		i++;
	}
	return nextMoves;
}


//Time complexity: O(n)
//Space compelexity: O(1)
//rather than creating new array like in first solution, we just check using charAt method
public List<String> generatePossibleNextMoves(String s) {
	List<String> nextMoves = new ArrayList<>();
	for(int i = 0; i < s.length()-1; i++){
		if(s.charAt(i) == '+' && s.charAt(i+1) == '+'){
			nextMoves.add(s.substring(0, i) + "--" + s.substring(i+2, s.length()));
		}
	}
	return nextMoves;
}