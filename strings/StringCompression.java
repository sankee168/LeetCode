//Time complexity: O(n)
public int compress(char[] chars) {
	int index = 0; int ansIndex = 0;
	while(index < chars.length){
		char curr = chars[index];
		int count = 0;
		while(index < chars.length && chars[index] == curr){
			index++; count++;
		}
		chars[ansIndex++] = curr;
		if(count > 1){
			for(char tmp: Integer.toString(count).toCharArray()){
				chars[ansIndex++] = tmp;
			}
		}
	}
	return ansIndex;
}