//RotateString
//To make A to B one character from start of A is removed and appended to end of A
//we have to return if there is a chance of A becoming B

//Simple approach is to append two A string and check if B exists of not
public boolean rotateString(String A, String B) {
	if(A.length() != B.length()) return false;
	return (A+A).indexOf(B) != -1;
}


//Another idea is to iterate through A and find the first char of B
//keep checking if all the chars in B are in A
//else keep on iterating from the fist loop


public boolean rotateString(String A, String B){
	if(A.length() != B.length()) return false;
	if(A.equals("")) return true;
	int m = A.length();
	for(int i  = 0; i < m; i++){
		if(A.charAt(i) == B.charAt(0)){
			int j = i;
			int k = 0;
			while(k < m && A.charAt(j) == B.charAt(k)){
				k++;
				j = (j+1)%m;
			}
			if(k == m) return true;
		}
	}
	return false;
}