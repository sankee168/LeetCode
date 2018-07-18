//Space compelxity: O(n)
//Time complexoty: O(n)
public String reverseVowels(String s) {
	char[] arr = s.toCharArray();
	Set<Characters> set = new HashSet<>();
	set.add('a');
	set.add('e');
	set.add('i');
	set.add('o');
	set.add('u');
	set.add('A');
	set.add('E');
	set.add('I');
	set.add('O');
	set.add('U');	
	int i = 0; int j = arr.length-1;
	while(i < j){
		if(set.contains(arr[i]) && set.contains(arr[j])){
			char temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++; j--;
		}
		if(!set.contains(arr[i])) {i++;}
		if(!set.contains(arr[j])) {j--;}
	}
	return String.valueOf(arr);
}