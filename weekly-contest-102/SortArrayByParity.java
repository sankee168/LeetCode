//if we see that there is a pointer in the ith index, then we swap with jtih index
public int[] sortArrayByParity(int[] A) {
	int i = 0, j = A.length-1;
	while(i < j){
		if(A[i] % 2 == 1){
			int temp = A[j];
			A[j] = A[i];
			A[i] = temp;
			j--; 
		}else{
			i++;
		}
	}
	return A;
}