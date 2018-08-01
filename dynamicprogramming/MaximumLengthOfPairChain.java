//This is a dp solution. 
//lets say dp[i] store the max length of the chain starting at ith index. 
//Inorder to determine that, we start from end and keep check if that can be attached the ith pair, and check what is the maximum length acheived. 
//Time complexity: O(n2)
//Space complexity: O(n)
public int findLongestChain(int[][] pairs) {
	Arrays.sort(pairs, new PairComparator());
	int[] dp = new int[pairs.length];
	for(int i = pairs.length-1; i >= 0; i--){
		dp[i] = 1;
		for(int j = i+1; j < pairs.length; j++){
			if(pairs[i][1] < pairs[j][0]){
				dp[i] = Math.max(dp[i], dp[j]+1);
			}else dp[i] = Math.max(dp[i], dp[j]);
		}
	}

	return dp[0];
}

class PairComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] i1, int[] i2){
		if(i1[0] < i2[0]) return -1;
		if(i1[0] == i2[0]){
			if(i1[1] < i2[1]) return -1;
			else if(i1[1] == i2[1]) return 0;
			else return 1;
		}
		else return 1;
	}
}

//We can also do greedy way, if we sort based on the second element in pair then we can always pick the pair with smallest end

public int findLongestChain(int[][] pairs) {
	Arrays.sort(pairs, new PairComparator());
	int[] dp = new int[pairs.length];
	for(int i = pairs.length-1; i >= 0; i--){
		dp[i] = 1;
		for(int j = i+1; j < pairs.length; j++){
			if(pairs[i][1] < pairs[j][0]){
				dp[i] = Math.max(dp[i], dp[j]+1);
			}else dp[i] = Math.max(dp[i], dp[j]);
		}
	}

	return dp[0];
}

class PairComparator implements Comparator<int[]> {
	@Override
	public int compare(int[] i1, int[] i2){
		if(i1[0] < i2[0]) return -1;
		if(i1[0] == i2[0]){
			if(i1[1] < i2[1]) return -1;
			else if(i1[1] == i2[1]) return 0;
			else return 1;
		}
		else return 1;
	}
}
