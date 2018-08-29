class Solution {
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