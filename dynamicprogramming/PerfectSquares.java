//Time complexity: O(nk) where k is the number of squares less than n
//Space complexity: O(n)
public int numSquares(int n) {
	int[] arr = new int[n+1];
	int i = 0;
	while(i*i <= n){
		arr[i*i] = 1;
		i++;
	}

	for(i = 2; i <= n; i++){
		if(arr[i] != 1){			
			int min = Integer.MAX_VALUE;
			int j = 1;
			while(i-j*j > 0){
				min = Math.min(min, arr[i-j*j]+1);
				j++;
			}
			arr[i] = min;
		}
	}
	return arr[n];
}