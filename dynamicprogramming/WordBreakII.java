public List<String> wordBreak(String s, List<String> wordDict) {
	Set<String> set = new HashSet<>();
	for(int i = 0; i < wordDict.size(); i++){
		set.add(wordDict.get(0));
	}
	int n = s.length();
	boolean[] dp = new boolean[n+1]; dp[0] = true;
	List<List<String>> list = new ArrayList<>();
	for(int i = 1; i <= s.length(); i++){
		for(int j = 0; j < i; j++){
			if(dp[j] && set.contains(s.substring(j, i))){
				dp[i] = true;
				List<String> temp = list.get(j);
				if(list.size() < i) list.add(new ArrayList<String>());
				if(temp.size() != 0){
					for(int k = 0; k < temp.size(); k++){
						list.get(i).add(temp.get(k) + " " + s.substring(j, i));
					}
				}
			}
		}
	}
	return list.get(list.size()-1);
}