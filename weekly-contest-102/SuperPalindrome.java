public int superpalindromesInRange(String L, String R) {
	int low = L.length;
	int high = R.length;
	int count = 0;
	for(int i = low; i <= high; i++){
		List<String> palindromes = generatePalindromes(i);
		for(String palindrome : palindromes){
			if(i > low && i < high && isSquare(palindrome)){
				count++;
			}else if(i == low && palindrome >= L && isSquare(palindrome)) count++;
			else if(i == R && palindrome <= R && isSquare(palindrome)) count++;
		}
	}
	return count;
}

private List<String> generatePalindromes(int size){
	char[] arr = new char[size];
	List<String> list = new ArrayList<>();
	util(arr, 0, size-1, list);
	return list;
}

private void util(char[] arr, int i, int j, List<String> list){
	if(i > j) list.add(String.valueOf(arr));
	for(int k = 0; k < 10; k++){
		if(i == 0 && k == 0) continue;
		arr[i] = (char)(k);
		arr[j] = (char)(k);
		util(arr, i+1, j-1, list);
	}
}

private boolean isSquare(String number){
	long curNumber = Long.parseLong(number);
	while(isPalindrome(currNumber)){
		if(isPrime(curNumber)) return true;	
		double sqrt = Math.sqrt(curNumber);
		long x = (long) sqrt;
		if(Math.pow(sqrt,2) != Math.pow(x,2)) return false;
		else{
			currNumber = sqrt;
		}
	}
}

public boolean isPrime(long N) {
        if (N < 2) return false;
        long R = (long) Math.sqrt(N);
        for (long d = 2; d <= R; ++d)
            if (N % d == 0) return false;
        return true;
  	}

public boolean isPalindrome(long x) {
        if(x < 0 || (x%10 == 0 && x != 0)) return false;
        
        long t = 0;
        while(x > t){
            t = 10*t + x%10;
            x = x/10;
        }
        
        return (t/10 == x) || (t == x);
    }