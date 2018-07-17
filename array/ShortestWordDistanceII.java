//Simple solution. we just have to keep in mind to handle cases when word1 and word2 are same.
//we use two pointers. one for word1 and other for word2. if they are same, we have to update with previous occurance. 
//Time complexity: O(n)
//Space complexity: O(1)
public int shortestWordDistance(String[] words, String word1, String word2) {
	int p = -1;
	int q = -1;
	boolean same = word1.equals(word2);
	int minDistance = Integer.MAX_VALUE;
	for(int i = 0; i < words.length; i++){        
		if(words[i].equals(word1)){
			if(same){
				p = q;
				q = i;
			}
			else{
				p = i;
			}
        }
		else if(words[i].equals(word2)){
			q = i;
		}

		if((same && p != -1 ) || (p != -1 && q != -1)){
			minDistance = Math.min(Math.abs(p-q), minDistance);
		}
        }
	return minDistance;
}