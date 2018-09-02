//we are iterating over the array and keeping every positive number if value-1 position
//once we are done with it we go over the array again and check if any index doesn't match expected value
//Time complexity: O(n)
//Space complexity: O(1)
public int firstMissingPositive(int[] A) {
	int i = 0;
	while(i < A.length){
		int curr = A[i];
		if(curr <= 0 || curr > A.length || (curr == A[curr-1])) i++;
		else if(curr != A[curr-1]) swap(A, i, curr-1);
		//else i++;
	}
	i = 0;
	while(i < A.length && A[i] == i+1) i++;
	return i+1;
}

private void swap(int[] A, int i, int j){
	int temp = A[i];
	A[i] = A[j];
	A[j] = temp;
}