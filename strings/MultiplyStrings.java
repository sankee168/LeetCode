//Trick is to find the which index the sum of two numebrs in i and j indices go. Like old fashioned way of multiplying, 
//if you are multiplying i index of num1 and j index of num2 then that goes into i+j and i+j+1 index of the result string. 
//Time complexity: O(mn)
//Space complexity: O(m+n)
public String multiply(String num1, String num2) {
	int m = num1.length();
	int n = num2.length();
	int[] arr = new int[m+n];
	for(int i = m-1; i >= 0; i--){
		for(int j = n-1; j>=0; j--){
			int x = i+j;
			int y = i+j+1;
			int p = num1.charAt(i)-'0';
			int q = num2.charAt(j)-'0';
			int sum = arr[y] + p*q;
			arr[y] = sum%10;
			arr[x] += sum/10;
		}
	}

	StringBuilder sb = new StringBuilder();
	for(int curr: arr){
		if(!(sb.length() == 0 &&  curr == 0)){
			sb.append(curr);
		}
	}

	if(sb.length() == 0) return "0";
	return sb.toString();
}