//Looking at each use case properly, we can go character to character
//Here we did a dfs approach
//where dp[i][j] = dp[i-1][j-1] when s1[i] == s2[j]
// else we have to find the minDistance if we replace the ith char with jth char
// or if we delete the ith char
// or if we add the ith char
//This gives a recurrence relation for dynamic programming problem
//Time complexity: O(mn) as we are computing the dp matrix only once
//Space complexity: O(mn) for dp
//We can reduce the space complexity if we do a bottom up approach
public int minDistance(String word1, String word2) {
	if(word1.equals(word2)) return 0;
	int m = word1.length();
	int n = word2.length();
	int[][] dp = new int[m][n];
    for(int[] row : dp){
        Arrays.fill(row, -1);
    }
	return util(word1, m-1, word2, n-1, dp);
}

private int util(String word1, int i, String word2, int j, int[][] dp){
	if(i < 0) return j+1;
	if(j < 0) return i+1;
	if(dp[i][j] != -1) return dp[i][j];
	if(word1.charAt(i) == word2.charAt(j)){
		dp[i][j] = util(word1, i-1, word2, j-1, dp);
	}else{
		int insert = util(word1, i-1, word2, j, dp);
		int replace = util(word1, i-1, word2, j-1, dp);
		int delete  = util(word1, i, word2, j-1, dp);
		dp[i][j] = 1 + Math.min(Math.min(insert, replace), delete);
	}
	return dp[i][j];
}