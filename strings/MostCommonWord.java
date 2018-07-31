//Get all the words from paragraph by splitting by space. keep a set of banned words so that we can easily check with contains in O(1)
//create a hashmap from paragraph with word to frequency. Finally iterate through the hashmap and return highest
//Time complexity: O(p+b) where p is the number of strings in paragraph and b is the length of banned array
//Space complexity: O(p+b)
public String mostCommonWord(String paragraph, String[] banned) {
	Set<String> set = new HashSet<>();
	for(String word: banned){
		set.add(word.toLowerCase());
	}
	Map<String, Integer> map = new HashMap<>();
	for(String word: paragraph.split("\\W+")){
		if(!set.contains(word)) map.put(word.toLowerCase(), map.getOrDefault(word.toLowerCase(), 0)+1);
	}

	int max = 0;
	String res = "";
	for(Map.Entry<String, Integer> entry : map.entrySet()){
		if(entry.getValue() > max){
			res = entry.getKey();
			max = entry.getValue();
		}
	}

	return res;
}