//brute force solution
//Lets go by each character
public boolean isMatch(String s, String p) {
	if(p.length() == 0) return (s.length == 0);
	boolean firstMatch = false;
	//check if first char matches
	if(s.length() != 0 && p.length() != 0 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
		firstMatch = true;
	}

	if(p.length() > 1 && p.charAt(1) == '*'){
		//if it has * that means either previous char can be repeated or there can be 0 occurances
		boolean t1 = firstMatch && isMatch(s.substring(1), p);
		boolean t2 = isMatch(s, p.substring(2));
		return t1 || t2;
	}else{
		return firstMatch && isMatch(s.substring(1), p.substring(1));
	}
}