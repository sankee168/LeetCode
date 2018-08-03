//Time complexity: O(n)
//Space complexity: O(n)
public int[] anagramMappings(int[] A, int[] B) {
	
	int[] arr = new int[A.length];
	Map<Integer, Integer> map = new HashMap<>();
	for(int i = 0; i < B.length; i++){
		map.put(B[i], i);
	}

	for(int i = 0; i < A.length; i++){
		arr[i] = map.get(A[i]);
	}
	return arr;
}