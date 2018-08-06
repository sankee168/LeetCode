//Both the below solutions are of same. first one doesn't use the substring method in string
//Time complexity: O(m) where m is the length of haystack
//Space complexity: O(1)
public int strStr(String haystack, String needle) {
	int m = haystack.length();
	int n = needle.length();
	if(n == 0) return 0;
	if(n > m) return -1;
	for(int i = 0; i <= m-n; i++){
		if(haystack.charAt(i) == needle.charAt(0)){
			int p = i+1, q = 1;
			while(p < m && q < n && haystack.charAt(p) == needle.charAt(q)){
				p++; q++;
			}
			if(q == n) return i;
		}
	}
	return -1;
}


public int strStr(String haystack, String needle) {
	int m = haystack.length();
	int n = needle.length();
	if(n > m) return -1;
	if(n == 0) return 0;
	for(int i = 0; i <= m-n; i++){
		if(haystack.substring(i, i+n).equals(needle)) return i;
	}
	return -1;
}