public int[][] generateMatrix(int n) {
	int[][] arr = new int[n][n];
	int i = 0;
	int j = 0;
	int start = 1;
	while(n != 0){
		util(arr, i, j, start, n);		
		i++; j++; start += (n-1)*4;
		n = n/2;
	}

	return arr;
}

private void util(int[][] arr, int p, int q, int start, int n){
	int i = p; 
	int j = q;
	while(j < q+n){
		arr[i][[j] = start++;
		j++;
	}
	j--;
	while(i < p+n){
		arr[i][[j] = start++;
		i++;
	}
	i--;
	while(j >= q){
		arr[i][[j] = start++;
		j--;
	}
	j++;
	while(i > p){
		arr[i][[j] = start++;
		i--;
	}
}