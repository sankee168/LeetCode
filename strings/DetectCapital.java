//Time complexity: O(n) where n is the length of the word
//Space complexity: O(1)
public boolean detectCapitalUse(String word) {
	if(word.length() == 0) return false;
	if(word.charAt(0) >= 'a' && word.charAt(0) <= 'z'){
		return lowercheck(word, 1);
	}
	if(word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'){      
		return (lowercheck(word, 1) || uppercheck(word, 1));
	}
	return false;
}

private boolean lowercheck(String word, int index){
	for(int i = index; i < word.length(); i++){
		if(word.charAt(i) < 'a' || word.charAt(i) > 'z'){
			return false;
		}
	}
	return true;
}

private boolean uppercheck(String word, int index){
	for(int i = index; i < word.length(); i++){
		if(word.charAt(i) < 'A' || word.charAt(i) > 'Z'){
			return false;
		}
	}
	return true;
}