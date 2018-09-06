//essentially we will be finding the last occurance of first char
//that will the window from starting to last
//then while iteating through the chars in the window, there might be a possibility we have to extend the array size. 
//Time complexity: O(n)
//Space complexity: O(1) for storing the last occuerence in the array
public List<Integer> partitionLabels(String S) {
	Map<Character, Integer> last = new HashMap<>();
	for(int i = 0; i < S.length(); i++){
		last.put(S.charAt(i), i);
	}

	List<Integer> res = new ArrayList<>();
	int count = 0;
	int i = 0, j = 0;
	while(i < S.length() && j < S.length()){
		j = Math.max(last.get(S.charAt(i)), j);
		if(i == j) {
			res.add(count+1);
			count = 0;
		}else count++;
		i++;
	}
	return res;


public List<Integer> partitionLabels(String S){
	int[] arr = new int[26];
	for(int i = 0; i < S.length(); i++){
		arr[S.charAt(i) - 'a'] = i;
	}

	List<Integer> res = new ArrayList<>();
	int anchor = 0, j = 0;
	for(int i = 0; i < S.length(); i++){
		j = Math.max(j, arr[S.charAt(i) - 'a']);
		if(i == j){
			res.add(j-anchor+1);
			anchor = i+1;
		}
	}
	return res;
}