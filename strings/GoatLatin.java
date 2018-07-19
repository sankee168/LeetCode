//Time complexity: O(n)
//Space complexity: O(n) where n is the length of the string
public String toGoatLatin(String S) {
	String[] arr = S.split(" ");
	StringBuilder sb = new StringBuilder();
	int i = 1;
	for(String cur: arr){
		if(isVowel(cur)){
			sb.append(cur).append("ma");
		}else{
			sb.append(cur.substring(1, cur.length())).append(cur.substring(0,1)).append("ma");
		}
		int j = i;
		while(j > 0){
			sb.append("a");
            j--;
		}
        i++;
		sb.append(" ");
	}

	return sb.toString().substring(0, sb.toString().length()-1);

}


private boolean isVowel(String word){
	Set<Character> set = new HashSet<>();
	set.add('a'); set.add('A');
	set.add('e'); set.add('E');
	set.add('i'); set.add('I');
	set.add('o'); set.add('O');
	set.add('u'); set.add('U');
	if(set.contains(word.charAt(0))) return true;
	return false;
}