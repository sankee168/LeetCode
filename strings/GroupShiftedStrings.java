//Here we have to check the different between two consequtive chars. If we want to group similar strings together, we create a key which resembles the difference between chars
//So we create a new key with difference between consq. chars. 
//Time complexity: O(nk) where n is the length of input and k is the average length of each string
//Space complexity: O(n) for the map
public List<List<String>> groupStrings(String[] strings) {
	Map<String, List<String>> map = new HashMap<>();
	for(String curr: strings){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < curr.length()-1; i++){
			int diff = curr.charAt(i+1)-curr.charAt(i);
            if(diff < 0) diff += 26;
			sb.append(diff);
		}
		String key = sb.toString();
		if(!map.containsKey(key)) map.put(key, new ArrayList<String>());
		map.get(key).add(curr);
	}
	return new ArrayList<>(map.values());
}