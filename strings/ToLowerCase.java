//Time complexity: O(n)
//Space complexity: O(n)
public String toLowerCase(String str) {
	char[] arr = str.toCharArray();
	for(int i = 0; i < arr.length; i++){
		if(arr[i] <= 'Z' && arr[i] >= 'A'){
			arr[i] = (char)('a' + (arr[i] - 'A'));
		}
	}

	return String.valueOf(arr);
}