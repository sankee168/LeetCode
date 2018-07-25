//Time complexity : O(n2)
//Space complexity: O(n2)
public int countSubstrings(String s) {
	int count = 0;
	int n = s.length();
	int[][] arr = new int[n][n];
	for(int i = 0; i < n; i++){
		arr[i][i] = 1;
		count++;
	}
	for(int k = 1; k < n; k++){
		for(int i = 0; i < n-k; i++){
			int p = i;
			int q = i+k;
			if(k == 1 && s.charAt(p) == s.charAt(q)){
				arr[p][q] = 1;
				count++;
			}else{
				if(arr[p+1][q-1] == 1 && s.charAt(p) == s.charAt(q)){
					arr[p][q] = 1; count++;
				}
			}
		}
	}

	return count;
}