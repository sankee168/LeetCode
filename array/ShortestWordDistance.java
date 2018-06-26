public int shortestDistance(String[] words, String word1, String word2) {
	int p = -1;
	int q = -1;
	int cur = Integer.MAX_VALUE;
	for(int i = 0; i < words.length; i++){
		if(words[i].equals(word1)){
			p = i;
		}
		if(words[i].equals(word2)){
			q = i;
		}

		if(p != -1 && q != -1){
			cur = Math.min(cur, Math.abs(p-q));
		}
	}

	return cur;
}