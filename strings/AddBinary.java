//Time complexity: O(max(m, n)) where m and n are length of a and b
//Space complexity: O(max(m, n)) size of resultant string will be proportioan to it
public String addBinary(String a, String b) {
	String res = "";
	int i = a.length()-1;
	int j = b.length()-1;
	boolean carry = false;
	while(i >= 0 || j >= 0){
		int count = 0;
		if(i >= 0 && a.charAt(i) == '1') count++;
		if(j >= 0 && b.charAt(j) == '1') count++;
		if(carry) count++;
		int rem = count%2;
		res = rem + res;
		int currDigit = count/2;
		if(currDigit == 1) carry = true;
        else carry = false;
        i--; j--;
	}
    if(carry) res = 1 + res;
	return res;
}

//Note: we can use string builder too. keep appending to the end and reverse it in the last