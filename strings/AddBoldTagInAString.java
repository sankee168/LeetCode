//Idea here is to iterate through the string and check if any of the word in dictionary starts with ith index
//if so mark ith index to end of word to true in a boolean array
//Time complexity: O(nw) where n is the length of s and w is the sum of the lengths of words in dictionary
//Space complexity: O(n) for boolean array
public String addBoldTag(String s, String[] dict) {
	boolean[] arr = new boolean[s.length()];
	int end = -1;
	for(int i = 0; i < s.length(); i++){
		for(String curr: dict){
			if(s.startsWith(curr, i)) {
				end = Math.max(end, i+curr.length());
			}
		}
		if(end != -1){
			for(int j = i; j < end; j++){
				arr[j] = true;
			}
			end = -1;
		}
	}

	StringBuilder sb = new StringBuilder();
	for(int i = 0; i < s.length(); i++){
		if(!arr[i]) sb.append(s.charAt(i));
		else{
			int j = i;
			while(j < s.length() && arr[j]){
				j++;
			}
			sb.append("<b>" + s.substring(i, j) + "</b>");
			i = j-1;
		}
	}
	return sb.toString();
}