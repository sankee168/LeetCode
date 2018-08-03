//Trick is to do step by step, first lets reverse the string, then reverse the words, 
//last is clean trailing spaces and cut down multiple spaces to one space. 
//Time complexity: O(n)
//Space complexity: O(n) for char array
public String reverseWords(String s) {
	char[] a = s.toCharArray();
	reverse(a);
	reverseWords(a);
	return cleanSpaces(a);
}

private void reverse(char[] a){
	int i = 0, j = a.length-1;
	while(i < j){
		char tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
		i++; j--;
	}
}

private void reverseWords(char[] a){
	int i = 0, j =0;
	int n = a.length;
	while(i < n){
		while(i < n && a[i] == ' ') i++;
		j = i;
		while(j < n && a[j] != ' ') j++;
		int p = i;
		int q = j-1;
		while(p < q){
			char tmp = a[p];
			a[p] = a[q];
			a[q] = tmp;
			p++; q--;
		}
		i = j;
	}
}

private String cleanSpaces(char[] a){
	int i = 0, j = 0;
	int n = a.length;
	while(j < n){
		while(j < n && a[j] == ' ') j++;
		while(j < n && a[j] != ' ') {a[i++] = a[j++];}
		while(j < n && a[j] == ' ') j++;
		if(j < n) a[i++] = ' ';
	}
	return String.valueOf(a).substring(0, i);
}