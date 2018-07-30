//Inorder to calculate length of max letters, we initialize dp array of length n+1, dp[i] represents the max length at ith key
//So dp[i] will be either i strikes of A or j strikes of A and copy paste after that. which ever has max value will be number of As
//Time complexity: O(n2)
//Space complexity: O(n)
public int maxA(int n) {
    int[] dp = new int[n + 1];
    for (int i = 0; i <= n; i++) {
        dp[i] = i;
        for (int j = 1; j <= i - 3; j++)
            dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
    }
    return dp[n];
}