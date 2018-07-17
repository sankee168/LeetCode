public int[] constructArray(int n, int k) {
	int[] arr = new int[n];
	for(int i = 1; i < n-k+1; i++){
		arr[i-1] = i;
	}

	int l = n-k;
	int r = n;

	for(int i = n-k+1; i <=n; i++){
		if(k%2 == 0){
			arr[i] = l;
			l++; k--;
		}else {
			arr[i] = r;
			r--; k--;
		}
	}
	return arr;

}