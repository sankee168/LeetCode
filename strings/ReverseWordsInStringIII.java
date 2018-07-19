//time complexity: O(n)
//space complexity: O(n) where n is the size of the string. 
public String reverseWords(String s) {
	char[] arr = s.toCharArray();
	for(int i = 0; i < arr.length; i++){
		int j = i;
		
		while(j < arr.length && arr[j] !=  ' '){
			j++;
		}

		int p = i; int q = j;
		if(q != arr.length){
			q = q-1;			
		}
		while(p < q){
			char temp = arr[p];
			arr[p] = arr[q];
			arr[q] = temp;
			p++;
			q--;
		}
		i = j;
	}

	return String.valueOf(arr);
}