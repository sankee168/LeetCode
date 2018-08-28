//time complexity: O(n)
//space compelxity: O(n)
public int lengthOfLongestSubstring(String s) {
	Map<Character, Integer> map = new HashMap<>();
	int i = 0, j = 0;
	int len = 0;
	while(j < s.length()){
		char end = s.charAt(j);
		if(!map.containsKey(end)){
			map.put(end, 1);
		}else{
            map.put(end, map.get(end)+1);
			while(map.get(end) != 1){
				char start = s.charAt(i);
				map.put(start, map.get(start)-1);
				if(map.get(start) == 0 && start != end){
					map.remove(start);
				}
				i++;
			}
		}

		len = Math.max(len, j-i+1);
		j++;
	}
	return len;
}

//This is simple solution but bit confusing
//when we encounter an element which is already in the hashmap. then take the maximum(i and last occurence of current elemtn +1)
//why do we have to take max with i? because we might have skipped few entries in the previous turn. 
public int lengthOfLongestSubstring(String s) {
	Map<Character, Integer> map = new HashMap<>();
	int i = 0, j = 0;
	int len = 0;
	while(j < s.length){
		if(map.containsKey(s.charAt(j))){
			i = Math.max(map.get(s.charAt(j)+1, i);
		}

		len = Math.max(j-i+1, len);
		map.put(s.charAt(j), j);
	}

	return len;
}