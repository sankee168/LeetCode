//Trim the spaces at the dn and keep increasing the count from that point till you see space
//return count
//Time complexity: O(n)
//Space complexity: O(1) where n is the length of the input string
public int lengthOfLastWord(String s) {
	if(s.length() == 0) return 0;
	int n = s.length()-1; int count = 0;
	while(n >= 0 && s.charAt(n) == ' ') n--;
	while(n >= 0 && s.charAt(n) != ' '){
    	n--; count++;
	}        
	return count;
}