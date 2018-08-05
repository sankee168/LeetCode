//Lets start with bruteforce way. how do we check if there can be sub string in the dictionary such that they form the given string
//I would start with checking all the possible substrings. if substring(0, i)  is in dictionary, then repeat the process for substring(i+1, end)
//Time complexity: O(n^n) where n is the length of the string. 
//Space complexity: O(n) as recursion tree can go n levels 
public boolean wordBreak(String s, List<String> wordDict) {
	//As set gives O(1) lookup, we use set rather than list
	Set<String> set = new HashSet<>();
	for(int i=0; i < wordDict.size(); i++){
		set.add(wordDict.get(i));
	}

	return util(s, set, 0);
}

private boolean util(String s, Set<String> set, int start){
	if(start == s.length()) return true;
	for(int end = start+1; end <= s.length(); end++){
		if(set.contains(s.substring(start, end)) && util(s, set, end)){
			return true;
		}
	}
	return false;
}

//If we observe this problem, we are doing some redundant computations. 
//Example s = "catsandq" arr = {cat, cats, s, and} for this example when we start with cat, we check 's' and 'and'. 
//when we hit 'q' we return back. then we start with 'cats' and we compute and again. insted if we can store a boolean
// to determine if substring starting at and will make into set or not. 
//Time complexity: 
//Space complexity: 
public boolean wordBreak(String s, List<String> wordDict) {
	Set<String> set = new HashSet<>();
	for(int i=0; i < wordDict.size(); i++){
		set.add(wordDict.get(i));
	}
	int[] arr = new int[s.length()];
	return util(s, set, arr,  0);
}

private boolean util(String s, Set<String> set, int[] arr, int start){
	if(start == s.length()) return true;
	if(arr[start] == -1) return false;
	if(arr[start] == 1) return true;
	for(int end = start+1; end <= s.length(); end++){
		if(set.contains(s.substring(start, end)) && util(s, set, arr, end)){
			arr[start] = 1;
			return true;
		}
	}
	arr[start] = -1;
	return false;
}

//We can also solve by dp 
//Time complexity: O(n2) for two loops
//Space complexity: O(n) 
public boolean wordBreak(String s, List<String> wordDict) {
	Set<String> set = new HashSet<>();
	for(int i=0; i < wordDict.size(); i++){
		set.add(wordDict.get(i));
	}

	boolean dp[] = new boolean[s.length()+1];
	dp[0] = true;
	for(int i = 1; i <= s.length(); i++){
		for(int j = 0; j < i; j++){
			if(dp[j] && set.contains(s.substring(j, i))) 
			{
				dp[i] = true;
				break;
			}
		}
	}
	return dp[s.length()];
}