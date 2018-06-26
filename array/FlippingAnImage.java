//Time complexity: O(n) as we are traversing through all elements once. 
//Space complexity: O(1)
public int[][] flipAndInvertImage(int[][] A) {
	for(int i = 0; i < A.length; i++){
		int p = 0;
		int q = A[i].length-1;
		while(p <= q){
			if(p == q){
				A[i][p] ^= 1;
			}else{
				int temp = A[i][p];
				A[i][p] = 1^A[i][q];
				A[i][q] = 1^temp;
			}
			p++; q--;
		}
	}

	return A;
}