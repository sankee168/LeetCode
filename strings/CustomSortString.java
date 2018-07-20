//Time complexity: O(S.length + T.length) 
//Space complexity: O(T.length) for map to store the count of character in T string
public String customSortString(String S, String T) {
	Map<Character, Integer> map = new HashMap<>();
	char[] arr = T.toCharArray();
	for(char curr: arr){
		map.put(curr, map.getOrDefault(curr, 0)+1);
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < S.length(); i++){
		chart curr = S.charAt(i);
		if(map.containsKey(curr)){
			int reps = map.get(curr);			
			while(reps > 0){
				sb.append(Character.toString(curr));
				reps--;
			}
			map.remove(curr);
		}
	}

	for(Map.Entry<Character, Integer> entry: map.entrySet()){
		char curr = entry.getKey();
		int reps = entry.getValue();
		while(reps > 0){
			sb.append(Character.toString(curr));
			reps--;
		}
	}

	return sb.toString();
}

//This solution is bit optimized when compared to previous one
//Rathen than storing in a map, we store in 26 length integer array.
public String customSortString(String S, String T) {
	int[] count = new int[26];
	for(char curr: T.toCharArray()){
		count[curr-'a']++;
	}

	StringBuilder sb = new StringBuilder();
	for(char curr: S.toCharArray()){
		while(count[curr - 'a'] > 0){
			sb.append(Character.toString(curr));
			count[curr - 'a']--;
		}
	}

	for(char curr = 'a'; curr <= 'z'; curr++){
		while(count[curr - 'a'] > 0){
			sb.append(Character.toString(curr));
			count[curr - 'a']--;
		}
	}

	return sb.toString();
}