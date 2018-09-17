//This problem just another version of ShortestWordDistance but here we have to handle duplicates
public int shortestWordDistance(String[] words, String word1, String word2) {
	int p = -1;
	int q = -1;
	int min = Integer.MAX_VALUE;
	boolean isSame = word1.equals(word2);
	for(int i = 0; i < words.length; i++){
		if(words[i].equals(word1)){
			if(!isSame){
				p = i;
			}else{
				q = p;
				p = i;
			}
		}else if(words[i].equals(word2)){
			q = i;
		}

		if(p != -1 && q != -1){
			min = Math.min(min, Math.abs(p-q));
		}
	}
	return min;
}