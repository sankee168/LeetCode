//Solution 1
//Here we check if a given number is prime or not by dividing it by 2 to n/2
//Time complexity: O(n2)
public int countPrimes(int n) {
	int count = 0;
	for(int i = 2; i < n; i++){
		if(isPrime(i)) count++;
	}
	return count;
}

private boolean isPrime(int num){
	for(int i = 2; i <= num/2; i++){
		if(num%i == 0) return false;
	}
	return true;
}

//Solution 2
//We can check if a number is prime or not by checking till sqrt(n)
//Time complexity: O(n^1.5)
public int countPrimes(int n) {
	int count = 0;
	for(int i = 2; i < n; i++){
		if(isPrime(i)) count++;
	}
	return count;
}

private boolean isPrime(int num){
	for(int i = 2; i*i <= num; i++){
		if(num%i == 0) return false;
	}
	return true;
}

//Here we use the each prime number and multiply with i till it is less than n
//result number is not a prime number. so we mark in the boolean array as true
//we keep doing this till sqrt(n). 
//Time complexity: O(n)
//Space complexity: O(n)
public int countPrimes(int n){
	if(n < 2) return 0;
	boolean[] isNotPrime = new boolean[n];
	isNotPrime[0] = true;
	isNotPrime[1] = true;
	for(int i = 2; i*i <= n; i++){
		if(isNotPrime[i]) continue;
		for(int j = 2; i*j <n; j++){
			isNotPrime[i*j] = true;
		}
	}
	int count = 0;
	for(int i = 0; i < n; i++){
		if(!isNotPrime[i]) count++;
	}
	return count;
}