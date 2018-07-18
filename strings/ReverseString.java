//Time complexity: O(n)
//Space complexity: O(n) where n is the size of the string
public String reverseString(String s) {
	char[] arr = s.toCharArray();
	int i = 0;
	int j = arr.length-1;
	while(i < j){
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		i++; j--;
	}
	return String.valueOf(arr);
}