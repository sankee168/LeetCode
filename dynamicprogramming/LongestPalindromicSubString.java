//This is DP solultion. Bruteforce way takes O(n3) time complexity where as this solution takes lesser than that. 
//Inorder to check if (i,j) is palindrome, we check if (i+1,j-1) is a palindrome and char(i)==char(j). so that we won't be 
//reevaluating the same problem again and again. 
//Time complexity: O(n2)
//Space complexity: O(n2)
public String longestPalindrome(String s) {
	if(s.length() == 0) return "";
	int x = 0, y = 0, n = s.length(), max = 0;
	boolean[][] arr = new boolean[n][n];
	for(int i = 0; i < n; i++){
		arr[i][i] = true;
	}

	for(int i = 0; i < n-1; i++){
		if(s.charAt(i) == s.charAt(i+1)){
			arr[i][i+1] = true;
			if(2 > max){
				x = i; y = i+1; max = 1;
			}
		}
	}

	for(int k = 2; k < n; k++){
		for(int i = 0; i < n-k; i++){
			if(arr[i+1][i+k-1] && s.charAt(i) == s.charAt(i+k)){
				arr[i][i+k] = true;
				if(k > max) {
					max = k; x = i; y = i+k;
				}
			}
		}
	}

	return s.substring(x, y+1);
}

//We can try to do this without O(n2) space too by spanning out from middle
int lo, max;
public String longestPalindrome(String s) {
	int n = s.length();
	if(n < 2) return s;
	for(int i = 0; i < n-1; i++){
		checkPalindrome(s, i, i); //odd
		checkPalindrome(s, i, i+1); //even
	}
	return s.substring(lo, lo+max);
}

private void checkPalindrome(String s, int i, int j){
	while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
		i--; j++;
	}

	if(j-i-1 > max){
		max = j-i-1; lo = i+1;
	}
}