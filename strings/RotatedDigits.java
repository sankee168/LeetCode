//This is brute force method of doing
//Time complexity: O(nlogn) as we iterate through every digit of a number
//Space complexity: O(logn)
public int rotatedDigits(int N) {
	int count = 0;
	for(int i = 1; i <= N; i++){
		if(goodNumber(i)) count++;
	}
	return count;
}

private boolean goodNumber(int num){
	String s = Integer.toString(num);
	boolean isSame = true;
	for(int i = 0; i < s.length(); i++){
		char curr = s.charAt(i);
		if(curr == '3' || curr == '4' || curr == '7') return false;
		if(curr == '2' || curr == '5' || curr == '6' || curr == '9') isSame = isSame && false;
		else isSame = isSame & true;
	}

	return !isSame;
}

//This is DP solution
//Time complexity: O(n)
//Space complexity: O(n)
public int rotatedDigits(int N) {
	int[] dp = new int[N+1];
	int count = 0;
	for(int i = 0; i < N+1; i++){
		if(i < 10){
			if(i == 3 || i == 4 || i == 7) dp[i] = 0;
			else if(i == 0 || i == 1 || i == 8) dp[i] = 1;
			else {
				dp[i] = 2; count++;
			}
		}
        else{
            int a = dp[i/10]; int b = dp[i%10];
		    if( a == 0 || b == 0) dp[i] = 0;
		    if( a == 1 && b == 1) {
			    dp[i] = 1;
		    }
		    else if( a >= 1 && b >= 1) {
			    dp[i] = 2;
			    count++;
		    }
        }
	}

	return count;
}