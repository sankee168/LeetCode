public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	Map<String, Set<String>> graph = new HashMap<>();
	int n = wordList.size();
	for(String curr: wordList){
		graph.put(curr, new HashSet<String>());
	}
	
	for(int i = 0; i < n-1; i++){
		Strint first = wordList.get(i);
		for(int j = i+1; j < n; j++){
			Strint second = wordList.get(j);
			if(checkChars(first, second)) {
				graph.get(first).add(second);
				graph.get(second).add(first);
			}
		}
	}
	List<List<String>> list = new ArrayList<>();
	bfs(graph, list, new ArrayList<String>, beginWord, endWord, new HashSet<String>());
	return minDepth[0];
}

private void dfs(Map<String, Set<String>> graph, List<List<String>> ans, List<String> curr, String beginWord, String endWord, Set<String> visited){
	curr.add(beginWord);
	visited.add(beginWord);
	if(beginWord.equals(endWord)){
		if(ans.size() == 0){
			ans.add(new ArrayList<>(curr));
		}else{
			if(ans.get(0).size() > curr.size()){
				ans = new ArrayList<>();
				ans.add(new ArrayList<>(curr));
			}
		}
		return;
	}
	for(String currNei : graph.get(beginWord)){
		if(visited.contains(currNei)){
			dfs(graph, ans, curr, currNei, endWord, visited);
		}
	}
	visited.remove(beginWord);
	curr.remove(curr.size()-1);
}



private boolean checkChars(string first, String second){
	if(first.length() != second.length()) return false;
	int i = 0;
	int count = 0;
	while(i < first.length()){
		if(first.charAt(i) != second.charAt(i)) {
			count++;
			if(count > 1) return false;
		}
	}
	return true;
}