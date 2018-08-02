//Time complexity: O(n)
//Space complexity: O(n) for char array
public String reverseStr(String s, int k) {
	char[] arr = s.toCharArray();
	int i = 0, j = 0;
	while(j<arr.length && j<i+2*k){
		if(j == i+2*k-1){
			int p = i+k-1;
            reverse(arr, i, p);			
			i = j+1;
		}
		j++;
	}
	if(j-i < k){
		int p = j-1;
		reverse(arr, i, p);
    }
	if(j-i >= k && j-i < 2*k){
		int p = i+k-1;
		reverse(arr, i, p);
	}

	return String.valueOf(arr);
 }
    
    
 private void reverse(char[] arr, int p, int q){
     while(p < q){
         char tmp = arr[p];
         arr[p] =  arr[q];
         arr[q] = tmp;
         p++; q--;
     }
 }

 //this is easier way of writing code with same complexity
 public String reverseStr(String s, int k){
 	char[] arr = s.toCharArray();
 	for(int i = 0; i < s.length; i += 2*k){
 		int start = i;
 		int end = Math.min(start+k-1, arr.length-1);
 		while(start < end){
 			reverse(arr, start, end);
 		}
 	}
 	return String.valueOf(arr);
 }