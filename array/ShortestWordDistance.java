//Space complexity: O(1)
//Time complexity: O(n)
//Idea is to keep a note of two indices of word1 and word2. whenever you encounter either of them
//update the shortestDistance
//the other approach is have two loops on words. and check. that would be O(n2)
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