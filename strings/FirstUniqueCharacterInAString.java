//We iterate over the chars in given string and increment value in the arr at that index.
//Second loop is to iterate over the string again and return if first occurance of the character is 1, if so return index
//time complexity: O(n)
//Space complexity: O(1) as int array is of constant space
public int firstUniqChar(String s) {
	int[] arr = new int[26];
	for(int i = 0; i < s.length(); i++){
		arr[s.charAt(i)-'a']++;
	}

	for(int i = 0; i < s.length(); i++){
		if(arr[s.charAt(i)-'a'] == 1) return i;
	}
	return -1;
}