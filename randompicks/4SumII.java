//Time complexity: O(n2)
//Space complexity: O(n2)
public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
	Map<Integer, Integer> first = new HashMap<>();
	int n = A.length;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			int sum = A[i] + B[j];
			first.put(sum, first.getOrDefault(sum, 0)+1);
		}
	}

	int count = 0;
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++){
			int sum = C[i] + D[j];
			if(first.containsKey(-sum)){
				count+=first.get(-sum);
			}
		}
	}
	return count;
}