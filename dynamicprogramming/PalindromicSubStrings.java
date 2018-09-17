//Time complexity : O(n2)
//Space complexity: O(n2)
public int countSubstrings(String s) {
    int m = s.length();
    int count = 0;
	boolean[][] isPalindrome = new boolean[m][m];
    for(int i = 0; i < m; i++){
        isPalindrome[i][i] = true;
        count++;
    }
    for(int k = 1; k < m; k++){
        for(int i = 0; i+k < m; i++){
            int j = i+k;
            if(k == 1){
                if(s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;
                    count++;
                }
            }else{
                if(isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j)) {
                    isPalindrome[i][j] = true;   
                    count++;
                }
            }
        }
    }
	return count;
}

//This is bit optmized on space complexity wise. rather than using O(n2) we are using only second from last updated row
//So we are keeping two rows in memory
//Time complexity: O(n2)
//Space complexity: O(n)
public int countSubstrings(String s) {
    int m = s.length();
    int count = 0;
	boolean[] l2 = new boolean[m];
	boolean[] l1 = new boolean[m-1];
    for(int i = 0; i < m; i++){
        l2[i] = true;
        count++;
    }

    for(int i = 0; i < m-1; i++){
    	if(s.charAt(i) == s.charAt(i+1)){
    		l1[i] = true;
            count++;
    	}
    }
    for(int k = 2; k < m; k++){
    	boolean[] temp = new boolean[m-k];
        for(int i = 0; i+k < m; i++){
            int j = i+k;
            if(l2[i+1] && s.charAt(i) == s.charAt(j)) {
                temp[i] = true;   
                count++;
            }
        }
        l2 = l1;
        l1 = temp;
    }
	return count;
}



//another solution is expanding from the center
//we know that there can be 2*n-1 places where palindrome center may exist
//which means either they start between two letters or on the same letter
//we expand from each of those places and check if left and right are same. 
//if so increase the count
public int countSubstrings(String s) {
	int n = s.length();
	int res = 0;
	for(int i = 0; i < (2*n - 1); i++){
		int center = i;
		int left = center/2;
		int right = left+ center%2;
		while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
			res++;
			left--;
			right++;
		}
	}
	return res;
}