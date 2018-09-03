//Idea is similar to topological sort itself
//but toughest thing here is to create a graph out of words
//Time complexity: O(n) + O(V+E) where n is the sum of lengths of strings in input
//Space complexity: O(V+E) for indegree and graph
//here V will be number of unique chars in the input
//and E will be max of length of words(n-1)
public String alienOrder(String[] words) {
	Map<Character, Set<Character>> graph = new HashMap<>();
	Map<Character, Integer> indegree = new HashMap<>();
	for(String s : words){
		for(char c: s.toCharArray()){
			indegree.put(c, 0);
		}
	}
	for(int i = 0; i < words.length-1; i++){
		String curWord = words[i];
		String nextWord = words[i+1];
		int len = Math.min(curWord.length(), nextWord.length());
        for(int p = 0; p < len; p++){
		    char s = curWord.charAt(p);
		    char d = nextWord.charAt(p);
            if(s != d){
		        if(!graph.containsKey(s)) graph.put(s, new HashSet<Character>());
		        // if(!graph.containsKey(d)) graph.put(d, new HashSet<Character>());
		        // if(graph.get(d).contains(s)) return "";
		        if(!graph.get(s).contains(d)){
                    graph.get(s).add(d);
		            indegree.put(d, indegree.get(d)+1);
                }
                break;
            }
        }
	}

	Queue<Character> queue = new LinkedList<>();
	for(Map.Entry<Character, Integer> entry: indegree.entrySet()){
		if(entry.getValue() == 0) queue.add(entry.getKey()); 
	}

	StringBuilder sb = new StringBuilder();
	while(!queue.isEmpty()){
		char curr = queue.poll();
		sb.append(curr);
		if(graph.containsKey(curr)){
			Set<Character> nei = graph.get(curr);
			for(char curNei : nei){
				indegree.put(curNei, indegree.get(curNei)-1);
				if(indegree.get(curNei) == 0) queue.add(curNei);
			}
		}
	}

	String result = sb.toString();
	if(result.length() != indegree.keySet().size()) return "";
	return result;
}