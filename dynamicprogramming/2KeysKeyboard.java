//have sample array listed, inorder to obtain the least number of steps, you have to find the first lowest number which can divide given n and keep pasting that x number of times
//This solution is dp based
//Time complexity: O(n2)
//Space complexity: O(n)
public int minSteps(int n) {
	int[] dp = new int[n+1];
	for(int i = 2; i <=n; i++){
		dp[i] = i;
		int j = i-1;
		while(i%j != 0){
			j--;
		}

		dp[i] = dp[j] + (i/j);
	}

	return dp[n];
}


//If we observe clearly, lets take example 1*18, we determine there are 2*9. then 9 can derived as 3*3. then 3 can derived as 3*1;
//if you see we will be going from start(2), to determine what it has to multiply with. then we keep updating
public int minSteps(int n) {
	int res = 0;
	for(int i = 2; i <=n; i++){
		while(n%i == 0){
			res += i;
			n = n/i;
		}
	}

	return res;
}