//How can we decide two strings are anagrams, we can check on the count of chars in each string
//So we generate the hashed string using char count 
//Time complexity: O(nk) where n is the length of strs and k is the average length of each string
//Space complexity: O(n)
public List<List<String>> groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();
	for(int i = 0; i < strs.length; i++){
		String hash = generateHash(strs[i]);
		if(!map.containsKey(hash)){
			map.put(hash, new ArrayList<String>());
		}
		map.get(hash).add(strs[i]);
	}

	return new ArrayList<>(map.values());
}

private String generateHash(String s){
	int[] arr = new int[26];
	for(int i = 0; i < s.length(); i++){
		arr[s.charAt(i) - 'a']++;
	}
	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < 26; i++){
		sb.append("#").append(arr[i]);
	}
	return sb.toString();
}

//here we sort the each string's char array and check if exists in the map. 
//Time complexity: O(nklogk) 
//Space complexity: O(nk) where n is the length of input array and k is the average length of string
public List<List<String>> groupAnagrams(String[] strs) {
	Map<String, List<String>> map = new HashMap<>();
	for(String curr: strs){
		char[] arr = curr.toCharArray();
		Arrays.sort(arr);
		String sorted = String.valueOf(arr);
		if(!map.containsKey(sorted)) map.put(sorted, new ArrayList<String>());
		map.get(sorted).add(curr);
	}
	return new ArrayList<>(map.values());
}