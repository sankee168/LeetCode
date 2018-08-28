public int longestValidParentheses(String s) {
    if(s.length() < 2) return 0;
	int[] arr = {0};
	int max = 0;
	for(int i = 1; i < s.length(); i+=2){
		int[] temp = new int[s.length()-i];
		for(int p = 0; p +i < s.length(); p++){
			int q = p+i;

			if(s.charAt(p) == '(' && s.charAt(q) == ')') temp[p] = 1;
			else if(s.charAt(p) == ')' && s.charAt(q) == '(') temp[p] = -1;
			else temp[p] = -(s.length()+1);
			if(i != 1){
				temp[p] += arr[p+1];				
			}
            if(temp[p] >= 0){
                max = Math.max(max, i+1);
			}	
		}
        arr = temp;
	}
	return max;
}