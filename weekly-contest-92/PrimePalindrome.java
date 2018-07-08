//complete this
public int primePalindrome(int N) {
	int next = generateNextPalindrome(N);
	while(!isPrime(next)){
		next = generateNextPalindrome(next);
	}
	retrun next;
}

private int[] convertIntoIntArray(int N){
	int temp = N;
	int n = 1;
	while(temp/10 != 0){
		n++; temp = temp/10;
	}
	temp = N;
	int[] arr = new int[n];
	int p = n-1;
	while(temp != 0 && p >= 0){
		arr[p] = temp%10;
		temp = temp/10;
		p--;
	}
	return arr;
}
private int generateNextPalindrome(int N){
	int[] arr = convertIntoIntArray(N);
	int n = arr.length;
	int i = 0;
	int j = 0;
	if()
	
}

private boolean isPrime(int n){
	if(n <= 1) return false;
	for(int i = 2; i < Math.sqrt(n); i++){
		if(n%i == 0) return false;
	}
	return true;
}