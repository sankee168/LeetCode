//Time complexity: O(n)
//Space complexity: O(1)
//we create a integer array of length 26 as it is given that input contains only lower case chars
//we increase the char's index value for string s and decrease for string t
//if some value goes less than 0, that means they are not anagrams
public boolean isAnagram(String s, String t) {
	if(s.length() != t.length()) return false;
	int[] arr = new int[26];
	for(int i = 0; i < s.length(); i++){
		arr[s.charAt(i)-'a']++;
	}

	for(int i = 0; i < t.length(); i++){
		arr[t.charAt(i)-'a']--;
		if(arr[t.charAt(i)-'a'] < 0) return false;
	}

	return true;
}