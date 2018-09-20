//what are the requirements? to check if it is validnumber or not
//1. Should we validate negative numbers? either + or - should occur at max 2(start and if exponential exists as power) and sign should not be last one
//2. Should we validate decimals? -> there should be digits before . and after . and . should occur at max once
//3. Should we validate exponential numbers? should occur only once and there should be digits before and after
//4. Can string contain ending spaces? I mean should we trim or not

//With the above constaints any char should belong to {0-9, . , e, E, -, +}
//if any of the characters doesn't fall under this category then we return false;
//Time complexity: O(n)
//Space compelxity: O(1)
public boolean isNumber(String s) {
	s = s.trim();
	int n = s.length();
	if(n == 0) return false;
	boolean isDigit = false;
	boolean isExponential = false;
	int signCount = 0;
	boolean isDecimal = false;
	for(int i = 0; i < n; i++){
        char curr = s.charAt(i);
        // System.out.println(curr);
		if(!isValidChar(curr)) return false;        
		if(curr >= '0' && curr <= '9') isDigit = true;
		if(curr == 'e' || curr == 'E'){
			if(!isDigit) return false;
			if(isExponential) return false;
			if(i == n-1) return false;
			isExponential = true;
		}
		if(curr == '.'){
			if(i == n-1 && !isDigit) return false;
			if(isDecimal || isExponential) return false;
			isDecimal = true;
		}
		if(curr == '-' || curr == '+'){
			if(signCount == 2) return false;
			if(i == n-1) return false;
			if(i > 0 && !isExponential) return false;
			signCount++;
		}
	}	
	return true;

}


private boolean isValidChar(char c){
	return ((c >= '0' && c<= '9') || c == 'e' || c == 'E' || c =='-' || c == '.' || c == '+');
}