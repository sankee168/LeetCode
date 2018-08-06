//here the value of dp problem is the count of number of strings till ith index and formula is sum of last two values if it is valid char with previous element
//time complexity: O(n) where n is the length of string s
//space complexity: O(n) for storing the array
public int numDecodings(String s) {
    if(s.length() == 0) return 0;
	int[] arr = new int[s.length()+1];
	arr[0] = 1; arr[1] = (s.charAt(0) == '0') ? 0 : 1;
	for(int i = 1; i < s.length(); i++){
		int left = s.charAt(i-1) - '0';
		int right = s.charAt(i) - '0';
		if((10*left + right) <= 26 && (10*left + right) >= 10){
			arr[i+1] = arr[i-1];
		}
        if(right > 0 && right <= 9) {arr[i+1] += arr[i];}
	}
	return arr[s.length()];
}