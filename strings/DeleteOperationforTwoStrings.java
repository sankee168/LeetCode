//Here idea is to find the longest common subsequence of two strings
//lets say if x is the size of the longest common subsequence, then number of chracters to be deleted will be m+n-2*x;
//Now the question is how do we find the length of longest common subsequence

//There are multiple ways to implement longest common subsequence at different time compelxities
//Time complexity: O(2^(max(m, n)))
//Space complexity: O(max(m, n)) depth of recursion tree can go upto max(m, n)
 public int minDistance(String word1, String word2){
	int m = word1.length(); int n = word2.length();
	int x = lcs(word1, word2, m, n);
	return m+n-2*x;
}

private int lcs(String word1, String word2, int m, int n){
	if(m == 0 || n == 0) return 0;
	if(word1.charAt(m-1) == word2.charAt(n-1)){
		return 1 + lcs(word1, word2, m-1, n-1);
	}

	return Math.max(lcs(word1, word2, m-1, n), lcs(word1, word2, m, n-1));
}
//How do we optimize this? 
//We notice that there are subproblem which are getting computed multiple times
//Lets keep those in memory so that we can skip computing repeatedly

//Time complexity: O(mn) because we just have to fill the res array.
//Space complexity: O(mn) + O(max(m,n)) first one for res array and latter for recursion tree
public int minDistance(String word1, String word2){
	int m = word1.length(); int n = word2.length();
	int[][] res = new int[m+1][n+1];
	int x = lcs(word1, word2, m, n, res);
	return m+n-2*x;
}

private int lcs(String word1, String word2, int m, int n, int[][] res){
	if(m == 0 || n == 0) return 0;
	if(res[m][n] > 0) return res[m][n];
	if(word1.charAt(m-1) == word2.charAt(n-1)){
		res[m][n] = 1 + lcs(word1, word2, m-1, n-1, res);
	}
    else{
	    res[m][n] = Math.max(lcs(word1, word2, m-1, n, res), lcs(word1, word2, m, n-1, res));
    }
    return res[m][n];
}


//till now we have done top-botton computation, which resulted in recursion and more space complexity
//lets do bottom up, lets start from start of the string and apply the same formula. lets say dp[i][j] store the longest common subsequence length. then dp[i+1][j+1] can be computed as follows
//if char at i+1 and j+1 indices are same, then dp[i+1][j+1] = dp[i][j]+1 else max(dp[i][j+1], dp[i+1][j])
//time complexity: O(mn)
//space complexity: O(mn)
public int minDistance(String word1, String word2){
	int m = word1.length(); int n = word2.length();
	int[][] dp = new int[m+1][n+1];
	int x = lcs(word1, word2, m, n, dp);
	return m+n-2*x;
}

private int lcs(String word1, String word2, int m, int n, int[][] dp){
	for(int i = 0; i < m+1; i++){
		for(int j = 0; j < n+1; j++){
			if(i == 0 || j == 0){
				dp[i][j] = 0;
			}else{
				//note: we are storing i-1.j-1 result in i,j index because initial row and col
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
	}
	return dp[m][n];
}

//Can we optimize this even more? 
//Looking at the do array, we are just using the last row of it. So we can make that array of size n
//Time complexity: O(mn)
//Space complexity: O(n)
public int minDistance(String word1, String word2){
	int m = word1.length(); int n = word2.length();
	int[] dp = new int[n+1];
	int x = lcs(word1, word2, m, n, dp);
	return m+n-2*x;
}

private int lcs(String word1, String word2, int m, int n, int[] dp){
	for(int i = 0; i < m+1; i++){
		int[] dp1 = new int[n+1];
		for(int j = 0; j < n+1; j++){
			if(i == 0 || j == 0){
				dp1[j] = 0;
			}else{
				//note: we are storing i-1.j-1 result in i,j index because initial row and col
				if(word1.charAt(i-1) == word2.charAt(j-1)){
					dp1[j] = dp[j-1] + 1;
				}else{
					dp1[j] = Math.max(dp[j], dp1[j-1]);
				}
			}
		}
		dp = dp1;
	}
	return dp[n];
}