//Time complexity: O(n) as we are iterating through the string once
//Space complexity : O(1) as we didn't use any extra space
public boolean isPalindrome(String s) {
	int i = 0, j = s.length()-1;
	while(i < j){
		char a = Character.toLowerCase(s.charAt(i));
		char b = Character.toLowerCase(s.charAt(j));
		if(!((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) i++;
		if(!((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) j--;
		if(a != b) return false;
	}
	return true;
}