//This solves the problem but very bad way
//Idea here is simple enough. To determine if i-j is arithmetic slice, we need to determine i- j-1 is arithmetic slice and j- j-1 holds the same difference
//Time complexity: O(n2)
//Space complexity: O(n)
public int numberOfArithmeticSlices(int[] A){
	if(A.length < 3) return 0;
	int[] arr = new int[A.length-2];
	int count = 0;
	for(int i = 0; i < A.length-2; i++){
		if(A[i+1]-A[i] == A[i+2]-A[i+1]){
			arr[i] = 1; count++;
		}
	}

	int k = 3;
	while(k < A.length){
		int[] arr1 = new int[A.length-k];
		for(int i = 0; i < A.length-k; i++){
			if(arr[i] == 1 && A[i+k]-A[i+k-1] == A[i+1]-A[i]){
				arr1[i] =1; count++;
			}
		}
		k++; arr = arr1;
	}

	return count;
}


//extending the same approach
//Time complexity: O(n)
//Space complexity: O(n)
public int numberOfArithmeticSlices(int[] A){
	int[] dp = new int[A.length];
	int sum = 0;
	for(int i = 2; i < A.length; i++){
		if(A[i]-A[i-1] == A[i-1]-A[i-2]){
			dp[i] = dp[i-1]+1;
			sum += dp[i];
		}
	}
	return sum;
}

//if you see the above problem we are just using the previous dp[i] value
//so rather than using an array, we just store the previous element if not set to 0
public int numberOfArithmeticSlices(int[] A){
	int dp = 0;
	int sum = 0;
	for(int i = 2; i < A.length; i++){
		if(A[i]-A[i-1] == A[i-1]-A[i-2]){
			dp++;
			sum += dp;
		} else{
			dp = 0;
		}
	}
	return sum;
}
