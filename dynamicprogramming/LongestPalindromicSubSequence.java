//lets say dp(i,j) represents longest palindromic subsequence from i to j
//so how do we decide substring(i,j) is palindrome?
//if char(i) == char(j) && and (i+1, j-1) is also substring
//same logic here 
//dp(i,j) = dp(i+1, j-1) + 2 if(char(i) == char(j))
//else dp(i,j) = max(dp(i+1, j), dp(i, j+1))

public int longestPalindromeSubseq(String s) {
	int[][] dp = new int[s.length()][s.length()];
	int n = s.length();
	for(int i = 0; i < n; i++){
		dp[i][i] = 1;
	}

	for(int l = 2; l <= n; l++){
		for(int i = 0; i+l <= n; i++){
			int j = i+l-1;
			if(l == 2){
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = 2;
				}else dp[i][j] = 1;
			}else{
				if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}else{
					dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
				}
			}
		}
	}
	return dp[0][s.length()-1];
}


//how can we optimize this solution?
//if we see diognal wise we see that each diognal is dependent on 2nd previous diognal
//so we just store them
//Time complexity: O(n2)
//Space complexity: O(n)
public int longestPalindromeSubseq(String s) {
	int[] dp1 = new int[s.length()];
    int[] dp2 = new int[s.length()];
 	int n = s.length();
	for(int i = 0; i < n; i++){
		dp1[i] = 1;
	}

	for(int l = 2; l <= n; l++){
		int[] temp = new int[n-l+1];
		for(int i = 0; i+l <= n; i++){
			int j = i+l-1;
			if(l == 2){
				if(s.charAt(i) == s.charAt(j)){
					temp[i] = 2;
				}else temp[i] = 1;
			}else{
				if(s.charAt(i) == s.charAt(j)){
					temp[i] = dp2[i+1] + 2;
				}else{
					temp[i] = Math.max(dp1[i], dp1[i+1]);
				}
			}
		}
		dp2 = dp1;
        dp1 = temp;
	}
	return dp1[0];
}
}